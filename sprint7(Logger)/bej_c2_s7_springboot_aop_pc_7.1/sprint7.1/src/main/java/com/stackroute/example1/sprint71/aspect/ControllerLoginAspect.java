package com.stackroute.example1.sprint71.aspect;






import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class ControllerLoginAspect {
    public static final Logger logger= LoggerFactory.getLogger(ControllerLoginAspect.class);

    @Pointcut("execution(* com.stackroute.example1.sprint71.controller.ProductController.*(..))")
    public void controlMethod(){}

    @Before("controlMethod()")
    public void beforeAdvice(JoinPoint joinpoint){
        logger.info("----Before Controller method----");
        logger.debug("Method name ::"+ joinpoint.getSignature().getName());
        logger.debug("Args ::" + Arrays.toString(joinpoint.getArgs()));
        logger.info("---###############---");
    }
    @After("controlMethod()")
    public void afterAdvice(JoinPoint joinPoint){
        logger.info("----After Controller method----");
        logger.debug("Method name ::"+ joinPoint.getSignature().getName());
        logger.debug("Args ::" + Arrays.toString(joinPoint.getArgs()));
        logger.info("---###############---");
    }
    @AfterReturning(value="controlMethod()",returning = "result")
    public void afterReturnAdvice(JoinPoint joinPoint,Object result){
        logger.info("----After returning Controller method----");
        logger.debug("Method name ::"+ joinPoint.getSignature().getName());
        logger.debug("Args ::" + Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result :: " +result );
        logger.info("---###############---");
    }
    @AfterThrowing(value = "controlMethod()",throwing = "error")
    public void afterThrowing(JoinPoint joinPoint,Throwable error){
        logger.info("----After throwing exception by Controller method----");
        logger.debug("Method name ::"+ joinPoint.getSignature().getName());
        logger.debug("Args ::" + Arrays.toString(joinPoint.getArgs()));
        logger.debug("Exception :: " +error );
        logger.info("---###############---");
    }

}
