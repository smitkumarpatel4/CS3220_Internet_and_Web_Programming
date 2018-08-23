package Final;

import java.util.ArrayList;

public class Course {
	private int id;
	private String courseNumber;
	private String courseName;
	private ArrayList<Assignment> assignments;

	public Course() {

	}

	public Course(int id, String courseNumber, String courseName) {
		super();
		this.id = id;
		this.courseNumber = courseNumber;
		this.courseName = courseName;
	}

	public Course(String courseNumber, String courseName) {
		super();
		this.courseNumber = courseNumber;
		this.courseName = courseName;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
