package com.thuannd.xemdiemthi.dao;

import java.util.List;

import com.thuannd.xemdiemthi.entities.Diem;
import com.thuannd.xemdiemthi.entities.SinhVien;
import com.thuannd.xemdiemthi.entities.diemTKMonHoc;
import java.util.ArrayList;

public interface UserDAO {
	
	SinhVien login(String maSinhVien, String password);
	
	List<Diem> getResultPoint(int maSV, int kyHoc);
	
	List<Diem> getSemesters(SinhVien sinhVien);
        
        ArrayList<diemTKMonHoc> getDiemTongKetMonHocTheoKy(int maSV, int kyHoc);
        
        int soTinChiDatDuoc(int id_sinh_vien, int kyHoc);
        
        float diemTBHocKy(int maSV, int hocKy);
        
        float diemTBTichLuy(int maSV, int hocKy);
        
        int soTinChiTichLuy(int maSV, int hocKy);
        
        float diemTBHocKyHe4(int maSV, int hocKy);
        
        float diemTBTichLuyHe4(int maSV, int hocKy);
}
