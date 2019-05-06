package com.thuannd.test.models;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thuannd.xemdiemthi.entities.diemTKMonHoc;

public class TestDiemTKMonHoc {

	private static diemTKMonHoc diemTK;

	@BeforeClass
	public static void init() {
		diemTK = new diemTKMonHoc();
	}

	@Test
	public void testGetSoTinChi() {
		diemTK.setSoTinChi(3);
		assertTrue(diemTK.getSoTinChi() == 3);
	}

	@Test
	public void testGetDiemTK() {
		diemTK.setDiemTK(8.9f);
		assertTrue(diemTK.getDiemTK() == 8.9f);

	}

}
