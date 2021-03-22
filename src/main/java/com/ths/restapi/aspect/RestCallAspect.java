package com.ths.restapi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
class RestCallAspect {
    @Around("@annotation(RestCall)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        Signature sig = joinPoint.getSignature();
        System.out.println(sig.getDeclaringType().getName() + ":" + sig.getName() + " executed in " + executionTime + "ms");

        Object[] args = joinPoint.getArgs();

        if (args != null) {
            for (Object obj: args) {
//                System.out.println(obj.getClass());
            }
        }
        return proceed;
    }
}
