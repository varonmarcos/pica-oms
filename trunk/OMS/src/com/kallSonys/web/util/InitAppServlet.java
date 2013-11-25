package com.kallSonys.web.util;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kallSonys.business.cron.IScheduler;

/**
 * Servlet implementation class initCronOrders
 */
public class InitAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		
	@EJB (mappedName="cronBean")
	IScheduler cronbean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitAppServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException
	{
		
		System.out.println("Inicia llamado al cron desde el servelt: "+new Date());
		cronbean.startUpTimer();
		System.out.println("llamado al cron desde el servelt finalizado: "+new Date());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
