package com.thuannd.test.models;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thuannd.xemdiemthi.entities.MonHoc;

public class TestMonHoc {

	private static MonHoc monHoc;
	
	@BeforeClass
	public static void init() {
		monHoc = new MonHoc();
	}
	
	@Test
	public void testGetTenMonHoc() {
		monHoc.setTenMonHoc("SQA");
		assertTrue("SQA".equals(monHoc.getTenMonHoc()));
	}
	
	@Test
	public void testGetNganhHoc() {
		monHoc.setNganhHoc("CNPM");
		assertTrue("CNPM".equals(monHoc.getNganhHoc()));
	}
	
	@Test
	public void testGetKyHoc() {
		monHoc.setKyHoc(1);
		assertTrue(monHoc.getKyHoc() == 1);
	}
	
	@Test
	public void testGetSoTinChi() {
		monHoc.setSoTinChi(3);
		assertTrue(monHoc.getSoTinChi() == 3);
	}
	
}
