package mine.projects.aopdemo_jdk;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.util.AopTestUtils;

public class AopTest {

	@Test
	public void testAop() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

		// 获取代理对象(注意，这里jdk代理获取bean必须要用接口的类型!)
		DemoInterface demoInterface = context.getBean(DemoInterface.class);

		// 触发切面方法
		demoInterface.save();

		context.close();
	}
}
