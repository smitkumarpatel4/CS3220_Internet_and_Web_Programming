package midterm2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/midterm2/Admin2")
public class Admin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// pre-populate the Guest Book with some entries
		ArrayList<AdminEntry> quotes = new ArrayList<AdminEntry>();
		quotes.add(new AdminEntry("Life is GAME, Do not play it", "Smit"));
		quotes.add(new AdminEntry("CS3220, Do not code it, just apply your Creativity ", "Bhumin"));
		quotes.add(new AdminEntry("Life is GAME, put your efforts to win it", "Raxa"));
		quotes.add(new AdminEntry("CS3220, Do not code it, Just apply your Logic ", "Khp"));
		getServletContext().setAttribute("quotes", quotes);
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
		out.println(
				"<link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
		out.println(
				"<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js\"></script>");
		out.println("        <title>Admin</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		// Add page-specific content here
		out.println("<h1>Admin<h1> ");

		// Get a reference to our servlet Context
		ServletContext context = getServletContext();

		// Get a reference to the list of guest book entries
		@SuppressWarnings("unchecked")
		ArrayList<AdminEntry> quotes = (ArrayList<AdminEntry>) context.getAttribute("quotes");

		out.println("<div align=\"right\">");
		out.println("<a href=\"InspireMe2\" class=\"btn btn-primary\"> Inspire Me </a>");
		out.println("</div>");

		// generate a form for the add new quote

		out.println(
				"<Form action= \"Admin2\" method= \"post\" class=\"form-inline\" class=\"navbar class=\"navbar-brand\">");
		out.println("	<input type=\"text\" name=\"quote\" placeholder=\"Enter new quote\">");
		out.println("	<input type=\"text\" name=\"author\" placeholder=\"Enter your name\">");
		out.println(" 	<input type=\"submit\" value=\"Add Quote\">");
		out.println("</form>");
		out.println("<br>");

		// Display all entries in table
		out.println("<table class=\"table table-bordered table-striped table-hover\">");

		out.println("<tr><th></th><th>Quote</th><th>Author</th><th>Viewed</th><th>Liked</th><th>Disliked</th></tr>");
		// for each entry, we want to display a new row in our table
		for (AdminEntry quote : quotes) {
			out.println("<tr>");

			// out.println("<td>" + quote.getId() + "</td>");
			out.println("<td>");
			out.println(" <a href=\"DeleteQuote2?id=" + quote.getId() + "\" class=\"btn btn-primary\"> Delete </a>");
			out.println("</td>");
			out.println("<td>" + quote.getQuote() + "</td>");
			out.println("<td>" + quote.getAuthor() + "</td>");
			out.println("<td>" + quote.getView() + "</td>");
			out.println("<td>" + quote.getLike() + "</td>");
			out.println("<td>" + quote.getDislike() + "</td>");

			out.println("</tr>");

		}

		out.println("</table>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		// add new quote
		String quote = request.getParameter("quote");

		String author = request.getParameter("author");

		@SuppressWarnings("unchecked")
		ArrayList<AdminEntry> quotes = (ArrayList<AdminEntry>) getServletContext().getAttribute("quotes");
		quotes.add(new AdminEntry(quote, author));
		response.sendRedirect("Admin2");
	}

}
