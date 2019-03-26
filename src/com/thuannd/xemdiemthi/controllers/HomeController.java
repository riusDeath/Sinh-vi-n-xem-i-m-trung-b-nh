package com.thuannd.xemdiemthi.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thuannd.xemdiemthi.dao.UserDAO;
import com.thuannd.xemdiemthi.dao.impl.UserDAOImpl;
import com.thuannd.xemdiemthi.entities.SinhVien;

@WebServlet("/dang-nhap")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;

	public HomeController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		userDAO = new UserDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maSinhVien = request.getParameter("ctl00$ContentPlaceHolder1$ctl00$txtTaiKhoa");
		String password = request.getParameter("ctl00$ContentPlaceHolder1$ctl00$txtMatKhau");
		SinhVien sinhVien = userDAO.login(maSinhVien, password);
		if (sinhVien != null) {
			HttpSession session = request.getSession();
			session.setAttribute("current_user", sinhVien.getHoTen());
			session.setAttribute("current_id", sinhVien.getId());
			session.setAttribute("current_code", sinhVien.getMaSinhVien());
			session.setAttribute("current_user_date", sinhVien.getNgaySinh());
			session.setAttribute("current_major", sinhVien.getKhoa());
			session.setAttribute("current_class", sinhVien.getLop());
			session.setAttribute("current_sex", sinhVien.getGioiTinh());
			session.setAttribute("current_user_addr", sinhVien.getQueQuan());
			session.setAttribute("current_tranning", sinhVien.getHeDaoTao());
			
			response.sendRedirect(request.getContextPath() + "/xem-diem-thi");
		} else {
			response.sendRedirect("/xemdiemthi/dang-nhap");
		}
	}

}
