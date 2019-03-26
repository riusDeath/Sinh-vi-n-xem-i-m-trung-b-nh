package com.thuannd.xemdiemthi.entities;

import java.io.Serializable;
import java.util.Date;

public class SinhVien implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String maSinhVien;
	private String hoTen;
	private String passqword;
	private String lop;
	private String khoa;
	private Date ngaySinh;
	private String gioiTinh;
	private String queQuan;
	private String heDaoTao;

	public SinhVien() {
		super();
	}

	public SinhVien(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getPassqword() {
		return passqword;
	}

	public void setPassqword(String passqword) {
		this.passqword = passqword;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(String heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

}
