package com.coreLee.service;

import com.coreLee.Utils.SqlSessionUtil;
import com.coreLee.mappers.StudentMapper;
import com.coreLee.model.Student;
import org.apache.ibatis.session.SqlSession;

public class StudentService {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
       /* Student student = new Student();
        student.setId(2);
        student.setName("lisi");
        student.setAge(18);
        studentMapper.add(student);
        sqlSession.commit();*/
        System.out.println(studentMapper.selectStudentByID(1));

        sqlSession.close();
    }
}
