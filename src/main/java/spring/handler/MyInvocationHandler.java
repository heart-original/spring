package spring.handler;

import spring.utils.ServiceUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    //目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过代理对象执行方法时，会调用invoke（）
        Object result = null;
        ServiceUtil.doLog();
        //执行目标类的方法，通过method类实现
        result=method.invoke(target,args);
        ServiceUtil.doTrans();
        return result;
    }
}
