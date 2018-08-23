package Labs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Labs/ExcelEntry")
public class ExcelEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set the content type to excel
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader ("Content-disposition", "attachment;filename=Guestbook.xls");
        
        // Get a Print Writer
        PrintWriter out = response.getWriter();
        
        ServletContext context = getServletContext();
        
        ArrayList<GuestbookEntry> entries = (ArrayList<GuestbookEntry>) context.getAttribute("entries");
        
        out.println("Name \t Message \t date");
           
      
        for(GuestbookEntry entry : entries){
        	
        	out.println(entry.getName() + "\t" + entry.getMessage() + "\t" + entry.getCreated());

        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
