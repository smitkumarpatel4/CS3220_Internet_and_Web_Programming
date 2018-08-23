package Homework3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework3/EditCustomer")
public class EditCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected Customer getEntry(int id) {
		// find the message that matches the id
		@SuppressWarnings("unchecked")
		ArrayList<Customer> entries = (ArrayList<Customer>) getServletContext().getAttribute("entries");
		for (Customer entry : entries) {
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

			Customer entryToEdit = getEntry(id);

			if (entryToEdit != null) {
				// If we find a match, lets attach the message to the
				// 'request'object
				// forward the object to a view for display
				request.setAttribute("entry", entryToEdit);
				request.getRequestDispatcher("/WEB-INF/Homework3/EditCustomer.jsp").forward(request, response);
				// return;
			}

		} catch (Exception e) {
			// If we dont find a match, or we have a parse error , let's
			// redirect back to Main
			response.sendRedirect("Main");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));

			Customer entry = getEntry(id);

			String name = request.getParameter("name");
			String purchase_item = request.getParameter("purchase_item");
			String email_id = request.getParameter("email_id");
			String phone_number = request.getParameter("phone_number");


			entry.setName(name);
			entry.setPurchase_item(purchase_item);
			entry.setEmail_id(email_id);
			entry.setPhone_number(phone_number);
		}

		catch (Exception e) {
		} finally {
			response.sendRedirect("Main");
		}
	}
}
