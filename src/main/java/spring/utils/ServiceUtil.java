package spring.utils;

public class ServiceUtil {
    public static void doLog(){
        System.out.println("非业务功能，日志功能，在方法开始时输出日志");
    }
    public static void doTrans(){
        System.out.println("非业务功能，事务功能，在方法执行后加入事务");
    }
}
