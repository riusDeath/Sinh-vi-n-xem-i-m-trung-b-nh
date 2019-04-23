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
import com.thuannd.xemdiemthi.entities.KyHocWrapper;
import com.thuannd.xemdiemthi.entities.SinhVien;
import com.thuannd.xemdiemthi.entities.diemTKMonHoc;
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
		connection = DBConnection.connect();
	}

	@Override
	public SinhVien login(String maSinhVien, String password) {
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
	public ArrayList<Diem> getResultPoint(int maSV, int kyHoc) {
//		String sql = "SELECT *,  FROM diem WHERE id_sinh_vien = ? AND id_mon_hoc IN (SELECT id FROM mon_hoc WHERE ky_hoc = ?)";
		String sql = "SELECT * ,  " +
                        "(diem.chuyen_can * cau_hinh.chuyen_can "
                        + "+ diem.bai_tap_lon * cau_hinh.bao_tap_lon "
                        + "+ diem.cuoi_ky * cau_hinh.cuoi_ky "
                        + "+ diem.thuc_hanh * cau_hinh.thuc_hanh)  as tkMon" +
                        " FROM diem INNER JOIN cau_hinh ON diem.id_cau_hinh = cau_hinh.id " +
                        "INNER JOIN mon_hoc ON diem.id_mon_hoc = mon_hoc.id " +
                        "where diem.id_sinh_vien = " +maSV+ " " +
                        "AND mon_hoc.ky_hoc = "+kyHoc+"";
                System.out.println(sql);
                ArrayList<Diem> diems = new ArrayList<Diem>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
                                diem.setDiemTK((double) Math.floor(rs.getFloat("tkMon") * 100) / 100);
				diems.add(diem);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return diems;
	}

	// xem tat ca hoc ky
	@Override
	public List<KyHocWrapper> getAllSemester(SinhVien sinhVien){
		List<KyHocWrapper> kyHocWrappers = new ArrayList<KyHocWrapper>();
		for(int i = 1; i <=8; i++) {
			KyHocWrapper kyHocWrapper = new KyHocWrapper();
			kyHocWrapper.setKyHoc(i);
			List<Diem> diems = this.getResultPoint(sinhVien.getId(), i);
			kyHocWrapper.setDiems(diems);
			kyHocWrapper.setDiemTBHocKy(Math.floor((this.diemTBHocKy(sinhVien.getId(), i)) * 100) / 100);
			kyHocWrapper.setDiemTBHocKyHe4(Math.floor((this.diemTBHocKyHe4(sinhVien.getId(), i)) * 100) / 100);
			kyHocWrapper.setDiemTBTichLuy(Math.floor((this.diemTBTichLuy(sinhVien.getId(), i)) * 100) / 100);
			kyHocWrapper.setDiemTBTichLuyHe4(Math.floor((this.diemTBTichLuyHe4(sinhVien.getId(), i)) * 100) / 100);
			kyHocWrapper.setSoTinChiDatDuoc(this.soTinChiDatDuoc(sinhVien.getId(), i));
			kyHocWrapper.setSoTinChiTichLuy(this.soTinChiTichLuy(sinhVien.getId(), i));
			
			kyHocWrappers.add(kyHocWrapper);
		}
		return kyHocWrappers;
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

    @Override
    public ArrayList<diemTKMonHoc> getDiemTongKetMonHocTheoKy(int maSV, int kyHoc) {
        String sql = "SELECT mon_hoc.so_tin_chi, " +
                        "(diem.chuyen_can * cau_hinh.chuyen_can "
                        + "+ diem.bai_tap_lon * cau_hinh.bao_tap_lon "
                        + "+ diem.cuoi_ky * cau_hinh.cuoi_ky "
                        + "+ diem.thuc_hanh * cau_hinh.thuc_hanh)  as tb" +
                        " FROM diem INNER JOIN cau_hinh ON diem.id_cau_hinh = cau_hinh.id " +
                        "INNER JOIN mon_hoc ON diem.id_mon_hoc = mon_hoc.id " +
                        "where diem.id_sinh_vien = " +maSV+ " " +
                        "AND mon_hoc.ky_hoc = "+kyHoc+"";
        ArrayList<diemTKMonHoc> diems = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                diems.add(new diemTKMonHoc(rs.getInt("so_tin_chi"), rs.getFloat("tb")));
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }

        return diems;
    }
    
    @Override
    public float diemTBHocKy(int maSV, int hocKy) {
        float diemTBHocKy = 0;
        int tongSoTinChi = 0;
        ArrayList<diemTKMonHoc> diemTKMonHoc = this.getDiemTongKetMonHocTheoKy(maSV, hocKy);
        float tongDiem = 0;
        for (diemTKMonHoc diem :  diemTKMonHoc) {
            System.out.println(diem.getDiemTK());
            System.out.println(diem.getSoTinChi());
            tongDiem += diem.getDiemTK() * diem.getSoTinChi();
            tongSoTinChi += diem.getSoTinChi();
        }

        diemTBHocKy = tongDiem/tongSoTinChi;
        return diemTBHocKy;
    }
    
    public ArrayList<diemTKMonHoc> getDiemTongKetMonHoc(int maSV, int hocKy) {
        ArrayList<diemTKMonHoc> diemTongKetMonHoc = new ArrayList<diemTKMonHoc>();
		String sql = "SELECT mon_hoc.so_tin_chi, " +
                                "(diem.chuyen_can * cau_hinh.chuyen_can "
                                + "+ diem.bai_tap_lon * cau_hinh.bao_tap_lon "
                                + "+ diem.cuoi_ky * cau_hinh.cuoi_ky "
                                + "+ diem.thuc_hanh * cau_hinh.thuc_hanh)  as tb" +
                                " FROM diem INNER JOIN cau_hinh ON diem.id_cau_hinh = cau_hinh.id " +
                                "INNER JOIN mon_hoc ON diem.id_mon_hoc = mon_hoc.id " +
                                "where diem.id_sinh_vien = " +maSV+ " "
                                + "and mon_hoc.ky_hoc <="+hocKy ;
                System.out.println(sql);
		try {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    ResultSet rs = preparedStatement.executeQuery();
                    while(rs.next()) {
                        diemTongKetMonHoc.add(new diemTKMonHoc(rs.getInt("so_tin_chi"), rs.getFloat("tb")));
                    }
		}catch(Exception ex) {
                    ex.printStackTrace();
		}
		
        return diemTongKetMonHoc;
    }
    
    @Override
    public float diemTBTichLuy (int maSV, int hocKy) {
        float diemTBTichLuy = 0;
        int tongSoTinChi = 0;
        ArrayList<diemTKMonHoc> diemTKMonHoc = this.getDiemTongKetMonHoc(maSV, hocKy);
        float tongDiem = 0;
        for (diemTKMonHoc diem :  diemTKMonHoc) {
            tongDiem += diem.getDiemTK() * diem.getSoTinChi();
            tongSoTinChi += diem.getSoTinChi();
        }
        diemTBTichLuy = tongDiem/tongSoTinChi;
        return diemTBTichLuy;
    }
    
    
    
    @Override
    public int soTinChiDatDuoc(int maSV, int hocKy ) {
        int tongSoTinChi = 0;
        ArrayList<diemTKMonHoc> diemTKMonHoc = this.getDiemTongKetMonHocTheoKy(maSV, hocKy);
        for (diemTKMonHoc diem :  diemTKMonHoc) {
            if (diem.getDiemTK() >= 4) {
                tongSoTinChi += diem.getSoTinChi();
            }
        }
        return tongSoTinChi;
    }

    @Override
    public int soTinChiTichLuy(int id_sinh_vien, int hocKy) {
        int soTinChiDaDat = 0;
        ArrayList<diemTKMonHoc> diemTKMonHoc = this.getDiemTongKetMonHoc(id_sinh_vien, hocKy);
        for (diemTKMonHoc tKMonHoc : diemTKMonHoc) {
            if(tKMonHoc.getDiemTK() >= 4) 
                soTinChiDaDat += tKMonHoc.getSoTinChi();
        }
        return soTinChiDaDat;
    }
    
    @Override
    public  float diemTBHocKyHe4(int maSV, int hocKy){
        float diemTBTichLuyHe4 = 0;
        int tongSoTinChi = 0;
        ArrayList<diemTKMonHoc> diemTKMonHoc = this.getDiemTongKetMonHocTheoKy(maSV, hocKy);
        float tongDiemHe4 = 0;
        for (diemTKMonHoc diem :  diemTKMonHoc) {
            tongDiemHe4 += diemHe4(diem.getDiemTK())*diem.getSoTinChi();
            tongSoTinChi += diem.getSoTinChi();
        }
        diemTBTichLuyHe4 = tongDiemHe4/tongSoTinChi;
        return diemTBTichLuyHe4;
    }
    
    @Override
    public  float diemTBTichLuyHe4(int maSV, int hocKy) {
        float diemTichLuyHe4 = 0;
        int tongSoTinChi = 0;
        ArrayList<diemTKMonHoc> diemTKMonHoc = this.getDiemTongKetMonHoc(maSV, hocKy);
        float tongDiem = 0;
        for (diemTKMonHoc diem :  diemTKMonHoc) {
            tongDiem += diemHe4(diem.getDiemTK())* diem.getSoTinChi();
            tongSoTinChi += diem.getSoTinChi();
        }
        diemTichLuyHe4 = tongDiem/tongSoTinChi;
        return diemTichLuyHe4;
    }
    
    public float diemHe4(float diemTK) {
        float diemHe4 = 0;
        if(diemTK < 4 ) 
            return 0;
        if(diemTK < 5)
            return 1;
        if(diemTK < 5.5)
            return (float) 1.5;
        if(diemTK < 6.5)
            return 2;
        if(diemTK < 7)
            return (float) 2.5;
        if(diemTK < 8)
            return 3;
        if(diemTK < 8.5)
            return (float) 3.5;
        if(diemTK < 9)
            return (float) 3.7;
        if(diemTK <= 10)
            return 4;
        return diemHe4;
    }
    
   
    
    public static void main(String[] args) {
        UserDAOImpl user = new UserDAOImpl();
//        ArrayList<diemTKMonHoc> diemTrungBinhMonHoc = user.getDiemTongKetMonHoc(1, 8);
//            
//        for (diemTKMonHoc diem :  diemTrungBinhMonHoc) {
//            System.out.println(diem.getDiemTK());
//            System.out.println(diem.getSoTinChi());
//            System.out.println(diem.toString());
//        }
//           float diemTBHocKy = user.diemTBHocKy(1,8);
//           System.out.println((double) Math.floor(diemTBHocKy * 100) / 100);
//           float diemTBTichLuy = user.diemTBTichLuy(1);
//           System.out.println((double) Math.floor(diemTBTichLuy * 100) / 100);
//           int soTinChiDaDat = user.soTinChiTichLuy(1);
//           System.out.println(soTinChiDaDat);
//           int soTinChiDatDuoc = user.soTinChiDatDuoc(1, 8);
//           System.out.println(soTinChiDatDuoc);
//           int diemTBHocKyHe4 = user.soTinChiTichLuy(1,7);
//           System.out.println(diemTBHocKyHe4);
            float diemTBHocKyHe4 = user.diemTBHocKyHe4(1, 8);
            System.out.println(diemTBHocKyHe4);
//            List<Diem> diems = user.getResultPoint(1, 8);
//            for (Diem diem : diems) {
//                System.out.println(diem.diemHe4Chu());
//            }
    }
}
