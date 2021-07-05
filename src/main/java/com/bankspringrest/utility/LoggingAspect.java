package com.bankspringrest.utility;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;


public class LoggingAspect {
    public static final Log logger = LogFactory.getLog(LoggingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.infy.service.*Impl.*(..))", throwing = "exception")
    public void logServiceException(Exception exception) throws Exception{
        logger.error(exception.getMessage(), exception);
    }

}
