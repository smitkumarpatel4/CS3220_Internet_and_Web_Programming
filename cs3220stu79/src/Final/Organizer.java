package Final;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Final/Organizer")
public class Organizer extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Course> courselist = new ArrayList<>();
		ArrayList<Assignment> assignlist = new ArrayList<>();
		ConnectionDatabase db = null;
		try {
			db = new ConnectionDatabase();
			ResultSet rs = db.getCourses();
			while(rs.next()) {
				Course c = new Course(rs.getInt(1),rs.getString(2),rs.getString(3));
				courselist.add(c);
			}
			
			rs = db.getAssignments();
			while(rs.next()) {
				Assignment a = new Assignment(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				assignlist.add(a);
			}
			
			if(!courselist.isEmpty()) {
				request.setAttribute("courses", courselist);
			}
			if(!assignlist.isEmpty()) {
				request.setAttribute("assignments", assignlist);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/Final/Organizer.jsp");
		dispatch.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

