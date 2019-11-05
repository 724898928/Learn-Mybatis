package com.coreLee.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    private static SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();

    private static SqlSessionFactory sqlSessionFactory;

    private SqlSessionUtil() {
        sqlSessionFactory = getSqlSessionFactory();
    }

    /**
     * 获取sqlSessionFactory
     *
     * @return
     */
    private static SqlSessionFactory getSqlSessionFactory() {
        String path = SqlSessionUtil.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
        String resourece = path+ "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            return sqlSessionFactoryBuilder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SqlSession getSqlSession() {
        if (null == sqlSessionFactory) {
            sqlSessionFactory = getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }


}
