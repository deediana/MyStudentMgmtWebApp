package edu.miu.cs.cs425.mystudentmgmtwebapp.service;

import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Classroom;

public interface ClassroomService {
    Classroom save(Classroom cr);
    Classroom getClassroomById(int id);
}
