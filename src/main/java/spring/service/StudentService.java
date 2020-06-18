package spring.service;

import spring.domain.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);

    int modifyStudent(Student student);
    int removeStudent(int id);
    Student findStudentById(int id);
    List<Student> findAllStudent();
}
