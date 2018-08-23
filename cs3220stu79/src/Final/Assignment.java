package Final;

public class Assignment {

	private int id;
	private int courseId;
	private String assginmentDesc;
	private int flag = 0;

	public Assignment() {
	}

	public Assignment(int id, String assginmentDesc, int courseId, int flag) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.assginmentDesc = assginmentDesc;
		this.flag = flag;
	}

	public Assignment(String assginmentDesc, int courseId) {
		super();
		this.courseId = courseId;
		this.assginmentDesc = assginmentDesc;
	}

	public String getAssginmentDesc() {
		return assginmentDesc;
	}

	public void setAssginmentDesc(String assginmentDesc) {
		this.assginmentDesc = assginmentDesc;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlag() {
		return flag;

	}

}
