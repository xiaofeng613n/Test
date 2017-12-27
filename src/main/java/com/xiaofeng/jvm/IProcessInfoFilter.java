package com.xiaofeng.jvm;

import com.xiaofeng.jvm.entity.ProcessInfo;

public interface IProcessInfoFilter {

	public boolean accept(ProcessInfo processInfo);
}
