package selectall;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(urlPatterns = {"/selectall/connecttest3"})
public class Connecttest extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
		//Page.header(out);

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup(
					"java:/comp/env/jdbc/kouka2");
			Connection con = ds.getConnection();

			System.out.println("接続OK");
;
			con.close();

		} catch (Exception e) {
			System.out.println("接続NG");

		}

		//Page.footer(out);
	}
}
