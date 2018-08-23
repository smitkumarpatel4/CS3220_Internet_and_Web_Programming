package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.GuestBookEntryMVC;

@WebServlet("/mvc/GuestBook")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GuestBookController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ArrayList<GuestBookEntryMVC> entries = new ArrayList<GuestBookEntryMVC>();
		entries.add(new GuestBookEntryMVC(1, "john", "hello"));
		entries.add(new GuestBookEntryMVC(2, "joe", "howdy"));
		entries.add(new GuestBookEntryMVC(3, "Mary", "hi"));

		getServletContext().setAttribute("entries", entries);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get a reference to a request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mvc/GuestBook.jsp");

		// forward the the request and response objects to the guestBook.jsp
		// page
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
