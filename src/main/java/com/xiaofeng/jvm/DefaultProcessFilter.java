package com.xiaofeng.jvm;

import com.xiaofeng.jvm.entity.ProcessInfo;

public class DefaultProcessFilter implements IProcessInfoFilter{

	@Override
	public boolean accept(ProcessInfo processInfo) {

		return !(processInfo.getMain() == null || processInfo.getMain().trim().length() == 0);
	}

}
