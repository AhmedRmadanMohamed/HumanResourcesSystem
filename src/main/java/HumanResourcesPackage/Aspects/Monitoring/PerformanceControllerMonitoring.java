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
@Order(30)
public class PerformanceControllerMonitoring {
    @Around("HumanResourcesPackage.Aspects.AOPLayers.Layers.controllerLayer()")
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
