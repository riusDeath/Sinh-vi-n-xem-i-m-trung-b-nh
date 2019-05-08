package com.thuannd.test.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thuannd.xemdiemthi.dao.UserDAO;
import com.thuannd.xemdiemthi.dao.impl.UserDAOImpl;
import com.thuannd.xemdiemthi.entities.Diem;
import com.thuannd.xemdiemthi.entities.SinhVien;
import com.thuannd.xemdiemthi.entities.diemTKMonHoc;
import com.thuannd.xemdiemthi.utils.DBConnection;

public class TestUserDAOImpl {

	private static Connection conn;
	private static UserDAO userDAO;
	private static UserDAOImpl userDAOImpl;

	@BeforeClass
	public static void init() {
		conn = DBConnection.connect();
		assertNotNull(conn);
		userDAO = new UserDAOImpl();
		userDAOImpl = new UserDAOImpl();
	}

	@Test
	public void testLogin() {
		// standard scenario
		SinhVien sinhVien = userDAO.login("b15dccn545", "123");
		assertNotNull(sinhVien);
		assertEquals("nguyễn đức thuận", sinhVien.getHoTen());
		assertEquals("b15cqcn6", sinhVien.getLop());
		assertEquals("cntt", sinhVien.getKhoa());
		assertEquals("nam", sinhVien.getGioiTinh());
		assertEquals("bắc ninh", sinhVien.getQueQuan());
		assertEquals("đại học chính quy", sinhVien.getHeDaoTao());

		// exception scenario
		SinhVien sinhVien1 = userDAO.login("abc", "12122");
		assertNull(sinhVien1);

		SinhVien sinhVien2 = userDAO.login("", "");
		assertNull(sinhVien2);

		SinhVien sinhVien3 = userDAO.login("b15dccn545", "hi' or 1=1--");
		assertNull(sinhVien3);
	}

	@Test
	public void testGetResultPoint() {
		// standard scenario
		List<Diem> diems = (ArrayList<Diem>) userDAO.getResultPoint(1, 1);
		assertNotNull(diems);
		assertEquals(3, diems.size());
		assertEquals("Đại Số", diems.get(0).getMonHoc().getTenMonHoc());
		assertEquals("Giải Tích 1", diems.get(1).getMonHoc().getTenMonHoc());
		assertEquals("THCS 1", diems.get(2).getMonHoc().getTenMonHoc());

		// exception scenario
		List<Diem> diems2 = (ArrayList<Diem>) userDAO.getResultPoint(2, 1);
		assertEquals(0, diems2.size());
	}

	@Test
	public void testGetDiemTongKetMonHocTheoKy() {
		//standard scenario
		List<diemTKMonHoc> tkMonHocs = userDAO.getDiemTongKetMonHocTheoKy(1, 1);
		assertNotNull(tkMonHocs);
		assertEquals(3, tkMonHocs.size());
		assertEquals(7.9f, tkMonHocs.get(0).getDiemTK());
		assertEquals(7.8f, tkMonHocs.get(1).getDiemTK());
		assertEquals(7.3f, tkMonHocs.get(2).getDiemTK());
		
		// exception scenario
		List<diemTKMonHoc> tkMonHocs2 = userDAO.getDiemTongKetMonHocTheoKy(2, 1);
		assertEquals(0, tkMonHocs2.size());
	}

	@Test
	public void testDiemTBHocKy() {
		// standard scenario
		float actual = userDAO.diemTBHocKy(1, 1);
		assertEquals(7.6666665f, actual);
		
		//exception scenario
		float actual2 = userDAO.diemTBHocKy(2, 1);
		assertTrue(Float.isNaN(actual2));
	}

	@Test
	public void testGetDiemTongKetMonHoc() {
		// standard scenario
		List<diemTKMonHoc> actual = userDAO.getDiemTongKetMonHocTheoKy(1, 1);
		assertNotNull(actual);
		assertEquals(3, actual.size());
		assertEquals(7.9f, actual.get(0).getDiemTK());
		assertEquals(7.8f, actual.get(1).getDiemTK());
		assertEquals(7.3f, actual.get(2).getDiemTK());
		
		// exception scenario
		List<diemTKMonHoc> actual2 = userDAO.getDiemTongKetMonHocTheoKy(2, 1);
		assertEquals(0, actual2.size());
	}

	@Test
	public void testDiemTBTichLuy() {
		// standard scenario
		float actual = userDAO.diemTBTichLuy(1, 2);
		assertEquals(7.625f, actual);

		// exception scenario
		Float actual2 = userDAO.diemTBTichLuy(2, 2);
		assertTrue(Float.isNaN(actual2));
	}

	@Test
	public void testSoTinChiDatDuoc() {
		// standard scenario
		int actual = userDAO.soTinChiDatDuoc(1, 2);
		assertEquals(3, actual);
	}

	@Test
	public void testSoTinChiTichLuy() {
		// standard scenario
		int actual = userDAO.soTinChiTichLuy(1, 2);
		assertEquals(12, actual);
	}

	@Test
	public void testDiemTBHocKyHe4() {
		// standard scenario
		float actual = userDAO.diemTBHocKyHe4(1, 1);
		assertEquals(3.0f, actual);

		// exception scenario
		float actual2 = userDAO.diemTBHocKy(2, 1);
		assertTrue(Float.isNaN(actual2));
	}

	@Test
	public void testDiemTBTichLuyHe4() {
		// standard scenario
		float actual = userDAO.diemTBTichLuyHe4(1, 2);
		assertEquals(3.0f, actual);

		// exception scenario
		float actual2 = userDAO.diemTBTichLuyHe4(2, 2);
		assertTrue(Float.isNaN(actual2));
	}

	@Test
	public void testDiemHe4() {
		// standard scenario
		float actual1 = userDAOImpl.diemHe4(3.9f);
		assertEquals(0, actual1);
	}

	@Test
	public void testDiemHe42() {
		float actual2 = userDAOImpl.diemHe4(4.9f);
		assertEquals(1, actual2);
	}

	@Test
	public void testDiemHe43() {
		float actual3 = userDAOImpl.diemHe4(5.4f);
		assertEquals(1.5f, actual3);
	}

	@Test
	public void testDiemHe44() {
		float actual4 = userDAOImpl.diemHe4(6.4f);
		assertEquals(2, actual4);
	}

	@Test
	public void testDiemHe45() {
		float actual5 = userDAOImpl.diemHe4(6.9f);
		assertEquals(2.5, actual5);
	}

	@Test
	public void testDiemHe46() {
		float actual6 = userDAOImpl.diemHe4(7.9f);
		assertEquals(3, actual6);
	}

	@Test
	public void testDiemHe47() {
		float actual7 = userDAOImpl.diemHe4(8.4f);
		assertEquals(3.5, actual7);
	}

	@Test
	public void testDiemHe48() {
		float actual8 = userDAOImpl.diemHe4(8.9f);
		assertEquals(3.7f, actual8);
	}

	@Test
	public void testDiemHe49() {
		float actual9 = userDAOImpl.diemHe4(9.9f);
		assertEquals(4, actual9);
	}

}
