package mine.projects.aopdemo_jdk;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("mine.projects.aopdemo_jdk")
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class Application {
}
