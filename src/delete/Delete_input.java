package delete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns={"/deleteinput3"})
public class Delete_input extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		try {

			// 変数 list に`Student`テーブルの全データを格納
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.selectAll();

			// 得られた list をリクエストに渡す
			request.setAttribute("list", list);

			// リクエストを updateinput.jsp にフォワードする
			request.getRequestDispatcher("/delete/deleteinput.jsp").forward(request, response);


		} catch (Exception e) {

			e.printStackTrace(out);

		}
	}
}
