package Homework3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework3/Search")
public class SearchCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected Customer getEntry(HttpServletRequest request) {

		String name = request.getParameter("search");

		ArrayList<Customer> entries = (ArrayList<Customer>) getServletContext().getAttribute("entries");

		for (Customer entry : entries)
			if (entry.getName().equalsIgnoreCase(name))
				return entry;
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set the content type to HTML
		response.setContentType("text/html");

		// Get a Print Writer
		PrintWriter out = response.getWriter();

		// Generate the template HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		out.println("        <title>Search Customer</title>");
		out.println("</head>");
		out.println("<body>");

		Customer entry = getEntry(request);

		if (entry == null) {
			out.println("<h1> No Customer <h1>");
		}

		else {
			out.println("<div>");
			// Display all entries in table
			out.println("<table border=\"1\" >");
			// for each entry, we want to display a new row in our table
			out.println("<tr>");
			out.println("<td>" + entry.getName() + "</td>");
			out.println("<td>" + entry.getPurchase_item() + "</td>");
			out.println("<td>" + entry.getEmail_id() + "</td>");
			out.println("<td>" + entry.phone_number + "</td>");
			out.println("</tr>");

			out.println("</table>");
			out.println("</div>");
		}
		out.println("<a href=\"Main\"> BACK </a>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
