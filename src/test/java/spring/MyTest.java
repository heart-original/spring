package spring;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.domain.Student;
import spring.handler.MyInvocationHandler;
import spring.service.SomeService;
import spring.service.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Unit test for simple App.
 */
public class MyTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test01(){
        String resource="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
        SomeService service=(SomeService)applicationContext.getBean("someService");
        service.doSome();
        System.out.println(applicationContext.getBean("MyDate"));
    }

    @Test
    public void test02(){
        String resource="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
        Student student=(Student) applicationContext.getBean("MyStudent");
        System.out.println("student:"+student);
    }

    @Test
    public void test03(){
        String resource="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
        SomeService service=new SomeServiceImpl();
        service.doSome();
        System.out.println("-----------");
        service.doOther();
    }

    @Test
    public void test04(){
        //使用jdk的Proxy创建代理对象
        //创建目标对象
        SomeService target=new SomeServiceImpl();
        //创建InvocationHandler对象
        InvocationHandler handler=new MyInvocationHandler(target);
        //使用Proxy代理
        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
        proxy.doSome();
        System.out.println("============");
        proxy.doOther();
    }

}
