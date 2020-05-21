package Spring.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean的后置处理器 : 对IOC容器中所有的bean都起作用.
 */

public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在bean的生命周期的初始化方法之前执行
     * Object bean: 正在被创建的bean对象.
     * String beanName: bean对象的id值.
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        return bean;
    }
    /**
     * 在bean的生命周期的初始化方法之后执行
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        return bean;
    }
}
