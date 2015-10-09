package com.fissionlabs.keethu.junit;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.fissionlabs.keethu.dao.StudentDao;
import com.fissionlabs.keethu.dao.StudentDaoImpl;
import com.fissionlabs.keethu.model.Student;

public class saveTest {
	Session session;


	@Test
	public void test() {
	StudentDao dao=new StudentDaoImpl();
	String name="karthik";
	String password="kanna123";
	boolean result=dao.search(name, password);
	assertEquals(true,result);
	
	}

}
