package com.thuannd.xemdiemthi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.thuannd.xemdiemthi.dao.CauHinhDAO;
import com.thuannd.xemdiemthi.entities.CauHinh;
import com.thuannd.xemdiemthi.utils.DBConnection;

public class CauHinhDAOImpl implements CauHinhDAO {

	private Connection connection;

	@Override
	public CauHinh getCauHinById(int idCauHinh) {
		connection = DBConnection.connect();
		try {
			String sql = "SELECT * FROM cau_hinh WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idCauHinh);
			ResultSet rs = preparedStatement.executeQuery();
			CauHinh cauHinh = new CauHinh();
			while (rs.next()) {
				cauHinh.setId(idCauHinh);
				cauHinh.setChuyenCan(rs.getFloat("chuyen_can"));
				cauHinh.setThucHanh(rs.getFloat("thuc_hanh"));
				cauHinh.setKiemTra(rs.getFloat("kiem_tra"));
				cauHinh.setBaiTapLon(rs.getFloat("bao_tap_lon"));
				cauHinh.setcuoiKy(rs.getFloat("cuoi_ky"));
			}
			return cauHinh;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
