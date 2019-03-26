package com.thuannd.xemdiemthi.entities;

import java.io.Serializable;

public class Diem implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private CauHinh cauHinh;
	private SinhVien sinhVien;
	private MonHoc monHoc;
	private float cc, kt, th, cuoiKy, btl, tk;
	private String tkChu;

	public Diem() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CauHinh getCauHinh() {
		return cauHinh;
	}

	public void setCauHinh(CauHinh cauHinh) {
		this.cauHinh = cauHinh;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public float getCc() {
		return cc;
	}

	public void setCc(float cc) {
		this.cc = cc;
	}

	public float getKt() {
		return kt;
	}

	public void setKt(float kt) {
		this.kt = kt;
	}

	public float getTh() {
		return th;
	}

	public void setTh(float th) {
		this.th = th;
	}

	public float getBtl() {
		return btl;
	}

	public void setBtl(float btl) {
		this.btl = btl;
	}

	public float getCuoiKy() {
		return cuoiKy;
	}

	public void setCuoiKy(float cuoiKy) {
		this.cuoiKy = cuoiKy;
	}

	public String getTkChu() {
		return tkChu;
	}

	public void setTkChu(String tkChu) {
		this.tkChu = tkChu;
	}

	public float getTk() {
		return tk;
	}

	public void setTk(float tk) {
		this.tk = tk;
	}
	
}
