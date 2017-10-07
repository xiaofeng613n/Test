package com.xiaofeng.disruptor.test;

/**
 * Created by xiaofeng on 2017/10/7
 * Description:http://www.cnblogs.com/haiq/p/4112689.html
 */
public class Main
{
	public static void main(String[] args)
	{
		int DATA_COUNT = 1048576;
		CounterTracer tracer = new SimpleTracer(DATA_COUNT);//计数跟踪到达指定的数值；
		TestHandler handler = new TestHandler(tracer);//Consumer 的事件处理；

		// publisher = publisherFactory.newInstance(new PublisherCreationArgs(DATA_COUNT, handler));//通过工厂对象创建不同的 Producer 的实现；
		//EventPublisher publisher = new BlockingQueuePublisher(100,handler);
		EventPublisher publisher = new DisruptorPublisher(1024*1024,handler);

		publisher.start();
		tracer.start();

		//发布事件；
		for (int i = 0; i < DATA_COUNT; i++)
		{
			//System.out.println(i);
			publisher.publish(i);
		}
		System.out.println("发布完成!");

		//等待事件处理完成；
		tracer.waitForReached();
		publisher.stop();
		//输出结果；
		printResult(tracer);
	}

	private static void printResult(CounterTracer tracer)
	{
		System.out.println(tracer.toString());
	}
}