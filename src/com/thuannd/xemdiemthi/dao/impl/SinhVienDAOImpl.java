package com.thuannd.xemdiemthi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.thuannd.xemdiemthi.dao.SinhVienDAO;
import com.thuannd.xemdiemthi.entities.SinhVien;
import com.thuannd.xemdiemthi.utils.DBConnection;
import com.thuannd.xemdiemthi.utils.GioiTinh;

public class SinhVienDAOImpl implements SinhVienDAO {

	private Connection connection;

	@Override
	public SinhVien getSinhVienById(int idSinhVien) {
		connection = DBConnection.connect();
		try {
			String sql = "SELECT * FROM sinhvien WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idSinhVien);
			ResultSet rs = preparedStatement.executeQuery();
			SinhVien sinhVien = new SinhVien();
			while (rs.next()) {
				sinhVien.setId(idSinhVien);
				sinhVien.setHoTen(rs.getString("ho_ten"));
				sinhVien.setMaSinhVien(rs.getString("ma_sinh_vien"));
				sinhVien.setKhoa(rs.getString("khoa"));
				sinhVien.setLop(rs.getString("lop"));
				// sinhVien.setNgaySinh(rs.getDate("ngay_sinh"));
				if (rs.getInt("gioi_tinh") == GioiTinh.NAM) {
					sinhVien.setGioiTinh("nam");
				} else {
					sinhVien.setGioiTinh("nu");
				}
				sinhVien.setQueQuan(rs.getString("que_quan"));
				sinhVien.setHeDaoTao(rs.getString("he_dao_tao"));
			}
			return sinhVien;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
