package com.thuannd.test.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.thuannd.xemdiemthi.entities.CauHinh;

public class TestCauHinh {
	
	@Test
	public void tetGetId() {
		CauHinh cauHinh = new CauHinh();
		cauHinh.setId(1);
		assertTrue(cauHinh.getId() == 1);
	}
	
	@Test
	public void testGetChuyenCan() {
		CauHinh cauHinh = new CauHinh();
		cauHinh.setChuyenCan(10.0f);
		assertTrue(cauHinh.getChuyenCan() == 10.0f);
	}
	
	@Test
	public void testGetKiemTra() {
		CauHinh cauHinh = new CauHinh();
		cauHinh.setKiemTra(8.5f);
		assertTrue(cauHinh.getKiemTra() == 8.5f);
	}
	
	@Test
	public void testGetThucHanh() {
		CauHinh cauHinh = new CauHinh();
		cauHinh.setThucHanh(9.0f);
		assertTrue(cauHinh.getThucHanh() == 9.0f);
	}
	
	@Test
	public void testGetCuoiKy() {
		CauHinh cauHinh = new CauHinh();
		cauHinh.setcuoiKy(7.5f);
		assertTrue(cauHinh.getcuoiKy() == 7.5f);
	}
	
	@Test
	public void testBaiTapLon() {
		CauHinh cauHinh = new CauHinh();
		cauHinh.setBaiTapLon(10.0f);
		assertTrue(cauHinh.getBaiTapLon() == 10.0f);
	}
	
}
