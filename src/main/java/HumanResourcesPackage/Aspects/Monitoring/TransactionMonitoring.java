
package HumanResourcesPackage.Aspects.Monitoring;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
@Slf4j
@Aspect
public class TransactionMonitoring {
    @Around("HumanResourcesPackage.Aspects.AOPLayers.Layers.transactionalLayer()")

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
