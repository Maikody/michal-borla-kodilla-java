package com.kodilla.patterns2.facade.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeAspect.class);

    @Pointcut("execution(void com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void processOrderPointcut(){};

    @Before("processOrderPointcut()")
    public void markProcessOrderInvocation(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        LOGGER.info("Method: " + methodSignature.getName() + " has been called");

        Object[] args = joinPoint.getArgs();
        LOGGER.info("User ID for whom order is placed: " + args[1]);
    }
}
