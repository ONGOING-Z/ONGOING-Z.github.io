@Configuration
public class MyConfig {
    @Bean(name = "aaa")
    public A a() {
        return new A(b());  // 此处调用b()
    }
    
    @Bean(name = "bbb")
    public B b() {
        return new B();
    }
}