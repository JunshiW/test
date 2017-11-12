package main.bookExchange.service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtilService {
 	private static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "main/resources/mybatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
} 
