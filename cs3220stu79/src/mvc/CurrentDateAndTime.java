package mvc;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CurrentDateAndTime")
public class CurrentDateAndTime extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//get the current date and time
		Date dateTimeStamp = new Date();
		
		// add the time stamp object to request scope
		request.setAttribute("currentDateAndTime", dateTimeStamp);
		
		//get a dispatcher
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/mvc/CurrentDateAndTime.jsp");
		
		//forward request and response object to the view
		dispatcher.forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
