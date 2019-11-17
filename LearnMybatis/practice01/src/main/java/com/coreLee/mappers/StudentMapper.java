package com.coreLee.mappers;

import com.coreLee.model.Student;

public interface  StudentMapper {
    int add(Student student);
    Student selectStudentByID(int id);


    int delete(int id);
}
