package com.thuannd.test.system;

import org.junit.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import com.thuannd.test.dao.impl.TestCauHinhDAOImpl;
import com.thuannd.test.dao.impl.TestMonHocDAOImpl;
import com.thuannd.test.dao.impl.TestSinhVienDAOImpl;
import com.thuannd.test.dao.impl.TestUserDAOImpl;
import com.thuannd.test.utils.TestDBConnection;

@RunWith(JUnitPlatform.class)
@SelectClasses({TestCauHinhDAOImpl.class, TestMonHocDAOImpl.class, TestSinhVienDAOImpl.class, TestUserDAOImpl.class, TestDBConnection.class})
public class SystemTest {

	/*
	 * 24 testcase - set/get
	 * */
	
	@Test
	public void systemTest() {
		System.out.println("system test!");
	}
	
}
