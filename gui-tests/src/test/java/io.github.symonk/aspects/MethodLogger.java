package io.github.symonk.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class MethodLogger {

  @Around("@annotation($yAudit) && execution(* *(..))")
  public void annotatedMethod() {}

  @Pointcut("execution(public * *(..))")
  public void publicMethod() {
    System.out.println("AOP TEST");
  }

  @Before("annotationPointCutDefinition()")
  public void printNewLine(JoinPoint pointcut) {
    log.error("AOP CONNECTED!");
  }
}
