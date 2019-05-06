package com.thuannd.test.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thuannd.xemdiemthi.dao.SinhVienDAO;
import com.thuannd.xemdiemthi.dao.impl.SinhVienDAOImpl;
import com.thuannd.xemdiemthi.entities.SinhVien;
import com.thuannd.xemdiemthi.utils.DBConnection;

public class TestSinhVienDAOImpl {

	private static Connection connection;
	
	private static SinhVienDAO sinhVienDAO;
	
	@BeforeClass
	public static void init() {
		connection = DBConnection.connect();
		sinhVienDAO = new SinhVienDAOImpl();
	}
	
	@Test
	public void testGetSinhViewnById() {
		SinhVien sinhVien = sinhVienDAO.getSinhVienById(1);
		assertEquals("nguyễn đức thuận", sinhVien.getHoTen());
	}
	
}
