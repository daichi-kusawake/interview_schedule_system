package controllers.departments;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Department;

/**
 * Servlet implementation class DepartmentsNewServlet
 */
@WebServlet("/departments/new")
public class DepartmentsNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentsNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストスコープにデータをセット
		request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("department", new Department());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/departments/new.jsp");
        rd.forward(request, response);
	}

}
