package spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/*@Component(value = "MyStudent")*/
public class Student {
    private int id;
   /* @Value("李四")*/
    private String name;
   /* @Value("19")*/
    private int age;
    /*@Resource*/
    /*private School school;*/
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student(){};
    public Student(String name,int age,School school){
        /*System.out.println("student的有参构造方法");*/
        this.name=name;
        this.age=age;
       /* this.school=school;*/
    }

  /*  public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   /* @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }*/
}
