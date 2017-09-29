package com.xiaofeng.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by xiaofeng on 2017/9/29
 * Description:
 */
public class LongEventFactory implements EventFactory<LongEvent>
{
	public LongEvent newInstance()
	{
		return new LongEvent();
	}
}