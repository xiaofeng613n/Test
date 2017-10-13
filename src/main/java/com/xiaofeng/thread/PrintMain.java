package com.xiaofeng.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiaofeng on 2017/10/13
 * Description:
 */
public class PrintMain {

	static final Lock lock = new ReentrantLock();
	static final Condition threadAPrint = lock.newCondition();
	static final Condition threadBPrint = lock.newCondition();

	static int num1 = 0;
	static int num2 = 1;
	static int end = 100;

	volatile static int state = 0;

	public static void main(String args[]) {

		final Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					/**
					 * 获取锁,获取锁不成功时,当前线程休眠,直到获取锁,继续执行
					 */
					lock.lock();
					try {
						if (state == 1) {
							try {

								/**
								 * Causes the current thread to wait until it is signalled or
								 * {Thread#interrupt interrupted}.
								 *
								 * The lock associated with this {Condition} is atomically
								 * released and the current thread becomes disabled for thread scheduling
								 * purposes and lies dormant until <em>one</em> of four things happens...
								 */
								threadAPrint.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						state = 1;
						if (num1 >= end) {
							break;
						}
						System.out.println("A"+ num1);
						num1 += 2;
						/**
						 * Wakes up one waiting thread.
						 */
						threadBPrint.signal();
					} finally {
						lock.unlock();
					}
				}
			}
		});

		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {

				while (true) {
					lock.lock();

					try {
						if (state == 0) {
							try {
								threadBPrint.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						state = 0;
						if (num2 >= end) {
							break;
						}
						System.out.println("B"+num2);
						num2 += 2;
						threadAPrint.signal();
					} finally {
						lock.unlock();
					}
				}

			}
		});

		threadA.start();
		threadB.start();
	}
}