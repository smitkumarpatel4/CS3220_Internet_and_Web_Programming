package Final;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Final/deletecourse")
public class DeleteCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		ConnectionDatabase db = null;
		try {
			db = new ConnectionDatabase();
			db.deleteCourse(courseId);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
	}

}