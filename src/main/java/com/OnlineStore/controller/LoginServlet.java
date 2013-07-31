package com.OnlineStore.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName"); // userName=request.toString();
		String lastVisit = "", comment = "";
		if (userName == "") {
			userName = "Guest";
		}
		request.setAttribute("username", request.getParameter("userName"));
		Date d = new Date();
		Cookie[] c = request.getCookies();
		Cookie co;
		if (c == null || userName == "Guest") {
			co = new Cookie("LastVisit", d.toString());
			co.setComment(userName);
			co.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(co);
		} else {
			lastVisit = c[0].getValue();
			co = new Cookie("LastVisit", d.toString());
			co.setComment(userName);
			System.out.println(co.getComment());
			response.addCookie(co);
		}
		comment = co.getComment();
		PrintWriter out = response.getWriter();
		System.out.println(userName + " , " + comment);
		System.out.println(d + " , " + c[0].getValue());
		 {
			out.print("<html><head><title>Hellow Again!!!</title></head>");
			out.print("<body><H1>Online Store</h1><br><hr> Hi <b>"
					+ userName + "</b> nice 2 c u, how r u?");
			out.print("<br>");
			out.print("u'r last visit in our website was: ");
			out.print("<i>" + lastVisit + "</i>");
			out.print("<br>");
		}
		 if (request.getSession()!=null){
			 request.getSession().invalidate();
		 }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
