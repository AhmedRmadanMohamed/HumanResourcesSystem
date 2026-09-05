package com.company.common.aop.AOPLayers;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Layers {
    @Pointcut("execution(* HumanResourcesPackage.Services..*(..))")
    public void serviceLayer() {
    }

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void transactionalLayer() {
    }

    @Pointcut("execution(* HumanResourcesPackage.Controllers..*(..))")
    public void controllerLayer() {
    }
}
