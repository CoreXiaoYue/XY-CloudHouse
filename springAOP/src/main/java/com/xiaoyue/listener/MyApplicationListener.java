package com.xiaoyue.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
/**
 * @author Administrator  监听事件
 *
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent>{

	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("收到通知："+event);
	}

}
