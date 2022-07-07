package edu.miu.cs.cs425.mystudentmgmtwebapp.service;



import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Classroom;
import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student save(Student s);
    List<Student> getPassingStudentsOnly();
    List<Student> getLatestStudents();
    Student getStudentById(long id);
    void updateStudent(Classroom classroom, long studentId);
}
