package Spring.factorybean;

import Spring.DI.Car;
import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
    public Car getObject() throws Exception {
        return null;
    }
    /*
    * 返回具体的bean对象的类型
    * */
    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
}
