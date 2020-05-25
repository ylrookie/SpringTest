package Spring.aspectJ.annotation;

import jdk.nashorn.internal.scripts.JO;
import org.apache.ibatis.jdbc.Null;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
* 日志切面
* */

@Component  //标识为一个组件
@Aspect     //标识为一个切面
public class LoggingAspectJ {

    /**
    * 前置通知：在目标方法(连接点)执行之前执行
    * */
    @Before("execution(public int Spring.aspectJ.annotation.ArithmeticCalculatorImpl.add(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
        //获取参数
        Object[] args = joinPoint.getArgs();
        //获取方法的名字
        String methodName = joinPoint.getSignature().getName();

        System.out.println("LoggingAspectJ====> The Method "+ methodName + " begin with "+ Arrays.asList(args));
    }

    /**
     * 后置通知: 在目标方法执行之后执行， 不管目标方法有没有抛出异常.  不能获取方法的结果
     *    * Spring.aspectJ.annotation.*.*(..)
     *    * : 任意修饰符 任意返回值
     *    * : 任意类
     *    * : 任意方法
     *    ..: 任意参数列表
     *
     * 连接点对象: JoinPoint
     */
    @After("execution(* Spring.aspectJ.annotation.*.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        //获取方法的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspectJ====> The Method "+ methodName+ " ends .");
    }


    /**
     * 返回通知: 在目标方法正常执行结束后执行.  可以获取到方法的返回值.
     * 必须在注解里加上  returning
     * 获取方法的返回值: 通过returning 来指定一个名字， 必须要与方法的一个形参名一致.
     */
    @AfterReturning(value = "execution(* Spring.aspectJ.annotation.*.*(..))",returning = "result")
    public void afterRuturningMethod(JoinPoint joinPoint,Object result){
        //获取方法的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspectJ====> The Method "+ methodName+ " end whit " + result);
    }

    /**
     * 异常通知: 在目标方法抛出异常后执行.
     *
     * 获取方法的异常: 通过throwing来指定一个名字， 必须要与方法的一个形参名一致.
     *
     * 可以通过形参中异常的类型 来设置抛出指定异常才会执行异常通知.
     * public void afterThrowingMethod(JoinPoint joinPoint,Exception ex)  所有异常都会执行
     * public void afterThrowingMethod(JoinPoint joinPoint,NullPointerException ex) 只有空指针异常才会执行此方法
     * public void afterThrowingMethod(JoinPoint joinPoint,ArithmeticException ex) 算数异常执行此方法
     */
    @AfterThrowing(value = "execution(* Spring.aspectJ.annotation.*.*(..))",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
        //获取方法的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspectJ====> The method " + methodName + " occurs Exception: " +ex );
    }

    /**
     * 环绕通知: 环绕着目标方法执行. 可以理解是 前置 后置 返回  异常 通知的结合体，更像是动态代理的整个过程.
     */

    @Around("execution(* Spring.aspectJ.annotation.*.*(..))")
    public  Object  aroundMethod(ProceedingJoinPoint pjp) {

        //执行目标方法
        try {
            //前置
            Object result = pjp.proceed();
            //返回
            return result ;
        } catch (Throwable e) {
            //异常通知
            e.printStackTrace();
        }finally {
            // 后置
        }

        return null;
    }

}
