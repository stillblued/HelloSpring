package co.micol.prj.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {

	@Bean
	public AopAdvice beforAdvice() {
		return new AopAdvice();
	}
	
	
}
