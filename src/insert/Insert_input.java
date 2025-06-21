package insert;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import dao.CourseDAO;

@WebServlet(urlPatterns={"/insertinput3"})
public class Insert_input extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		try {

			// 変数 list に`Course`テーブルの全データを格納
			CourseDAO dao = new CourseDAO();
			List<Course> list = dao.selectAll();

			// 得られた list をリクエストに渡す
			request.setAttribute("list", list);

			// リクエストを insertinput.jsp にフォワードする
			request.getRequestDispatcher("/insert/insertinput.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace(out);

		}
	}
}
