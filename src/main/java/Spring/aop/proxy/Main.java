package Spring.aop.proxy;

import java.util.Properties;

public class Main {
    public static void main(String[] args)  throws Exception{
        //将动态生成的代理类保存下来
        Properties properties = System.getProperties();
        properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");



        //目标对象
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();

        //获取代理对象
        Object  obj = new ArithmeticCalculatorProxy2(target).getProxy();

        // 转回具体的类型.

        ArithmeticCalculator  proxy = (ArithmeticCalculator) obj ;

        System.out.println(proxy.getClass().getName());

        //
        int result = proxy.add(1, 1);

        System.out.println("Main  Result : " + result );


        /**
         * 问题:
         * 	  1. 代理对象能否转换成目标对象的类型?
         *    2. 代理对象调用代理方法，为什么会执行 InvocationHandler中的invoke 方法
         */

    }
}
