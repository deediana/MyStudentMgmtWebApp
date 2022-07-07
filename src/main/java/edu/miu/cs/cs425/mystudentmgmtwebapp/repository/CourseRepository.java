package edu.miu.cs.cs425.mystudentmgmtwebapp.repository;

import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
