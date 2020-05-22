package Spring.aop.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 生成代理对象。
 *
 * JDK的动态代理:
 * 	 1. Proxy : 是所有动态代理类的父类， 专门用户生成代理类或者是代理对象
 * 		 	public static Class<?> getProxyClass(ClassLoader loader,
 Class<?>... interfaces)
 用于生成代理类的Class对象.

 * 			public static Object newProxyInstance(ClassLoader loader,
 Class<?>[] interfaces,
 InvocationHandler h)
 用于生成代理对象

 *   2. InvocationHandler :完成动态代理的整个过程.
 *   		public Object invoke(Object proxy, Method method, Object[] args)
 throws Throwable;
 *
 */
public class ArithmeticCalculatorProxy2 {
    //动态代理:    目标对象     如何获取代理对象      代理要做什么

    //目标对象
    private  ArithmeticCalculator  target ;


    public ArithmeticCalculatorProxy2(ArithmeticCalculator target) {
        this.target = target ;
    }


    //获取代理对象的方法
    public Object  getProxy() throws Exception {

        //代理对象
        Object  proxy ;

        ClassLoader loader = target.getClass().getClassLoader();
        Class [] interfaces = target.getClass().getInterfaces();

        Class proxyClass = Proxy.getProxyClass(loader, interfaces);

        //Class  创建对象?   newInstance()

        Constructor con =
                proxyClass.getDeclaredConstructor(InvocationHandler.class);

        proxy = con.newInstance(new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //将方法的调用转回到目标对象上.

                //获取方法的名字
                String methodName = method.getName();
                //记录日志
                System.out.println("LoggingProxy2==> The method " + methodName+" begin with "+ Arrays.asList(args));
                Object result = method.invoke(target, args);  // 目标对象执行目标方法. 相当于执行ArithmeticCalculatorImpl中的+ - * /

                //记录日志
                System.out.println("LoggingProxy2==> The method " + methodName  +" ends with :" +result   );
                return result ;
            }
        });


        return proxy ;
    }
}
