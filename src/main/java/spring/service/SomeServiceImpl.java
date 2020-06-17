package spring.service;

import spring.utils.ServiceUtil;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl() {
        super();
        System.out.println("SomeServiceImpl无参数构造方法");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public void doSome() {
       /* ServiceUtil.doLog();*/
        System.out.println("---执行业务方法doSome（）---");
        /*ServiceUtil.doTrans();*/
    }

    @Override
    public void doOther() {
       /* ServiceUtil.doLog();*/
        System.out.println("---执行业务方法doOther()---");
        /*ServiceUtil.doTrans();*/
    }
}
