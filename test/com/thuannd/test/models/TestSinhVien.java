package com.thuannd.test.models;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thuannd.xemdiemthi.entities.SinhVien;

public class TestSinhVien {
	
	private static SinhVien sinhVien;
	
	@BeforeClass
	public static void init() {
		sinhVien = new SinhVien();
	}
	
	@Test
	public void testGetMaSinhVien() {
		sinhVien.setMaSinhVien("B15DCCN545");
		assertTrue("B15DCCN545".equals(sinhVien.getMaSinhVien()));
	}
	
	@Test
	public void testGetHoTen() {
		sinhVien.setPassqword("123456");
		assertTrue("123456".equals(sinhVien.getPassqword()));
	}
	
	@Test
	public void testGetLop() {
		sinhVien.setLop("D15CN6");
		assertTrue("D15CN6".equals(sinhVien.getLop()));
	}
	
	@Test
	public void testGetKhoa() {
		sinhVien.setKhoa("CNTT");
		assertTrue("CNTT".equals(sinhVien.getKhoa()));
	}
	
	@Test
	public void testGetGioiTinh() {
		sinhVien.setGioiTinh("nam");
		assertTrue("nam".equals(sinhVien.getGioiTinh()));
	}
	
	@Test
	public void testGetQueQuan() {
		sinhVien.setQueQuan("bac ninh");
		assertTrue("bac ninh".equals(sinhVien.getQueQuan()));
	}
	
	@Test
	public void testGetHeDaoTao() {
		sinhVien.setHeDaoTao("Dai hoc chinh quy");
		assertTrue("Dai hoc chinh quy".equals(sinhVien.getHeDaoTao()));
	}
	
}
