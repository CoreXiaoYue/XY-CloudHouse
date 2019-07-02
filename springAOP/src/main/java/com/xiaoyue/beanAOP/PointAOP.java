package com.xiaoyue.beanAOP;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class PointAOP {
	/* 
	 *  @Before:前置通知   
	 *  @After:后置通知
	 *  @AfterReturning:方法正常执行完通知
	 *  @AfterThrowing：方法发生异常，执行通知
	 *   
	 *   
	 *  
	 *  
	 **/
	
	@Pointcut("execution(* com.xiaoyue.service.*.*(..))")// the pointcut expression
	private void pointCut() {}// the pointcut signature
	
	
//	@Before(value="execution(public * com.xiaoyue.Dao.*.*(..))")
//	@Before(value="pointCut()")
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println(""+joinPoint.getSignature().getName()+"运行。。。@Before:参数列表是：{"+Arrays.toString(joinPoint.getArgs())+"}");
	}
	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println("执行方法："+joinPoint.getSignature().getName()+"之后。");
	}
	@AfterReturning(pointcut="pointCut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result) {
		System.out.println(""+joinPoint.getSignature().getName()+"正常返回。。。@AfterReturning:运行结果：{"+result+"}");
	}
	@AfterThrowing(pointcut="pointCut()",throwing="exception")
	public void logException(JoinPoint joinPoint,Exception exception) {
		System.out.println("执行方法："+joinPoint.getSignature().getName()+"中出现异常："+exception);
	}
	@Around(value="pointCut()")
	public void around(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.println("每个方法之前，之后都有这条代码。方法名："+joinPoint.getTarget()+"运行。。。@Before:参数列表是：{"+Arrays.asList(args)+"}");
	}
	
	
}
