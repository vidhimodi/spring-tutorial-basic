package com.endurance.india.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MethodCallTracer {

    @Pointcut("execution(* com.endurance.india.Dashboard.*(..))")
    public void executionOfMethod() {}

    @Around("executionOfMethod()")
    public Object trackMethodCalls(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(">>>>>>> Calling method: " + joinPoint.getSignature().toLongString() + " with arguments: " + getArguments(joinPoint));
        Object returnValue = joinPoint.proceed();
        System.out.println(">>>>>>> Method " + joinPoint.getSignature().toLongString() + " returned " + returnValue);
        return returnValue;
    }

    private String getArguments(ProceedingJoinPoint joinPoint) {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<joinPoint.getArgs().length;i++)
        {
            sb=sb.append(joinPoint.getArgs()[i]);
            if(i != joinPoint.getArgs().length-1)
            {
                sb.append(",");
            }
        }
        return sb.toString();
    }

}