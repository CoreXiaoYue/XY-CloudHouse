package com.xiaoyue.slf4j.logger;

import java.util.logging.Logger;

import org.aspectj.weaver.Utils;
import org.slf4j.LoggerFactory;

public class UtileLoggre {
	 private static final Logger logger = (Logger) LoggerFactory.getLogger(Utils.class);

	    /**
	     * 打印当前线程堆栈信息
	     * @param prefix
	     */
	    public static void printTrack(String prefix){
	        StackTraceElement[] st = Thread.currentThread().getStackTrace();

	        
	        
	        if(null==st){
	            logger.info("invalid stack");
	            return;
	        }

	        StringBuffer sbf =new StringBuffer();

	        for(StackTraceElement e:st){
	            if(sbf.length()>0){
	                sbf.append(" <- ");
	                sbf.append(System.getProperty("line.separator"));
	            }

	            sbf.append(java.text.MessageFormat.format("{0}.{1}() {2}"
	                    ,e.getClassName()
	                    ,e.getMethodName()
	                    ,e.getLineNumber()));
	        }

	        logger.info(prefix
	                + "\n************************************************************\n"
	                + sbf.toString()
	                + "\n************************************************************");
	    }
}
