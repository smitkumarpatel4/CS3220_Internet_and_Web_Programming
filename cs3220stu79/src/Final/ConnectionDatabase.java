package Final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class ConnectionDatabase {

	private Connection connect = null;
	private PreparedStatement preparedStatement = null;

	public ConnectionDatabase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://cs3.calstatela.edu:3306/cs3220stu79", "cs3220stu79",
					"DwHAs9GA");

			connect.createStatement();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	public int addCourse(Course c) throws SQLException {
		int result = 0;
		preparedStatement = null;
		String query = "insert into course(coursenumber,coursename) values(?,?)";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.setString(1, c.getCourseNumber());
		preparedStatement.setString(2, c.getCourseName());
		result = preparedStatement.executeUpdate();
		return result;
	}

	public int addAssignment(Assignment assign) throws SQLException {
		int result = 0;
		preparedStatement = null;
		String query = "insert into assignment(description,courseid)  values(?,?)";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.setString(1, assign.getAssginmentDesc());
		preparedStatement.setInt(2, assign.getCourseId());
		result = preparedStatement.executeUpdate();
		return result;
	}

	public int deleteCourse(int courseId) throws SQLException {
		int result = 0;
		preparedStatement = null;
		String query = "delete from course where id=?";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.setInt(1, courseId);
		result = preparedStatement.executeUpdate();
		return result;
	}

	public int deleteAssignment(int assignmentId) throws SQLException {
		int result = 0;
		preparedStatement = null;
		String query = "delete from assignment where id=?";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.setInt(1, assignmentId);
		result = preparedStatement.executeUpdate();
		return result;
	}

	public int updateAssignment(int assignmentId, int flag) throws SQLException {
		int result = 0;
		preparedStatement = null;
		String query = "update assignment set flag=? where id=?";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.setInt(1, flag);
		preparedStatement.setInt(2, assignmentId);
		result = preparedStatement.executeUpdate();
		return result;
	}

	public int archiveAssignment() throws SQLException {
		int result = 0;
		preparedStatement = null;
		String query = "delete from assignment where flag = 1";
		preparedStatement = connect.prepareStatement(query);
		result = preparedStatement.executeUpdate();
		return result;
	}

	public ResultSet getCourses() throws SQLException {
		ResultSet result = null;
		preparedStatement = null;
		String query = "select * from course";
		preparedStatement = connect.prepareStatement(query);
		result = preparedStatement.executeQuery();
		return result;
	}

	public ResultSet getAssignments() throws SQLException {
		ResultSet result = null;
		preparedStatement = null;
		String query = "select * from assignment";
		preparedStatement = connect.prepareStatement(query);
		result = preparedStatement.executeQuery();
		return result;
	}

	public void closeConnection() throws SQLException {
		connect.close();
	}

}
