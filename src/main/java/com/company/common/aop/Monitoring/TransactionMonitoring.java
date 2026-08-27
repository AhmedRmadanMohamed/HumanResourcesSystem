
package com.company.common.aop.Monitoring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
@Aspect
public class TransactionMonitoring {
    private static final Logger log = LoggerFactory.getLogger(TransactionMonitoring.class);
    @Around("com.company.common.aop.AOPLayers.Layers.transactionalLayer()")

    public Object monitorTransaction(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().toShortString();
        long startTime = System.currentTimeMillis();
        log.info("TX START | {}", methodName);
        try {
            Object result = joinPoint.proceed();
            long executionTime =
                    System.currentTimeMillis() - startTime;
            log.info(
                    "TX SUCCESS | {} | {} ms",
                    methodName,
                    executionTime
            );

            return result;
        } catch (Throwable exception) {

            long executionTime =
                    System.currentTimeMillis() - startTime;

            log.error(
                    "TX FAILED | {} | {} ms | {}",
                    methodName,
                    executionTime,
                    exception.getMessage()
            );

            throw exception;
    }
}

}
