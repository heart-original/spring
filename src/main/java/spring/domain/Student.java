package spring.domain;

public class Student {
    private String name;
    private int age;
    private School school;

    public Student(){};
    public Student(String name,int age,School school){
        System.out.println("student的有参构造方法");
        this.name=name;
        this.age=age;
        this.school=school;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

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
}
