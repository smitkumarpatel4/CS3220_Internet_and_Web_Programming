package Final;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Final/addassignment")
public class AddAssignmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("selectedCourse"));
		String assignmentDesc = request.getParameter("assignmentDesc");

		Assignment assign = new Assignment(assignmentDesc, courseId);
		ConnectionDatabase db = null;
		try {
			db = new ConnectionDatabase();
			db.addAssignment(assign);
			RequestDispatcher dispatch = request.getRequestDispatcher("Organizer");
			dispatch.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
	}

}
