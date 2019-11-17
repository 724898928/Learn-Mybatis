package com.coreLee.service;

import com.coreLee.Utils.SqlSessionUtil;
import com.coreLee.log.Logger;
import com.coreLee.mappers.StudentMapper;
import org.apache.ibatis.session.SqlSession;

public class StudentService {
    private static org.apache.log4j.Logger logger = Logger.getLogger(StudentService.class);

    public static void main(String[] args) {
        logger.error("begin");
        SqlSessionUtil sqlSessionUtil = SqlSessionUtil.getInstance();
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
       /* Student student = new Student();
        student.setId(2);
        student.setName("lisi");
        student.setAge(18);
        studentMapper.add(student);
        sqlSession.commit();*/
        System.out.println(studentMapper.selectStudentByID(1));
        logger.error("end");
        sqlSession.close();
    }
}
