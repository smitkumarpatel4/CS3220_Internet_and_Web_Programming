package databases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/database/AddComment")
public class DbAddCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/mvc/AddComment.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read the request data(name and message)
		String name = request.getParameter("name");
		String message = request.getParameter("message");

		// validate the submission
		boolean hasError = false;

		if (name == null || name.trim().length() == 0) {
			hasError = true;
			request.setAttribute("nameError", "you must specify a name!");
		}

		if (message == null || message.trim().length() == 0) {
			hasError = true;
			request.setAttribute("messageError", "you must write a message !");
		}

		// if not valid, create some error message and call doget
		if (hasError)
			doGet(request, response);

		else {
			// if valid, create a new entry in data base

			// connect the database

			// Insert the record

			// close that connection

			// redirect to main guest bookpage
			Connection c = null; // define here for scope
			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu79";
				String username = "cs3220stu79";
				String password = "DwHAs9GA";

				// Create a connection
				c = DriverManager.getConnection(url, username, password);

				// Create a new statement and execute it
				Statement stmt = c.createStatement();
				String sql = "INSERT INTO guestbook(name,message) VALUES (\"" + name + "\",\"" + message + "\")";
				
				System.out.println("sql = " + sql);
				stmt.executeUpdate(sql);
				

			} catch (SQLException e) {
				throw new ServletException(e);
			} finally {
				try {
					if (c != null)
						c.close();
				} catch (SQLException e) {
					throw new ServletException(e);
				}
			}
			
			response.sendRedirect("GuestBook");
		}

	}
}
