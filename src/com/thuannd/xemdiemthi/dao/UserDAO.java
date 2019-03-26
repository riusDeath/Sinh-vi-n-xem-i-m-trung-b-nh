package com.thuannd.xemdiemthi.dao;

import java.util.List;

import com.thuannd.xemdiemthi.entities.Diem;
import com.thuannd.xemdiemthi.entities.SinhVien;

public interface UserDAO {
	
	SinhVien login(String maSinhVien, String password);
	
	List<Diem> getResultPoint(SinhVien sinhVien, int kyHoc);
	
	List<Diem> getSemesters(SinhVien sinhVien);
}
