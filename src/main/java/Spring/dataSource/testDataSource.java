package Spring.dataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class testDataSource {
    @Test
    public void test() throws Exception{
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-date.xml");
        DataSource DS = app.getBean("datasource",DataSource.class);
        System.out.println(DS);
        System.out.println(DS.getConnection());
    }
}
