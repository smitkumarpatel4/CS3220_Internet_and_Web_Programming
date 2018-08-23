package midterm2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/midterm2/InspireMe2")
public class InspireMe2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int lastrid = 0;

	public AdminEntry getRanomQuote(HttpServletRequest request) {

		// get a random number from our id
		@SuppressWarnings("unchecked")
		ArrayList<AdminEntry> quotes = (ArrayList<AdminEntry>) getServletContext().getAttribute("quotes");
		int rid = (int) (Math.random() * quotes.size()) + 1;
		for (AdminEntry quote : quotes) {

			if (quote.getId() == rid)
				return quote;
		}
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext servletContext = getServletContext();

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
				"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println("        <title>Inspire me</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		// get the random quote and display it

		AdminEntry quote = getRanomQuote(request);

		if (quote == null)
			response.sendRedirect("InspirMe");

		// get the view and place it in table for particular entry
		getServletContext().setAttribute("counter", quote.getView());
		Integer counter = (Integer) servletContext.getAttribute("counter");
		++counter;

		servletContext.setAttribute("counter", counter);

		quote.setView((int) servletContext.getAttribute("counter"));

		out.println("<div align=\"right\">");
		out.println("<a href=\"Admin2\" class=\"btn btn-primary\"> Admin </a>");
		out.println("</div>");

		out.println("<h1>" + quote.getQuote() + "<h1>");
		
		out.println("<br>");
		out.println("<p class=\"lead text-right\">");

		out.println("-" + quote.getAuthor());

		out.println("<br>");

		// generate form for like and dislike
		out.println(" <div>");

		out.println("<form action=\"Like2\" method=\"post\">");
		out.println("<input type=\"hidden\" name=\"id\" value=\"" + quote.getId() + "\">");
		out.println("<input class=\"btn btn-primary\" type=\"submit\" name=\"Like\" value=\"Like\" />");
		out.println(" </form>");

		out.println("<form action=\"Dislike2\" method=\"post\">");
		out.println("<input type=\"hidden\" name=\"id\" value=\"" + quote.getId() + "\">");
		out.println("<input class=\"btn btn-primary\" type=\"submit\" name=\"Dislike\" value=\"Dislike\" />");
		out.println(" </form>");

		out.println("</div>");

		out.println("</p>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
