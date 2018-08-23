package Labs;

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

@WebServlet("/Labs/Guestbook")
public class Guestbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Guestbook() {
        super();
    }
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//  pre-stored entries
		ArrayList<GuestbookEntry> entries = new ArrayList<GuestbookEntry>();
		
		entries.add( new GuestbookEntry("Tom cruse", "Hello, My team!"));
		entries.add( new GuestbookEntry("Taylor swift", "nice song"));
		entries.add( new GuestbookEntry("Barak Obama", "Hello World"));
		
		
		getServletContext().setAttribute("entries", entries);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Set the content type to HTML
		response.setContentType("text/html");
		//response.setContentType("application/vnd.ms-excel");
		//response.setHeader ("Content-disposition", "attachment;filename=Guestbook.xls");
        
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
		out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js\"></script>");out.println("        <title>GuestBook</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        
        // Add page-specific content here
        out.println("<h1>Guest Book<h1> ");
        
        // Get a reference to our servlet Context
        ServletContext context = getServletContext();
        
        // Get a reference to the list of guest book entries        
        ArrayList<GuestbookEntry> entries = (ArrayList<GuestbookEntry>) context.getAttribute("entries");
		
        
        //Display all entries in table 
        out.println("<table class=\"table table-bordered table-striped table-hover\">");
        
        //for each entry, we want to display a new row in our table
        for(GuestbookEntry entry : entries){
        	
        	out.println("<tr>");
        	out.println("<td>" + entry.getName() + "</td>");
        	out.println("<td>" + entry.getMessage() + "</td>");
        	out.println("<td>" + entry.getCreated() + "</td>");
        	out.println("</tr>");
        	
        
        }
        
        out.println("</table>");
        
        out.println("<a href=\"ExcelEntry\">Download Excel File</a>"); 
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
