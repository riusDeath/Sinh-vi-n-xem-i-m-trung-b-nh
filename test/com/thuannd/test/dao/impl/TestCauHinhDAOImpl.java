package com.thuannd.test.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import org.junit.BeforeClass;
import org.junit.Test;

import com.thuannd.xemdiemthi.dao.CauHinhDAO;
import com.thuannd.xemdiemthi.dao.impl.CauHinhDAOImpl;
import com.thuannd.xemdiemthi.entities.CauHinh;
import com.thuannd.xemdiemthi.utils.DBConnection;

public class TestCauHinhDAOImpl {

	private static Connection connection;
	
	private static CauHinhDAO cauHinhDAO;
	
	@BeforeClass
	public static void init() {
		connection = DBConnection.connect();
		cauHinhDAO = new CauHinhDAOImpl();
	}
	
	@Test
	public void testGetCauHinhById() {
		CauHinh cauHinh = cauHinhDAO.getCauHinById(1);
		assertEquals(0.1f, cauHinh.getChuyenCan());
	}
	
}
