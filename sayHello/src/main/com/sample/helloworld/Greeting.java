package com.sample.helloworld;

import java.io.IOException;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sap.security.auth.login.LoginContextFactory;

/**
 * Servlet implementation class Greeting
 */
@WebServlet("/greeting")
public class Greeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Greeting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getRemoteUser();
	    if (user != null)
	    {
	        response.getWriter().println("Hello, " + user);
	    }
	    else
	    {
	        LoginContext loginContext;
		    try
	        {
	             loginContext = LoginContextFactory.createLoginContext("FORM");
			 		loginContext.login();
	             response.getWriter().println("Hello, " +  request.getRemoteUser());
	        }
	        catch (LoginException ex)
	        {
	             ex.printStackTrace();
		    
	        }
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
