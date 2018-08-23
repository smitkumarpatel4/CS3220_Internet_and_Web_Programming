package Labs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import models.GuestBookEntry;


@WebServlet("/Labs/RequestSummary")
public class RequestSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	 public void init(ServletConfig config) throws ServletException
    {
    	super.init(config);

    }
    	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Set the content type to HTML
        response.setContentType("text/html");
        
        // Get a Print Writer
        PrintWriter out = response.getWriter();
        
        // Generate the template HTML      
    	out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
		out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js\"></script>");
		out.println("<link rel=\"stylesheet\" href=\"/css/paper.bootstrap.min.css\">");
		out.println("<title> Request Summary</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class-\"container\">");
        
        // Add A page specific content here
        ServletContext context= getServletContext();
       //Request Parameter 
        
        
        Date created = new Date();
        
        out.println("<div class = \"jumbotron \" >");
        
        out.println("<h1>  <b>Request Parameters</b> <small> Lab2 </small></h1>");
        out.println("The following " +request.getMethod() + " request was submitted on " + created);
             
        out.println("</div>");
        
        out.println("<h3><b>Request Parameters</b></h3>");
        out.println("<table class=\"table table-bordered table-striped table-hover\">");
              
        out.println("<tr>");
    	out.println("	<th> Parameter Name </th>");
    	out.println("	<th> Param  eter Value </th>");
    	out.println("</tr>");
    
    	// get parameters name and their value
    	Enumeration<String> str = request.getParameterNames();	
    	 while (str.hasMoreElements()) {
    		 
    		 String name = (String)str.nextElement();
    		 
 			out.println("<tr>");
    		out.println("	<td>" +name + "</td>"); 
    		String[] values = request.getParameterValues(name);
    		
    		out.println("	<td>" );
    		
    		for(String value : values)
    		{
    			out.println("<label class=\"label label-info\">" + value + "</label>");
    		}
    				
    		out.println( "</td>");
    		out.println("</tr>");
    	}
        	
        out.println("</table>");

        // get a reference to servlet context for headerInformation entry
        //	ArrayList<HeaderInformationEntry> hi_entries = (ArrayList<HeaderInformationEntry>) context.getAttribute("hentries");
       	    	
        out.println("<h3><b>Header Parameters</b></h3>");       	
       
        out.println("<table class=\"table table-bordered table-striped table-hover\">");
         
        out.println("<tr>");
    	out.println("	<th> Header Feild </th>");
    	out.println("	<th> Header Value </th>");
    	out.println("</tr>");

    	Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
          String headerName = (String)headerNames.nextElement();
          out.println("<tr><td>" + headerName+ "</td>");
          out.println("<td>" + request.getHeader(headerName)+ "</td></tr>");
        }
    	     	
    	out.println("</table> ");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
  	
  	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
