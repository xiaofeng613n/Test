package com.xiaofeng.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaofeng on 2018/4/9
 * Description:
 */
public class SelectSocketsThreadPool extends SelectSockets {
    private static final int MAX_THREADS = 2;
    private ThreadPool pool = new ThreadPool(MAX_THREADS);

    public static void main(String[] argv) throws Exception {
        new SelectSocketsThreadPool().go(argv);
    }
// -------------------------------------------------------------
    /**
     * Sample data handler method for a channel with data ready to read. This
     * method is invoked from the go( ) method in the parent class. This handler
     * delegates to a worker thread in a thread pool to service the channel,
     * then returns immediately.
     *
     * @param key
     * A SelectionKey object representing a channel determined by the
     * selector to be ready for reading. If the channel returns an
     * EOF condition, it is closed here, which automatically
     * invalidates the associated key. The selector will then
     * de-register the channel on the next select call.
     */
    protected void readDataFromSocket(SelectionKey key) throws Exception {
        WorkerThread worker = pool.getWorker();
        if (worker == null) {
            return;
        }
        // Invoking this wakes up the worker thread, then returns
        worker.serviceChannel(key);
    }
// ---------------------------------------------------------------
    /**
     * A very simple thread pool class. The pool size is set at construction
     * time and remains fixed. Threads are cycled through a FIFO idle queue.
     */
    private class ThreadPool {
        List idle = new LinkedList();
        ThreadPool(int poolSize) {
// Fill up the pool with worker threads
            for (int i = 0; i < poolSize; i++) {
                WorkerThread thread = new WorkerThread(this);
// Set thread name for debugging. Start it.
                thread.setName("Worker" + (i + 1));
                thread.start();
                idle.add(thread);
            }
        }
        /**
         * Find an idle worker thread, if any. Could return null.
         */
        WorkerThread getWorker() {
            WorkerThread worker = null;
            synchronized (idle) {
                if (idle.size() > 0) {
                    worker = (WorkerThread) idle.remove(0);
                }
            }
            return (worker);
        }

        void returnWorker(WorkerThread worker) {
            synchronized (idle) {
                idle.add(worker);
            }
        }
    }
    private class WorkerThread extends Thread {
        private ByteBuffer buffer = ByteBuffer.allocate(1024);
        private ThreadPool pool;
        private SelectionKey key;
        WorkerThread(ThreadPool pool) {
            this.pool = pool;
        }
        public synchronized void run() {
            System.out.println(this.getName() + " is ready");
            while (true) {
                try {
                    // Sleep and release object lock
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    this.interrupted();
                }
                if (key == null) {
                    continue; // just in case
                }
                System.out.println(this.getName() + " has been awakened");
                try {
                    drainChannel(key);
                } catch (Exception e) {
                    System.out.println("Caught '" + e+ "' closing channel");
                    try {
                        key.channel().close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    key.selector().wakeup();
                }
                key = null;
                // Done. Ready for more. Return to pool
                this.pool.returnWorker(this);
            }
        }

        synchronized void serviceChannel(SelectionKey key) {
            this.key = key;
            key.interestOps(key.interestOps() & (~SelectionKey.OP_READ));
            this.notify(); // Awaken the thread
        }
        void drainChannel(SelectionKey key) throws Exception {
            SocketChannel channel = (SocketChannel) key.channel();
            int count;
            buffer.clear(); // Empty buffer
            // Loop while data is available; channel is nonblocking
            while ((count = channel.read(buffer)) > 0) {
                buffer.flip(); // make buffer readable
                while (buffer.hasRemaining()) {
                    channel.write(buffer);
                }
                buffer.clear(); // Empty buffer
            }
            if (count < 0) {
                channel.close();
                return;
            }
            // Resume interest in OP_READ
            key.interestOps(key.interestOps() | SelectionKey.OP_READ);
            // Cycle the selector so this key is active again
            key.selector().wakeup();
        }
    }
}