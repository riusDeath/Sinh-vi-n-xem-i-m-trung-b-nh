package com.thuannd.xemdiemthi.entities;

import java.io.Serializable;

public class Diem implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private CauHinh cauHinh;
	private SinhVien sinhVien;
	private MonHoc monHoc;
	private float cc, kt, th, cuoiKy, btl, tk;
        private double diemTK;
	private String tkChu;
        

	public Diem() {
            super();
	}

    public Diem(int id, CauHinh cauHinh, SinhVien sinhVien, MonHoc monHoc, float cc, float kt, float th, float cuoiKy, float btl, float tk, double diemTK, String tkChu) {
        this.id = id;
        this.cauHinh = cauHinh;
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
        this.cc = cc;
        this.kt = kt;
        this.th = th;
        this.cuoiKy = cuoiKy;
        this.btl = btl;
        this.tk = tk;
        this.diemTK = diemTK;
        this.tkChu = tkChu;
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

    public float getCuoiKy() {
        return cuoiKy;
    }

    public void setCuoiKy(float cuoiKy) {
        this.cuoiKy = cuoiKy;
    }

    public float getBtl() {
        return btl;
    }

    public void setBtl(float btl) {
        this.btl = btl;
    }

    public float getTk() {
        return tk;
    }

    public void setTk(float tk) {
        this.tk = tk;
    }

    public double getDiemTK() {
        return diemTK;
    }

    public void setDiemTK(double diemTK) {
        this.diemTK = diemTK;
    }

    public String getTkChu() {
        return tkChu;
    }

    public void setTkChu(String tkChu) {
        this.tkChu = tkChu;
    }

    public  String diemHe4Chu() {
        String diemHe4Chu = "";
        Double diemTK = this.diemTK;
        if(diemTK < 4 ) 
            return "F";
        if(diemTK < 5)
            return "D";
        if(diemTK < 5.5)
            return "D+";
        if(diemTK < 6.5)
            return "C";
        if(diemTK < 7)
            return "C+";
        if(diemTK < 8)
            return "B";
        if(diemTK < 8.5)
            return "B+";
        if(diemTK < 9)
            return "A";
        if(diemTK <= 10)
            return "A+";
        return diemHe4Chu;
    }
	
	
}
