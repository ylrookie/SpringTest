package Spring.lifeCycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testLifyCycle {
    @Test
    public void test(){
        ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        Car car = app.getBean("car",Car.class);
        System.out.println("=========>4.使用bean对象：" +car);

        //关闭容器
        app.close();
    }
}
