package com.dream.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;


public class TestngRetry implements IRetryAnalyzer{
	
	Log log = new Log(TestngRetry.class);
    private static int maxRetryCount = 2; //错误后重跑几次
    private int retryCount = 1;
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message = "Running retry for '" + result.getName()
	        + "' on class " + this.getClass().getName() + " Retrying "
	        + retryCount + " times";
	        log.info(message);
//	        Reporter.setCurrentTestResult(result);
//	        Reporter.log("RunCount=" + (retryCount + 1));
	        retryCount++;
	        return true;
		}
	    return false;
	}

}
