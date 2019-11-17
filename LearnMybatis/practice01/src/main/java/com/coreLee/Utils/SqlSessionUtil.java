package com.coreLee.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SqlSessionUtil {

    private static Logger logger = Logger.getLogger(SqlSessionUtil.class);

    private static SqlSessionUtil sqlSessionUtil;

    private static SqlSessionFactory sqlSessionFactory;

    private SqlSessionUtil() {
    }

    /**
     * 获取sqlSessionFactory
     *
     * @return
     */
    private SqlSessionFactory getSqlSessionFactory() {

        String path = SqlSessionUtil.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
        String pathString = System.getProperty("user.dir").replaceAll("\\\\", "/") + "/src/main/resources/mybatis-config.xml";
        System.out.println(pathString);
        // InputStream inputStream  = Resources.getResourceAsStream(SqlSessionUtil.class.getClassLoader(),pathString);
        InputStream inputStream = this.getClass().getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        return sqlSessionFactoryBuilder.build(inputStream);
    }

    public SqlSession getSqlSession() {
        if (null == sqlSessionFactory) {
            sqlSessionFactory = getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }

    public static SqlSessionUtil getInstance() {

        return new SqlSessionUtil();
    }


}
