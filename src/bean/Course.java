package bean;

public class Course  implements java.io.Serializable{

	private int courseId;
	private String courseName;

	public int getCourseId() {
		return courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
