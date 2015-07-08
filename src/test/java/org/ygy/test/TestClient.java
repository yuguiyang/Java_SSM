package org.ygy.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ygy.entity.UserEntity;
import org.ygy.util.MyBatisUtil;

public class TestClient {
	   private SqlSession session = null;  
	      
	    @Before  
	    public void before() {  
	        session = MyBatisUtil.getSession();  
	    }  
	      
	    @After  
	    public void after() {  
	        session.commit();  
	        session.close();  
	    }  
	      
	    @Test  
	    public void testGetSession() {  
	        assertNotNull(session);  
	          
	        if(session != null) {  
	            session.close();  
	            session = null;  
	        }  
	    }  
	      
	    @Test  
	    public void testSelectUser() {  
	        List<UserEntity> userList = session.selectList("org.ygy.mapper.UserMapper.selectUser");  
	          
	        for(UserEntity each : userList) {  
	            System.out.println("each->" + each);  
	        }  
	          
	    }  
	      
}
