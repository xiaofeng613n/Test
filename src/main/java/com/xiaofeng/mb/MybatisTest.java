package com.xiaofeng.mb;

import com.xiaofeng.mb.entity.Test;
import com.xiaofeng.mb.mapping.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by xiaofeng on 2018/4/14
 * Description:
 */
public class MybatisTest {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis/mybatis-conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        MapperHelper mapperHelper = new MapperHelper();
        mapperHelper.registerMapper(TestMapper.class);
        mapperHelper.processConfiguration(sqlSessionFactory.getConfiguration(),TestMapper.class);
        
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
//            Test test = testMapper.selectById(3);
//            System.out.println(test.toString());
            Test search = new Test();
            search.setName("bb");
            List<Test> testList = testMapper.select(search);
            System.out.println(testList.toString());
        }
    }
}