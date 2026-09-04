package HumanResourcesPackage.Aspects.Monitoring;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(20)
public class PerformanceServiceMonitoring {


    @Around("HumanResourcesPackage.Aspects.AOPLayers.Layers.serviceLayer()")
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
