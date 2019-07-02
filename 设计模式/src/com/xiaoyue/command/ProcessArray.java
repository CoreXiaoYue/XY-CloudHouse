package com.xiaoyue.command;

public class ProcessArray {
	//
	/**
	 * @param arrays int类型数组
	 * @param command 处理的接口类
	 */
	public void each(int[] arrays,Command command) {
		command.process(arrays);
	}

	
}
