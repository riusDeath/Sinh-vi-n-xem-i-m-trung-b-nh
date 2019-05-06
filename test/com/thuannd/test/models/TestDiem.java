package com.thuannd.test.models;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thuannd.xemdiemthi.entities.CauHinh;
import com.thuannd.xemdiemthi.entities.Diem;
import com.thuannd.xemdiemthi.entities.MonHoc;
import com.thuannd.xemdiemthi.entities.SinhVien;

public class TestDiem {
	
	private static Diem diem;
	
	@BeforeClass
	public static void init() {
		diem = new Diem();
	}
	
	@Test
	public void testGetId() {
		diem.setId(1);
		assertTrue(diem.getId() == 1);
	}
	
	@Test
	public void testGetCauHinh() {
		diem.setCauHinh(new CauHinh());
		assertTrue(diem.getCauHinh() instanceof CauHinh);
	}
	
	@Test
	public void testGetSinhVien() {
		diem.setSinhVien(new SinhVien());
		assertTrue(diem.getSinhVien() instanceof SinhVien);
	}
	
	@Test
	public void testGetMonHoc() {
		diem.setMonHoc(new MonHoc());
		assertTrue(diem.getMonHoc() instanceof MonHoc);
	}
	
	@Test
	public void testGetCC() {
		diem.setCc(10.0f);
		assertTrue(diem.getCc() == 10.0f);
	}
	
	@Test
	public void testGetKT() {
		diem.setKt(10.0f);
		assertTrue(diem.getKt() == 10.0f);
	}
	
	@Test
	public void testGetTH() {
		diem.setTh(10.0f);
		assertTrue(diem.getTh() == 10.0f);
	}
	
	@Test
	public void testGetCuoiKy() {
		diem.setCuoiKy(10.0f);
		assertTrue(diem.getCuoiKy() == 10.0f);
	}
	
	@Test
	public void testGetBtl() {
		diem.setBtl(10.0f);
		assertTrue(diem.getBtl() == 10.0f);
	}
	
	@Test
	public void testGetTk() {
		diem.setTk(10.0f);
		assertTrue(diem.getTk() == 10.0f);
	}
	
	@Test
	public void testGetDiemTK() {
		diem.setDiemTK(8.9);
		assertTrue(diem.getDiemTK() == 8.9);
	}
	
	@Test
	public void testGetTkChu() {
		diem.setTkChu("A");
		assertTrue("A".equals(diem.getTkChu()));
	}
	
	@Test
	public void testDiemHe4Chu() {
		Double diemTK = diem.getDiemTK();
		
	}
	
}
