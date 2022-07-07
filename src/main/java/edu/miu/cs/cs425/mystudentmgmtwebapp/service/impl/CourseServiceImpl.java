package edu.miu.cs.cs425.mystudentmgmtwebapp.service.impl;


import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Course;
import edu.miu.cs.cs425.mystudentmgmtwebapp.repository.CourseRepository;
import edu.miu.cs.cs425.mystudentmgmtwebapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
