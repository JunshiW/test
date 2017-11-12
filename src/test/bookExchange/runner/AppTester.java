package test.bookExchange.runner;

import org.apache.ibatis.session.SqlSession;

import test.bookExchange.dto.Test;
import test.bookExchange.service.MyBatisUtilServiceTest;
import test.bookExchange.service.TestService;

public class AppTester {
	public static void main(String[] args) {
		SqlSession session = MyBatisUtilServiceTest.getSqlSessionFactory().openSession();	
		
		try{
//			TestService testSObj = session.getMapper(TestService.class);
//			Test test = new Test();
//			test.setId(2);
//			test.setDes("description");
//			test.setName("Test");
//			testSObj.save(test);
//			session.commit();
			Test test = new Test();
			test = (Test) session.selectOne("resources.bookMapper.selectBookById", 1);
			  session.commit();
			  System.out.println("id:"+test.getBid()+", Description:"+test.getDes()+", title:"+test.getName());
		}finally{
			session.close();
		}
	}

}
