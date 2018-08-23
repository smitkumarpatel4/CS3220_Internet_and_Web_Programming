package midterm2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/midterm2/Dislike2")
public class Dislike2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEntry getEntry(HttpServletRequest request) {
		ArrayList<AdminEntry> quotes = (ArrayList<AdminEntry>) getServletContext().getAttribute("quotes");
		int id = Integer.parseInt(request.getParameter("id"));
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
		// get the specific entry and increment like function 
		AdminEntry entry = getEntry(request);
		entry.setDislike();
		response.sendRedirect("InspireMe2");
	}

}
