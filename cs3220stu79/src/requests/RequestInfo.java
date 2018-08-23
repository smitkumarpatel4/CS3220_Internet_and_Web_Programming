package requests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
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
				out.println("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
				out.println("        <title>Request Info</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<div class=\"container\">");
				
				out.println("<h1 class=\"display-4\">HTTP Requests <small class=\"text-muted\">Header Fields</small></h1>");
				
				out.println("<table class=\"table table-striped table-bordered table-hover\">");
				out.println("	<tr>");
				out.println("		<th>Field</th>");
				out.println("		<th>Value</th>");
				out.println("	</tr>");
				
				out.println("	<tr>");
				out.println("		<td>Method</td>");
				out.println("		<td>" + request.getMethod() + "</td>");
				out.println("	</tr>");
				
				out.println("	<tr>");
				out.println("		<td>URI</td>");
				out.println("		<td>" + request.getRequestURI() + "</td>");
				out.println("	</tr>");
				
				out.println("	<tr>");
				out.println("		<td>Context Path</td>");
				out.println("		<td>" + request.getContextPath() + "</td>");
				out.println("	</tr>");
				
				out.println("	<tr>");
				out.println("		<td>Remote Address</td>");
				out.println("		<td>" + request.getRemoteAddr() + "</td>");
				out.println("	</tr>");

				
		        out.println("	<tr>");
		    		out.println("		<td>gzip Supported?</td>");    		
		    		
		    		boolean isGzipSupported = request.getHeader( "Accept-Encoding" )
		    	            							.indexOf( "gzip" ) >= 0;
		    	            
		        if( isGzipSupported )
		        		out.println("	<td>yes, gzip is supported</td>");
		        else
		        		out.println("	<td>No, gzip is not supported</td>");
		        
		        out.println("	</tr>");
				
				
				out.println("</table>");
				
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
