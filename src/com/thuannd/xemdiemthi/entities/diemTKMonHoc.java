/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thuannd.xemdiemthi.entities;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class diemTKMonHoc implements Serializable {
    private int soTinChi;
    private float diemTK;

    public diemTKMonHoc(int soTinChi, float diemTK) {
        this.soTinChi = soTinChi;
        this.diemTK = diemTK;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public float getDiemTK() {
        return diemTK;
    }

    public void setDiemTK(int diemTK) {
        this.diemTK = diemTK;
    }

    
    
}
