package Spring.Scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
    @Test
    public void testScope1(){

        ApplicationContext app = new ClassPathXmlApplicationContext("spring-scope.xml");
        Car car = app.getBean("car",Car.class);
        Car car1 = app.getBean("car",Car.class);
        System.out.println(car == car1);
    }
}
