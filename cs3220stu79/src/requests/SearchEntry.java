package requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/requests/SearchEntry")
public class SearchEntry extends HttpServlet {
	
	protected GuestBookEntry getEntry(HttpServletRequest request){
		//Get the id of the entry we are editing
		String name = request.getParameter("search");
		
		//Get a reference to the array list of entries
		ArrayList<GuestBookEntry> entries =(ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		//Find the entry
		for (GuestBookEntry entry: entries)
			if(entry.getName().equalsIgnoreCase(name))
				return entry;			
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        out.println("<link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
		out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js\"></script>");
		out.println("        <title>Search Entry</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        
        // Add page-specific content here
        out.println("<h1>Guest Book<h1> ");
        
       
        // search button for search entry
        out.println("<form action=\"/SearchEntry\">");
        out.println("<input type=\"text\" placeholder=\"Search..\" name=\"search\">" );
        out.println("<button type=\"submit\"><i class=\"fa fa-search\"></i></button>");
        out.println("</form>");
       
        //Display all entries in table 
        out.println("<table class=\"table table-bordered table-striped table-hover\">");
        
        GuestBookEntry entry =getEntry(request);
        
        //for each entry, we want to display a new row in our table
       
        	out.println("<tr>");
        	out.println("<td>" + entry.getName() + "</td>");
        	out.println("<td>" + entry.getMessage() + "</td>");
        	out.println("<td>" + entry.getCreated() + "</td>");
        	out.println("<td>" );
        	out.println(" <a class=\"btn btn-primary\" href=\"EditEntry?id="+ entry.getId() +"\"> Edit </a>");
        	out.println(" <a class=\"btn btn-primary\" href=\"DeleteEntry?id="+ entry.getId() +"\"> Delete </a>");
        	out.println("</td>");
        	
        	out.println("</tr>");
        	
        
       
        
        out.println("</table>");
        out.println("<a class=\"btn btn-primary\" href=\"AddEntry\">Add Entry</a>"); 
       // out.println("<br>" );
        out.println("<a class=\"btn btn-primary\" href=\"GuestBookEntryInExcel\">Download Excel File</a>"); 
       // out.println("<br>" );
        out.println("<a class=\"btn btn-primary\" href=\"../cookies/AddEntryWithCookies\">Add Entry With Cookies</a> ");
       // out.println("<br>" );
        out.println("<a class=\"btn btn-primary\" href=\"../sessions/AddEntryWithSessions\">Add Entry with Sessions</a>");
        
       
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
