package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntryMVC;


@WebServlet("/mvc/AddComment")
public class AddCommentController extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/mvc/AddComment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		boolean hasError =false;
		
		if(name==null || name.trim().length()==0){
			hasError = true;
			request.setAttribute("nameError", "Please enter your name");
		}
		if(message==null || message.trim().length()==0){
			hasError = true;
			request.setAttribute("messageError", "Please enter a message");
		}

		if(!hasError){
			
			@SuppressWarnings("unchecked")
			ArrayList<GuestBookEntryMVC> entries = (ArrayList<GuestBookEntryMVC>)getServletContext().getAttribute("entries");
			entries.add(new GuestBookEntryMVC(name, message));
			response.sendRedirect("GuestBook");
		}
		
		else{
			doGet(request, response);
		}
	}

}
