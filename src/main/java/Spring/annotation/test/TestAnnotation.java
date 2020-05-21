package Spring.annotation.test;

import Spring.annotation.controller.userController;
import Spring.annotation.dao.userDaoImpl;
import Spring.annotation.service.userServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    @Test
    public void testAnnotation(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-annotation.xml");
        userController uc = app.getBean("userController",userController.class);
        System.out.println(uc);

        /*userServiceImpl us = app.getBean("userServiceImpl",userServiceImpl.class);
        System.out.println(us);

        userDaoImpl ud = app.getBean("userDaoImpl",userDaoImpl.class);
        System.out.println(ud);*/

        uc.regist();
    }
}
