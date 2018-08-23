package Midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Midterm/InspireMe")
public class InspireMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int lastrid = 0;

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

//	public AdminEntry getRanomQuote(HttpServletRequest request) {
//
//		// get a random number from our id
//		@SuppressWarnings("unchecked")
//		ArrayList<AdminEntry> quotes = (ArrayList<AdminEntry>) getServletContext().getAttribute("quotes");
//		int rid = (int) (Math.random() * quotes.size()) + 1;
//		for (AdminEntry quote : quotes) {
//
//			if (quote.getId() == rid)
//				return quote;
//		}
//		return null;
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext servletContext = getServletContext();
		HttpSession session = request.getSession();
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

		// ArrayList<AdminEntry> quotes = (ArrayList<AdminEntry>)
		// getServletContext().getAttribute("quotes");

		// get the random quote and display it

		// AdminEntry quote = getRanomQuote(request);
		ArrayList<AdminEntry> quotes = (ArrayList<AdminEntry>) getServletContext().getAttribute("quotes");
		Random random = new Random();
		AdminEntry quote = quotes.get(random.nextInt(quotes.size()));
		
		quote.setView();

		out.println("<div align=\"right\">");
		out.println("<a href=\"Admin\" class=\"btn btn-primary\"> Admin </a>");
		out.println("</div>");

		out.println("<h1>" + quote.getQuote() + "<h1>");

		out.println("<br>");
		out.println("<p class=\"lead text-right\">");

		out.println("-" + quote.getAuthor());

		out.println("<br>");

		out.println(" <div>");
		out.println("<a class=\"btn btn-primary\" href=\"LikeQuote?id=" + quote.getId() + "\">Like</a>");

		out.println("<a class=\"btn btn-primary\" href=\"Dislike?id=" + quote.getId() + "\">Dislike</a>");

		// out.println("<form action=\"Like\" method=\"post\">");
		// out.println("<input type=\"hidden\" name=\"id\" value=\"" +
		// quote.getId() + "\">");
		// out.println("<input class=\"btn btn-primary\" type=\"submit\"
		// name=\"Like\" value=\"Like\" />");
		// out.println(" </form>");
		//
		// out.println("<form action=\"Dislike\" method=\"post\">");
		// out.println("<input type=\"hidden\" name=\"id\" value=\"" +
		// quote.getId() + "\">");
		// out.println("<input class=\"btn btn-primary\" type=\"submit\"
		// name=\"Dislike\" value=\"Dislike\" />");
		// out.println(" </form>");

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
