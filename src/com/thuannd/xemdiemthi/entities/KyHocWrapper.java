package com.thuannd.xemdiemthi.entities;

import java.io.Serializable;
import java.util.List;

public class KyHocWrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	private int kyHoc;
	private List<Diem> diems;
	private double diemTBTichLuy;
	private double diemTBTichLuyHe4;
	private double diemTBHocKy;
	private double diemTBHocKyHe4;
	private int soTinChiDatDuoc;
	private int soTinChiTichLuy;
	
	public KyHocWrapper() {
		super();
	}

	public int getKyHoc() {
		return kyHoc;
	}

	public void setKyHoc(int kyHoc) {
		this.kyHoc = kyHoc;
	}

	public List<Diem> getDiems() {
		return diems;
	}

	public void setDiems(List<Diem> diems) {
		this.diems = diems;
	}

	public double getDiemTBTichLuy() {
		return diemTBTichLuy;
	}

	public void setDiemTBTichLuy(double diemTBTichLuy) {
		this.diemTBTichLuy = diemTBTichLuy;
	}

	public double getDiemTBTichLuyHe4() {
		return diemTBTichLuyHe4;
	}

	public void setDiemTBTichLuyHe4(double diemTBTichLuyHe4) {
		this.diemTBTichLuyHe4 = diemTBTichLuyHe4;
	}

	public double getDiemTBHocKy() {
		return diemTBHocKy;
	}

	public void setDiemTBHocKy(double diemTBHocKy) {
		this.diemTBHocKy = diemTBHocKy;
	}

	public double getDiemTBHocKyHe4() {
		return diemTBHocKyHe4;
	}

	public void setDiemTBHocKyHe4(double diemTBHocKyHe4) {
		this.diemTBHocKyHe4 = diemTBHocKyHe4;
	}

	public int getSoTinChiDatDuoc() {
		return soTinChiDatDuoc;
	}

	public void setSoTinChiDatDuoc(int soTinChiDatDuoc) {
		this.soTinChiDatDuoc = soTinChiDatDuoc;
	}

	public int getSoTinChiTichLuy() {
		return soTinChiTichLuy;
	}

	public void setSoTinChiTichLuy(int soTinChiTichLuy) {
		this.soTinChiTichLuy = soTinChiTichLuy;
	}

}
