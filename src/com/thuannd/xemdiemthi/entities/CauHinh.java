package com.thuannd.xemdiemthi.entities;

import java.io.Serializable;

public class CauHinh implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private float chuyenCan;
	private float kiemTra;
	private float thucHanh;
	private float cuoiKy;
	private float baiTapLon;

	public CauHinh() {
		super();
	}

	public CauHinh(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getChuyenCan() {
		return chuyenCan;
	}

	public void setChuyenCan(float chuyenCan) {
		this.chuyenCan = chuyenCan;
	}

	public float getKiemTra() {
		return kiemTra;
	}

	public void setKiemTra(float kiemTra) {
		this.kiemTra = kiemTra;
	}

	public float getThucHanh() {
		return thucHanh;
	}

	public void setThucHanh(float thucHanh) {
		this.thucHanh = thucHanh;
	}

	public float getcuoiKy() {
		return cuoiKy;
	}

	public void setcuoiKy(float cuoiKy) {
		this.cuoiKy = cuoiKy;
	}

	public float getBaiTapLon() {
		return baiTapLon;
	}

	public void setBaiTapLon(float baiTapLon) {
		this.baiTapLon = baiTapLon;
	}

}
