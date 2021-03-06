package Spring.aspectJ.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(11)
public class ValidationAspect {
    @Before("LoggingAspectJ.declarePointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        //获取参数
        Object[] args = joinPoint.getArgs();
        //获取方法的名字
        String methodName = joinPoint.getSignature().getName();

        System.out.println("ValidationAspectJ====> The Method "+ methodName + " begin with "+ Arrays.asList(args));

    }
}
