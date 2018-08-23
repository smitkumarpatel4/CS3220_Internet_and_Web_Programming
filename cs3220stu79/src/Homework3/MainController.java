package Homework3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework3/Main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	
		ArrayList<Customer> entries = new ArrayList<Customer>();
		entries.add(new Customer("john", "Mac Book" , "john@mail.co", "9879368091"));
		entries.add(new Customer("joe", "Note Book", "joe@mail.com", "6264641866"));
		entries.add(new Customer("Mary", "Surface", "Mary@mil.com","9687641359 "));
		getServletContext().setAttribute("entries", entries);

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get a reference to a request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Homework3/Main.jsp");

		// forward the the request and response objects to the guestBook.jsp page
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
