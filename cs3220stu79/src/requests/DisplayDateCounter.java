package requests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DisplayDateCounter")
public class DisplayDateCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		ServletContext servletContext = getServletContext();

        // get the counter
        Integer counter = (Integer) servletContext.getAttribute( "counter" );
        
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
 		out.println("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
 		out.println("        <title>Display Date Counter</title>");
 		out.println("</head>");
 		out.println("<body>");
 		out.println("<div class=\"container\">");
 		
 		out.println("<p class=\"lead\">");
 		out.println("The date and time page has been viewed <strong>" + counter + "</strong> time(s).");
 		out.println("</p>");
 		
 		out.println("<a href=\"DateCounter\">View Current Date and Time</a>");
 		
 		out.println("</div>");
 		out.println("</body>");
 		out.println("</html>"); 
        
	}
   	
   	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
