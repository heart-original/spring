package spring;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.domain.Student;
import spring.service.SomeService;

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

}
