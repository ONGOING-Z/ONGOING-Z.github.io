package mine.projects.aopdemo_jdk;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
	@Before("execution(public * mine.projects.aopdemo_jdk.DemoService.*(..))")
	public void beforePrint() {
		System.out.println("before run...");
	}
}
