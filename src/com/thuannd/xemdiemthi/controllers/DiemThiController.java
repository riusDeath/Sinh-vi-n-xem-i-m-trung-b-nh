package com.thuannd.xemdiemthi.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thuannd.xemdiemthi.dao.UserDAO;
import com.thuannd.xemdiemthi.dao.impl.UserDAOImpl;
import com.thuannd.xemdiemthi.entities.Diem;
import com.thuannd.xemdiemthi.entities.SinhVien;
import com.thuannd.xemdiemthi.entities.diemTKMonHoc;
import java.util.ArrayList;

@WebServlet(urlPatterns = { "/xem-diem-thi" })
public class DiemThiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;

	public DiemThiController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		userDAO = new UserDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("diem-thi.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(session.getAttribute("current_id").toString());
		int kyHoc = Integer.parseInt(request.getParameter("ky_hoc").toString());
		
		List<Diem> diems = userDAO.getResultPoint(id, kyHoc);
		request.setAttribute("results", diems);
		request.setAttribute("ky_hoc", kyHoc);
                
                float diemTBTichLuy = userDAO.diemTBTichLuy(id, kyHoc);
                request.setAttribute("diemTBTichLuy", (double) Math.floor(diemTBTichLuy * 100) / 100 );
                
                
                float diemTBTichLuyHe4 = userDAO.diemTBTichLuyHe4(id, kyHoc);
                request.setAttribute("diemTBTichLuyHe4", (double) Math.floor(diemTBTichLuyHe4 * 100) / 100 );

                float diemTBHocKy = userDAO.diemTBHocKy(id, kyHoc);
                request.setAttribute("diemTBHocKy", (double) Math.floor(diemTBHocKy * 100) / 100 );
                
                float diemTBHocKyHe4 = userDAO.diemTBHocKyHe4(id, kyHoc);
                request.setAttribute("diemTBHocKyHe4", (double) Math.floor(diemTBHocKyHe4 * 100) / 100);
                
                int soTinChiDatDuoc = userDAO.soTinChiDatDuoc(id, kyHoc);
                request.setAttribute("soTinChiDatDuoc", soTinChiDatDuoc);
                
                int soTinChiTichLuy = userDAO.soTinChiTichLuy(id, kyHoc);
                request.setAttribute("soTinChiTichLuy", soTinChiTichLuy);
                
                request.setAttribute("kyHoc", kyHoc);
                
                
		RequestDispatcher dispatcher = request.getRequestDispatcher("diem-thi.jsp");
		dispatcher.forward(request, response);
	}

}
