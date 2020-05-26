package Spring.tx.annotation.test;

import Spring.tx.annotation.dao.BookShopDao;
import Spring.tx.annotation.service.BookShopService;
import Spring.tx.annotation.service.Cashier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class testTransaction {

    private BookShopDao bookShopDao;
    private BookShopService bookShopService;
    private Cashier cashier;

    @Before
    public void init(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-tx.xml");
        bookShopDao = app.getBean("bookShopDaoImpl",BookShopDao.class);
        bookShopService = app.getBean("bookShopServiceImpl",BookShopService.class);
        cashier = app.getBean("cashierImpl",Cashier.class);
    }

    @Test
    public void testTx(){
        bookShopService.buyBook("tom","ISBN-001");
    }

    @Test
    public void testCheckOut(){
        List<String> list = new ArrayList<String>();
        list.add("ISBN-001");
        list.add("ISBN-002");

        cashier.checkOut("tom",list);
    }
}
