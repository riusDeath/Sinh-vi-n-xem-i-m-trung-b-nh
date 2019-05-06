package com.thuannd.test.controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thuannd.xemdiemthi.controllers.HomeController;

public class TestHomeController extends HomeController{
	
	public static String path = "/WEB-INF/index.jsp";
	
	@Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
 
    @BeforeClass
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void testDoGet() throws Exception {
		HomeController controller = new HomeController();
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher("/mock/ABCTEST")).thenReturn(dispatcher);
	    verify(dispatcher).forward(request, response);
    }
	
	@Test
	public void testDoPost() {
		HomeController homeController = new HomeController();
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("current_user")).thenReturn("nguyễn đức thuận");
		
		//homeController.doPost(request, response);
		
	}
	
}
