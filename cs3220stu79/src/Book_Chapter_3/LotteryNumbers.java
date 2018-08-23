package Book_Chapter_3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LotteryNumbers")
public class LotteryNumbers extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private long modTime;
	private int[] numbers =new int[10];
	
	public void init() throws ServletException{
		//modTime= System.currentTimeMillis()/1000*1000;
		
		for (int i=0; i<numbers.length; i++){
			numbers[i] = randomNum();
		}
		
	}
	
	private int randomNum() {
		// TODO Auto-generated method stub
		return ((int)(Math.random()*100));
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
        out.println("        <title>Document</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<ol>");
        out.println("we have choosen " + numbers.length+ " lottery numbers for you");
        // Add page-specific content here
        for(int i=0; i<numbers.length; i++){
        out.println(" <li> " +numbers[i]);
        }        
        out.println("</ol>");
        
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
  	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
