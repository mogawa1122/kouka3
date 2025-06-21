package insert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns={"/insert3"})
public class Insert_disp extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		PrintWriter out=response.getWriter();

		try {

			// フォームで入力したデータをそれぞれ変数に格納する
			int stuId = Integer.parseInt(request.getParameter("stuId"));
			String stuName = request.getParameter("stuName");
			int crsId = Integer.parseInt(request.getParameter("crsId"));

			// 上記データを生徒情報として Student型変数 stu に格納する
			Student stu = new Student();
			stu.setStudentId(stuId);
			stu.setStudentName(stuName);
			stu.setCourseId(crsId);

			// stu を引数として insertStudent 関数を呼び出し、
			// `Student`テーブルにデータの追加を試みる
			StudentDAO dao = new StudentDAO();
			int line = dao.insertStudent(stu);

			if (line > 0 /* 追加に成功した場合、リクエストに成功した旨のメッセージを格納 */) {
				request.setAttribute("message", "登録が完了しました");
			} else /* 追加に失敗した場合も、失敗した旨のメッセージを格納 */ {
				request.setAttribute("message", "登録に失敗しました。");
			}

			// リクエストを insert.jsp にフォワードする
			request.getRequestDispatcher("/insert/insert.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace(out);

		}
	}
}
