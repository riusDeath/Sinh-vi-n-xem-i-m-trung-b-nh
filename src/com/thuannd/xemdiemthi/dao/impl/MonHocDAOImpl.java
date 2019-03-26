package com.thuannd.xemdiemthi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.thuannd.xemdiemthi.dao.MonHocDAO;
import com.thuannd.xemdiemthi.entities.MonHoc;
import com.thuannd.xemdiemthi.utils.DBConnection;

public class MonHocDAOImpl implements MonHocDAO {

	private Connection connection;

	@Override
	public MonHoc getMonHocById(int idMonHoc) {
		connection = DBConnection.connect();
		try {
			String sql = "SELECT * FROM mon_hoc WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idMonHoc);
			ResultSet rs = preparedStatement.executeQuery();
			MonHoc monHoc = new MonHoc();
			while (rs.next()) {
				monHoc.setId(idMonHoc);
				monHoc.setKyHoc(rs.getInt("ky_hoc"));
				monHoc.setNganhHoc(rs.getString("nganh_hoc"));
				monHoc.setTenMonHoc(rs.getString("ten_mon_hoc"));
				monHoc.setSoTinChi(rs.getInt("so_tin_chi"));
			}
			return monHoc;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
