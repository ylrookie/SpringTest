package Spring.factorybean;

import Spring.DI.Car;
import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
    /*
    * 工厂bean具体创建的bean对象是由getObject方法返回的
    * */
    public Car getObject() throws Exception {
        return new Car("五菱宏光","五菱",140);
    }
    /*
    * 返回具体的bean对象的类型
    * */
    public Class<?> getObjectType() {
        return Car.class;
    }
    /*
    * bean可以是单例的，也可以是原型（非单例）
    * */
    public boolean isSingleton() {

        return true;
    }
}
