package com.thuannd.xemdiemthi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/xem-diem-thi"})
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		if (session.getAttribute("current_user") != null) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpResp = (HttpServletResponse) response;
			httpResp.sendRedirect("/xemdiemthi/dang-nhap");
		}
		response.setCharacterEncoding("UTF-8");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	
	
}
