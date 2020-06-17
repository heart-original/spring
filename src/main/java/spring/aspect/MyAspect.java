package spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
public class MyAspect {

    @Before(value = "execution(* spring.service.SomeServiceImpl.doSome())")
    public void MyBefore(JoinPoint joinPoint){
        System.out.println("连接点的方法定义："+joinPoint.getSignature());
        System.out.println("连接点方法的参数个数："+joinPoint.getArgs().length);
        Object args [] = joinPoint.getArgs();
        for (Object arg : args){
            System.out.println(arg);
        }
        System.out.println("前置通知：在目标方法之前执行，例如输出日志"+"time:"+new Date());
    }

    @AfterReturning(value = "execution(* spring.service.SomeServiceImpl.doAfter(..))",returning = "result")
    public void MyAfter(Object result){
        if(result != null){
            String s = (String)result;
            result = s.toUpperCase();
        }
        System.out.println("后置通知：在目标方法之后之情，例如执行事务处理（切面）" + "result:" + result);
    }

    @Around(value = "execution(* spring.service.SomeServiceImpl.doAround(..))")
    public Object MyAround(ProceedingJoinPoint point) throws Throwable {
        Object obj = null;
        System.out.println("环绕通知：在方法执行之前，如输出日志");
        point.proceed();
        System.out.println("环绕通知：在方法执行之后，如事务处理");
        return obj;
    }
}
