package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntryMVC;

@WebServlet("/mvc/EditComment")
public class EditCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected GuestBookEntryMVC getEntry(int id) {
		// find the message that matches the id
		ArrayList<GuestBookEntryMVC> entries = (ArrayList<GuestBookEntryMVC>) getServletContext().getAttribute("entries");
		for (GuestBookEntryMVC entry : entries) {
			if (entry.getId() == id) {
				return entry;
			}
		}
		return null;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// parse an integer out of the 'id' parameter
			int id = Integer.parseInt(request.getParameter("id"));

			GuestBookEntryMVC entryToEdit = getEntry(id);

			if (entryToEdit != null) {
				// If we find a match, lets attach the message to the 'request'
				// object
				// forward the object to a view for display
				request.setAttribute("entry", entryToEdit);
				request.getRequestDispatcher("/WEB-INF/mvc/EditComment.jsp").forward(request, response);
				// return;
			}

		} catch (Exception e) {
			// If we dont find a match, or we have a parse error , let's
			// redirect back to Guestbook
			response.sendRedirect("GuestBook");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));

			GuestBookEntryMVC entry = getEntry(id);

			String name = request.getParameter("name");
			String message = request.getParameter("message");

		
		}

		catch (Exception e) {

		} finally {
			response.sendRedirect("GuestBook");
		}

		//doGet(request, response);
	}

}
