package com.company.common.aop.Monitoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Aspect
@Component
@Order(30)
public class PerformanceControllerMonitoring {

    private static final Logger log =
            LoggerFactory.getLogger(PerformanceControllerMonitoring.class);

    @PostConstruct
    public void init() {
        log.warn("=== PerformanceControllerMonitoring Aspect LOADED ===");
    }

    @Around("@annotation(com.company.common.aop.annotation.PerformanceMonitoring)")
    public Object monitorPerformanceController(
            ProceedingJoinPoint joinPoint) throws Throwable {


        String methodName =
                joinPoint.getSignature().toShortString();


        long startTime = System.nanoTime();


        log.info("AOP HIT CONTROLLER | {}", methodName);


        try {

            return joinPoint.proceed();


        } catch (Throwable exception) {

            log.error(
                    "CONTROLLER FAILED | {} | {}",
                    methodName,
                    exception.getMessage()
            );

            throw exception;


        } finally {


            long executionTime =
                    (System.nanoTime() - startTime) / 1_000_000;


            log.warn(
                    "CONTROLLER EXECUTION | {} | {} ms",
                    methodName,
                    executionTime
            );
        }
    }
}
