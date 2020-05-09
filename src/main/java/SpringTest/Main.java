package SpringTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //获取Person对象
        //1.创建Spring的IOC容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.获取Person对象
        //方式1
        // Person person = (Person) ctx.getBean("person");
        // 方式二
        //Person person = ctx.getBean(Person.class);
        //这种要留意，配置表是否有两个相同类的bean；
        //方式三
        Person person = ctx.getBean("person1",Person.class);
        //3.调用对应的方法
        person.sayHello();
    }
}
