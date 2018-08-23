package responses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responses/Countdown")
public class Countdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	int count=5;
	
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
        out.println("        <title>Countdown</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        
        // Add page-specific content here
        if(count>0){
        	out.println("<h1 class=\"display-4\">T-minus " + count +"</h1> ");
        	count--;
        	response.setIntHeader("Refresh", 1);
        }
        
        else
        {
        	out.println("<h1 class=\"display-1\"> Blast off! </h1> ");
        	count = 5;
        }
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
