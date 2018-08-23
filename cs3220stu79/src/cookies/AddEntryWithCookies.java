package cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/cookies/AddEntryWithCookies")
public class AddEntryWithCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	 private String getName( HttpServletRequest request )
	    {
	        Cookie[] cookies = request.getCookies();
	        if( cookies != null )
	            for( Cookie cookie : cookies )
	                if( cookie.getName().equals( "name" ) )
	                    return cookie.getValue();

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
        out.println("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
        out.println("        <title>Add Entry With Cookies</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        
        
        out.println("<Form action= \"AddEntryWithCookies\" method= \"post\">");
        
        String name= getName(request);
        
        if(name == null)
        	out.println("	<input type=\"text\" name=\"name\" placeholder= \"Enter your name\">");
        else{
        	out.println("<Strong>"+ name +"</strong>");
        	//Insert a hidden form input
        }

        
        out.println("	<br>");       
        out.println("	<textarea name=\"message\"></textarea>");
        out.println("	<br>");
        out.println(" 	<input type=\"submit\" name='add'  value='Add'>");
        out.println("</form>");
        
     
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Let's try to read the name from cookies first
		String name= getName(request);
		
		//get the user's name
		name = request.getParameter("name");
		
		if (name== null)
				name=request.getParameter("name");
		//get the user's message 
		String message =request.getParameter("message");
		
		//Assume we have no errors in the user's submission
		boolean hasError =false;
		
		//prove that there are errors
		if (name == null|| name.trim().length() == 0 || message == null|| message.trim().length() == 0){
			doGet(request,response);
		}
	
		else{
		//get arefrence to the entries collection in the servlet context
		ArrayList<GuestBookEntry> entries= (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		// add a new entry to guest book
		entries.add(new GuestBookEntry(name,message));
		
		//Create a cookie
		Cookie cookie =new Cookie("name",name);
		
		//add the cookie to the response
		response.addCookie(cookie);
			
		//redirect the user back to the main guestbook page
		response.sendRedirect("../requests/GuestBook");
		}
	}

}
 