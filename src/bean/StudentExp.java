package bean;

import java.io.Serializable;

public class StudentExp extends Student implements Serializable {

	private String courseName;
	private boolean checkFlg = false;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public boolean isCheck() {
		return checkFlg;
	}

	public void setCheck() {
		this.checkFlg = true;
	}

}
