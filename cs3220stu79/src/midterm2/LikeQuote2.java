package midterm2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/midterm2/Like2")
public class LikeQuote2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEntry getEntry(HttpServletRequest request) {
		ArrayList<AdminEntry> quotes = (ArrayList<AdminEntry>) getServletContext().getAttribute("quotes");
		int id = Integer.parseInt(request.getParameter("id"));

		// Locate the entry to remove it
		for (AdminEntry quote : quotes) {
			if (quote.getId() == id)
				return quote;
		}
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//get the specific entry and increment the like function
		AdminEntry entry = getEntry(request);
		entry.setLike();
		response.sendRedirect("InspireMe2");
	}
}
