 package Homework3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework3/RemoveCustomer")
public class RemoveCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get a reference to array list entries
		ArrayList<Customer> entries = (ArrayList<Customer>) getServletContext().getAttribute("entries");

		// Get the id of the element removed
		int id = Integer.parseInt(request.getParameter("id"));

		// Locate the entry to remove it
		for (Customer entry : entries) {
			if (entry.getId() == id) {
				entries.remove(entry);
				break;
			}
		}
		// send (redirect) the user back to the main GuestBook page
		response.sendRedirect("Main");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
