package delete;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/delete3"})
public class Delete_disp extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		try {

			// 選択した学生番号を変数に格納する

		} catch (Exception e) {

			e.printStackTrace(out);

		}
	}
}
