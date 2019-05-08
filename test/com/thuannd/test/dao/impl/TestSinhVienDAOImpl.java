package com.thuannd.test.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		assertNotNull(connection);
		sinhVienDAO = new SinhVienDAOImpl();
	}
	
	@Test
	public void testGetSinhVienById() {
		SinhVien sinhVien = sinhVienDAO.getSinhVienById(1);
		assertNotNull(sinhVien);
		assertEquals("nguyễn đức thuận", sinhVien.getHoTen());
		assertEquals("b15cqcn6", sinhVien.getLop());
		assertEquals("cntt", sinhVien.getKhoa());
		assertEquals("nam", sinhVien.getGioiTinh());
		assertEquals("bắc ninh", sinhVien.getQueQuan());
		assertEquals("đại học chính quy", sinhVien.getHeDaoTao());
	}
	
}
