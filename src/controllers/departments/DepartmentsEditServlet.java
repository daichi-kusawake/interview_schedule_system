package controllers.departments;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Department;
import utils.DBUtil;

/**
 * Servlet implementation class DepartmentsEditServlet
 */
@WebServlet("/departments/edit")
public class DepartmentsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentsEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//データベースにアクセスするためのオブジェクトを生成
		EntityManager em = DBUtil.createEntityManager();

        Department d = em.find(Department.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("department", d);

        request.setAttribute("_token", request.getSession().getId());

        request.getSession().setAttribute("department_id", d.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/departments/edit.jsp");
        rd.forward(request, response);
	}
}
