package com.xiaofeng.guava.EventBus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.Data;
import org.apache.flume.conf.source.SourceType;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaofeng on 2017/10/26
 * Description:
 */
public class EventBusTest
{
	public static void main(String[] args)
	{
		EventBus eventBus = new EventBus();

		eventBus = new AsyncEventBus(Executors.newFixedThreadPool(10));

		eventBus.register(new Object(){
			@Subscribe
			public void handlerUserInfoChangeEvent(UserInfoChangeEvent userInfoChangeEvent)
			{
				System.out.println("handle userinfo change event: " + userInfoChangeEvent.getUserName());
			}
			@Subscribe
			public void handlerUserInfoChangeEvent(BaseEventBusEvent baseEventBusEvent)
			{
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("all event");
			}
		});
		eventBus.post(new UserInfoChangeEvent("xiaofeng"));
	}

	static class BaseEventBusEvent{}

	@Data
	static class UserInfoChangeEvent extends BaseEventBusEvent
	{
		private String userName;

		public UserInfoChangeEvent(String userName)
		{
			this.userName = userName;
		}


	}
}