package com.company.common.aop.Monitoring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(30)
public class PerformanceControllerMonitoring {
    private static final Logger log = LoggerFactory.getLogger(PerformanceControllerMonitoring.class);
    @Around("com.company.common.aop.AOPLayers.Layers.controllerLayer()")
    public Object monitorPerformanceController(
            ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.nanoTime();

        try {

            return joinPoint.proceed();

        } finally {

            long executionTime =
                    (System.nanoTime() - startTime) / 1_000_000;

            if (executionTime > 500) {

                log.warn(
                        "SLOW CONTROLLER | {} | {} ms",
                        joinPoint.getSignature().toShortString(),
                        executionTime
                );
            }
        }
    }

}
