package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Aspect
@Component
public class NotEmptyAspect {

    @Around("@annotation(NotEmpty)")
    public Object checkNotEmpty(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg == null) {
                throw new CustomException("Аргумент метода равен null");
            }
            if (arg instanceof String && ((String) arg).isEmpty()) {
                throw new CustomException("Пустая строка");
            }
            if (arg instanceof Collection && ((Collection<?>) arg).isEmpty()) {
                throw new CustomException("Пустая колекция");
            }
        }
        return joinPoint.proceed();

    }
    @Pointcut("@annotation(NotEmpty)")
    public void methodsAnnotatedWithNotEmpty() {}

}
