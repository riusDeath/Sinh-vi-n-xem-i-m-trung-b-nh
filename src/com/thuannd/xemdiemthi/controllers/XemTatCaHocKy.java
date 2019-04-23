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
import com.thuannd.xemdiemthi.entities.KyHocWrapper;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(session.getAttribute("current_id").toString());
		List<KyHocWrapper> kyHocWrappers= userDAO.getAllSemester(new SinhVien(id));
		System.out.println("\n ----XEM TAT CA HOC KY----: ");
		kyHocWrappers.forEach(wrapper ->{
			System.out.println("ky hoc: " + wrapper.getKyHoc());
			wrapper.getDiems().forEach(d ->{
				System.out.println( "diem cuoi ky he chu: " + d.getDiemTK());
			});
		});
		request.setAttribute("tatCaHocKy", kyHocWrappers);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("tat-ca-hoc-ky.jsp");
		requestDispatcher.forward(request, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            	
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
