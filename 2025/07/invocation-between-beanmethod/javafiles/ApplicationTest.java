/**
 * @description 测试 @Bean 方法之间的调用。
 */
public class ApplicationTest {

	@Test
	public void testBeanMethodCreation() {
		// 1. 创建应用上下文（不使用Spring Boot）
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MyConfig.class);

		context.close(); // 显式关闭 context
	}
}