package Spring.aspectJ.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-aspectJ_xml.xml");

        ArithmeticCalculator ac = app.getBean("arithmeticCalculatorImpl",ArithmeticCalculator.class);
        //System.out.println(ac.getClass().getName());
        int result =ac.add(1,2);

        System.out.println(result);

//        result = ac.div(5,0);
//        System.out.println("result = " + result);
    }
}
