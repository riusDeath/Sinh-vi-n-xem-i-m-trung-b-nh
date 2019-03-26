package com.thuannd.xemdiemthi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.thuannd.xemdiemthi.dao.CauHinhDAO;
import com.thuannd.xemdiemthi.dao.MonHocDAO;
import com.thuannd.xemdiemthi.dao.SinhVienDAO;
import com.thuannd.xemdiemthi.dao.UserDAO;
import com.thuannd.xemdiemthi.entities.Diem;
import com.thuannd.xemdiemthi.entities.SinhVien;
import com.thuannd.xemdiemthi.utils.DBConnection;
import com.thuannd.xemdiemthi.utils.GioiTinh;

public class UserDAOImpl implements UserDAO {

	private Connection connection;
	private CauHinhDAO cauHinhDAO;
	private SinhVienDAO sinhVienDAO;
	private MonHocDAO monHocDAO;

	public UserDAOImpl() {
		super();
		this.setCauHinhDAO(new CauHinhDAOImpl());
		this.setSinhVienDAO(new SinhVienDAOImpl());
		this.setMonHocDAO(new MonHocDAOImpl());
	}

	@Override
	public SinhVien login(String maSinhVien, String password) {
		connection = DBConnection.connect();
		try {
			String sql = "SELECT * FROM sinhvien WHERE ma_sinh_vien = ? AND password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maSinhVien);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				SinhVien sinhVien = new SinhVien();
				sinhVien.setId(rs.getInt("id"));
				sinhVien.setPassqword(rs.getString("password"));
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
				return sinhVien;
			}
		} catch (Exception exception) {
			System.out.println("ket noi that bai!");
		}
		return null;
	}

	@Override
	public List<Diem> getResultPoint(SinhVien sinhVien, int kyHoc) {
		connection = DBConnection.connect();
		String sql = "SELECT * FROM diem WHERE id_sinh_vien = ? AND id_mon_hoc IN (SELECT id FROM mon_hoc WHERE ky_hoc = ?)";
		List<Diem> diems = new ArrayList<Diem>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, sinhVien.getId());
			preparedStatement.setInt(2, kyHoc);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Diem diem = new Diem();
				diem.setId(rs.getInt("id"));
				diem.setCauHinh(cauHinhDAO.getCauHinById(rs.getInt("id_cau_hinh")));
				diem.setMonHoc(monHocDAO.getMonHocById(rs.getInt("id_mon_hoc")));
				diem.setSinhVien(sinhVienDAO.getSinhVienById(rs.getInt("id_sinh_vien")));
				diem.setCc(rs.getFloat("chuyen_can"));
				diem.setKt(rs.getFloat("kiem_tra"));
				diem.setTh(rs.getFloat("thuc_hanh"));
				diem.setBtl(rs.getFloat("bai_tap_lon"));
				diem.setCuoiKy(rs.getFloat("cuoi_ky"));

				diems.add(diem);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return diems;
	}

	@Override
	public List<Diem> getSemesters(SinhVien sinhVien) {
		connection = DBConnection.connect();
		String sql = "SELECT diem.* FROM diem INNER JOIN mon_hoc ON diem.id_mon_hoc = mon_hoc.id WHERE id_sinh_vien = ? ORDER BY mon_hoc.ky_hoc";
		List<Diem> diems = new ArrayList<Diem>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, sinhVien.getId());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Diem diem = new Diem();
				diem.setId(rs.getInt("id"));
				diem.setCauHinh(cauHinhDAO.getCauHinById(rs.getInt("id_cau_hinh")));
				diem.setMonHoc(monHocDAO.getMonHocById(rs.getInt("id_mon_hoc")));
				diem.setSinhVien(sinhVienDAO.getSinhVienById(rs.getInt("id_sinh_vien")));
				diem.setCc(rs.getFloat("chuyen_can"));
				diem.setKt(rs.getFloat("kiem_tra"));
				diem.setTh(rs.getFloat("thuc_hanh"));
				diem.setBtl(rs.getFloat("bai_tap_lon"));
				diem.setCuoiKy(rs.getFloat("cuoi_ky"));

				diems.add(diem);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return diems;
	}

	public CauHinhDAO getCauHinhDAO() {
		return cauHinhDAO;
	}

	public void setCauHinhDAO(CauHinhDAO cauHinhDAO) {
		this.cauHinhDAO = cauHinhDAO;
	}

	public SinhVienDAO getSinhVienDAO() {
		return sinhVienDAO;
	}

	public void setSinhVienDAO(SinhVienDAO sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;
	}

	public MonHocDAO getMonHocDAO() {
		return monHocDAO;
	}

	public void setMonHocDAO(MonHocDAO monHocDAO) {
		this.monHocDAO = monHocDAO;
	}

}
