package Util;

import db.Role;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class MySqlSessionFactory {

    SqlSessionFactory sqlSessionFactory = null;
    String resourse = "mybatis-config.xml";
    InputStream inputStream;

    {
        try {
            inputStream = Resources.getResourceAsStream(resourse);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {

        }
    }
    public void openSession(){
        SqlSession session= null;
        try {

            session = sqlSessionFactory.openSession();
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Role student = studentMapper.getStudent(1);
            Logger logger = Logger.getLogger(String.valueOf(MySqlSessionFactory.class));
            System.out.println(student.getNote());


            session.commit();
        }
        catch (Exception e){
            session.rollback();
        }
        finally {
            if (session != null){
                session.close();
            }
        }


    }


}
