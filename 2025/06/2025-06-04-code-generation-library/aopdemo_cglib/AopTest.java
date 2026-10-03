package mine.projects.aopdemo_cglib;

import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {

    @Test
    public void testAop() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        // 获取代理对象
        DemoService demoService = context.getBean(DemoService.class);

        // 触发切面方法
        demoService.save();

        context.close();
    }
}
