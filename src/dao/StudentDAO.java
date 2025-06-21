package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.StudentExp;

public class StudentDAO extends DAO {

	// `Student`テーブルから全データをListに格納して返す関数
	public List<Student> selectAll() throws Exception {

		List<Student> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
			"select * from student");
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Student stu = new Student();
			stu.setStudentId(rs.getInt("student_id"));
			stu.setStudentName(rs.getString("student_name"));
			stu.setCourseId(rs.getInt("course_id"));
			list.add(stu);
		}

		st.close();
		con.close();

		return list;
	}

	/* `Student`テーブルから全データをListに格納して返す関数
	 ※ただし、コース番号ではなくコース名で取り出す */
	public List<StudentExp> selectAllWithCourseName() throws Exception {

		List<StudentExp> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from student "
					+ "join course on student.course_id = course.course_id");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			StudentExp swc=new StudentExp();
			swc.setStudentId(rs.getInt("student_id"));
			swc.setStudentName(rs.getString("student_name"));
			swc.setCourseName(rs.getString("course_name"));
			list.add(swc);
		}

		st.close();
		con.close();

		return list;
	}

	/* 引数に指定した学生情報(学生番号・学生名・コース番号)を
	 `Student`テーブルに追加する関数
	 ※追加に成功した場合は整数型で1を、そうでない場合は0を返す。*/
	public int insertStudent(Student stu) throws Exception{

		Connection con = getConnection();

		PreparedStatement st=con.prepareStatement(
				"select * from student "
						+ "join course on student.course_id = course.course_id");
		ResultSet rs=st.executeQuery();

		//学生番号+1
		PreparedStatement st1 = con.prepareStatement(
			"select max(student_id) as maxID from student");
		rs = st1.executeQuery();
		rs.next();
		int maxID = rs.getInt("maxID");

		//学生テーブルに追加
		st = con.prepareStatement(
			"insert into student values(?,?,?)");
		st.setInt(1, maxID+1);
		st.setString(2, stu.getStudentName());
		st.setInt(3, stu.getCourseId());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	public Student deleteStudent(int stuId) throws Exception{

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from student where student_id = ?");
		st.setInt(1, stuId);
		ResultSet rs = st.executeQuery();

		Student stu = new Student();
		rs.next();
		stu.setStudentId(rs.getInt("student_id"));
		stu.setStudentName(rs.getString("student_name"));
		stu.setCourseId(rs.getInt("course_id"));

		//学生テーブルから削除
		PreparedStatement st1 = con.prepareStatement(
			"delete from student where studen_id = ?");
		st1.setInt(1, stuId);
		st1.executeQuery();

		st.close();
		con.close();

		return stu;
	}


}
