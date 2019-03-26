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
		
		List<Diem> diems = userDAO.getResultPoint(new SinhVien(id), kyHoc);
		request.setAttribute("results", diems);

		RequestDispatcher dispatcher = request.getRequestDispatcher("diem-thi.jsp");
		dispatcher.forward(request, response);
	}

}
