package midterm2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/midterm2/DeleteQuote2")
public class DeleteQuote2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get a reference to array list entries
		ArrayList<AdminEntry> quotes = (ArrayList<AdminEntry>) getServletContext().getAttribute("quotes");

		// Get the id of the element removed
		int id = Integer.parseInt(request.getParameter("id"));

		// Locate the entry to remove it
		for (AdminEntry quote : quotes) {
			if (quote.getId() == id) {
				quotes.remove(quote);
				break;
			}
		}
		// send (redirect) the user back to the main GuestBook page
		response.sendRedirect("Admin2");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
