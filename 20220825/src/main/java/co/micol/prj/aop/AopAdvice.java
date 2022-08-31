package co.micol.prj.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAdvice {
	
	@Pointcut("execution(* co.micol.prj..*Impl.*(..))")
	public void allPoint() {};
	
	
	@Before("allPoint()")
	public void log(JoinPoint jp) {
		Date date = new Date();
		String methodName = jp.getSignature().getName();
		System.out.println(methodName +  " 사전처리 : "  + date);
		
	}
	
	

	
	
}
