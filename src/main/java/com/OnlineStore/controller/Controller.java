package com.OnlineStore.controller;
import helpers.ShoppingCart;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.StoreItems;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String supportMail; // holds the email predefined in web.xml
	private int hitCounter; // count 'BUY' operations
	private StoreItems store; // holds item list for sale

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void init(ServletConfig config) throws ServletException {
		store = new StoreItems();
		supportMail = config.getInitParameter("email");
		System.out.println(supportMail);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command=request.getParameter("command");
		if (command.equals("startShopping")){
			HttpSession sess=request.getSession(true);
			if (sess.isNew()){
				ShoppingCart sc1=new ShoppingCart();
				sess.setAttribute("cart", sc1);
			}
		}
		else if (command.equals("clear")){
			HttpSession sess = request.getSession();
			ShoppingCart sc = (ShoppingCart) sess.getAttribute("cart");
			sc.clear();
		}
	
	}
}
