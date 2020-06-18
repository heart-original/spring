package spring;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.dao.StudentDao;
import spring.domain.Student;
import spring.handler.MyInvocationHandler;
import spring.service.BuyGoodsService;
import spring.service.SomeService;
import spring.service.SomeServiceImpl;
import spring.service.StudentService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

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

    @Test
    public void test05(){
        String config="applicationContext.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) context.getBean("someService");
        proxy.doSome();
    }

    @Test
    public void test06(){
        String config="applicationContext.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) context.getBean("someService");
        proxy.doAfter("王五",20);
    }

    @Test
    public void test07(){
        String config="applicationContext.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) context.getBean("someService");
        proxy.doAround("萧炎",20);
    }

   /* @Test
    public void test08(){
        String resource="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
        String names[] = applicationContext.getBeanDefinitionNames();
        for(String na:names){
            System.out.println("容器中对象名称："+na+"|"+applicationContext.getBean(na));
        }
    }*/

    @Test
    public void test09(){
        String resource="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");
        Student student = new Student();
        student.setId(1005);
        student.setAge(23);
        student.setName("张三");
        int nums = studentDao.insertStudent(student);
        System.out.println("nums="+nums);
    }

    @Test
    public void test10(){
        String resource="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
        StudentService service = (StudentService) applicationContext.getBean("studentService");
        List<Student> students = service.findAllStudent();
        for (Student stu : students){
            System.out.println(stu);
        }
    }

    @Test
    public void test11(){
        String resource="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
        BuyGoodsService service = (BuyGoodsService) applicationContext.getBean("bugService");
        service.buy(1001,10);
    }

    @Test
    public void test12(){
        String resource="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
        BuyGoodsService service = (BuyGoodsService) applicationContext.getBean("bugService");
        System.out.println("service是代理：" + service.getClass().getName());
        service.buy(1001,10);
    }
}
