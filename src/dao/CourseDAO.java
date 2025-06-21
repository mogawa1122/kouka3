package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Course;

public class CourseDAO extends DAO{

	// `Course`テーブルから全データをListに格納して返す関数
	public List<Course> selectAll() throws Exception {
		List<Course> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
			"select * from course");
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Course crs = new Course();
			crs.setCourseId(rs.getInt("course_id"));
			crs.setCourseName(rs.getString("course_name"));
			list.add(crs);
		}
		st.close();
		con.close();
		return list;
	}
}