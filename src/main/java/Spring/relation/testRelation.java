package Spring.relation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testRelation {
    @Test
    public void testParent(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-relation.xml");
        //该bean为抽象bean，不能被创建对象
        //Address address1 = app.getBean("address1",Address.class);
        //System.out.println(address1);

        Address address2 = app.getBean("address2",Address.class);
        System.out.println(address2);
    }
}
