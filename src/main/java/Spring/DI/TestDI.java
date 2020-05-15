package Spring.DI;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
    @Test
    public void testSet(){
        //1、创建容器对象
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-di.xml");
        //2、获取Car对象
        Car car = app.getBean("car",Car.class);
        //3、输出对象
        System.out.println(car);
    }
    @Test
    public void testConstructor(){
        //1、创建容器对象(只要创建IOC容器队形，所有的bean都会创建)
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-di.xml");
        //2、获取Car对象
        //Car car1 = app.getBean("car",Car.class);

        Car car2 = app.getBean("car1",Car.class);
        //3、输出对象
        //System.out.println(car1);
        System.out.println(car2);
    }
    @Test
    public void testPnameSpace(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-di.xml");
        Car car3 = app.getBean("car3",Car.class);
        System.out.println(car3);
    }

    @Test
    public void testZML(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-di.xml");
        Book book = app.getBean("book",Book.class);
        System.out.println(book);
    }
}
