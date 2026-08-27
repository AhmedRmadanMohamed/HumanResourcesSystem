package com.company.common.aop.Monitoring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(20)
public class PerformanceServiceMonitoring {
    private static final Logger log = LoggerFactory.getLogger(PerformanceServiceMonitoring.class);


    @Around("com.company.common.aop.AOPLayers.Layers.serviceLayer()")
    public Object monitorPerformance(
            ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long executionTime =
                System.currentTimeMillis() - startTime;

        if (executionTime > 500) {

            log.warn(
                    "SLOW METHOD | {} | {} ms",
                    joinPoint.getSignature().toShortString(),
                    executionTime
            );
        }

        return result;
    }
}
