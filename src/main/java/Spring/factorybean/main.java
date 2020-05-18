package Spring.factorybean;

import Spring.DI.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-factorybean.xml");
        Car car = app.getBean("car",Car.class);
        System.out.println(car);
    }
}
