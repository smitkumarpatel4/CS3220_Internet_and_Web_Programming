package Midterm;

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

import solutions.notes.Note;
import solutions.notes.NoteUser;

@WebServlet("/Midterm/LikeQuote")
public class LikeQuote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		// get the specific entry and increment the like function
		ArrayList<AdminEntry> quotes = (ArrayList<AdminEntry>) getServletContext().getAttribute("quotes");
		int id = Integer.parseInt(request.getParameter("id"));
		

			for (AdminEntry quote : quotes) {
				if (quote.getId() == id) {
					quote.setLike();
					break;
				}
			}
		} catch (Exception e) {

		}

		finally {
			response.sendRedirect("InspireMe");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
