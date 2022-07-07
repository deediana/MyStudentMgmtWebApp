package edu.miu.cs.cs425.mystudentmgmtwebapp.repository;

import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Classroom;
import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.cgpa >= ?1 order by s.name")
    List<Student> findStudentsWithCgpaGreaterThan3(float cgpa);

    List<Student> findStudentsByStudentNumberGreaterThan(long studentNumber);

    @Modifying
    @Query("update Student s set s.classroom = ?1 where s.studentId = ?2")
    void update(Classroom classroom, long id);
}
