package Spring.aspectJ.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
* 日志切面
* */

public class LoggingAspectJ {




    public void beforeMethod(JoinPoint joinPoint){
        //获取参数
        Object[] args = joinPoint.getArgs();
        //获取方法的名字
        String methodName = joinPoint.getSignature().getName();

        System.out.println("LoggingAspectJ====> The Method "+ methodName + " begin with "+ Arrays.asList(args));
    }


    public void afterMethod(JoinPoint joinPoint){
        //获取方法的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspectJ====> The Method "+ methodName+ " ends .");
    }


    public void afterRuturningMethod(JoinPoint joinPoint,Object result){
        //获取方法的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspectJ====> The Method "+ methodName+ " end whit " + result);
    }


    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
        //获取方法的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspectJ====> The method " + methodName + " occurs Exception: " +ex );
    }

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
