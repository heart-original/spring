package spring.dao;

import spring.domain.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudentById(int id);

    Student selectStudentById(int id);
    List<Student> selectAllStudents();
}
