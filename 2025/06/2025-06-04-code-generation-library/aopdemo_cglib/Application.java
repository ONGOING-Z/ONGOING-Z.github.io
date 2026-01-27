package mine.projects.aopdemo_cglib;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("mine.projects.aopdemo_cglib")
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class Application {
}
