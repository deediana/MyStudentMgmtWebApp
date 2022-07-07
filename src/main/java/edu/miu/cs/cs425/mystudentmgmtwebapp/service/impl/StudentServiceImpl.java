package edu.miu.cs.cs425.mystudentmgmtwebapp.service.impl;


import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Classroom;
import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Student;
import edu.miu.cs.cs425.mystudentmgmtwebapp.repository.StudentRepository;
import edu.miu.cs.cs425.mystudentmgmtwebapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Saves Student data
     * @param s Student data object to be saved
     * @return saved student data object
     */
    @Override
    public Student save(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public List<Student> getPassingStudentsOnly() {
        return studentRepository.findStudentsWithCgpaGreaterThan3(3.0f);
    }

    @Override
    public List<Student> getLatestStudents() {
        return studentRepository.findStudentsByStudentNumberGreaterThan(980002);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void updateStudent(Classroom classroom, long studentId) {
        studentRepository.update(classroom, studentId);
    }
}
