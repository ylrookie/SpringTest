package Spring.autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAutoWire {
    @Test
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-autowire.xml");
        Person person = app.getBean("person",Person.class);
        System.out.println(person);
    }
}
