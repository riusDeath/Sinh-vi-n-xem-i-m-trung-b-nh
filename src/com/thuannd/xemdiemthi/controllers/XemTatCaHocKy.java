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

@WebServlet(urlPatterns = { "/tat-ca-hoc-ky" })
public class XemTatCaHocKy extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	@Override
	public void init() throws ServletException {
		super.init();
		setUserDAO(new UserDAOImpl());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id = Integer.parseInt(session.getAttribute("current_id").toString());
		List<Diem> diems = userDAO.getSemesters(new SinhVien(id));
		diems.forEach(diem -> {
			System.out.println("chuyen can + ky hoc: " + diem.getCc() + " ---- " + diem.getMonHoc().getKyHoc());
		});
		req.setAttribute("tatCaHocKy", diems);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("diem-thi.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
