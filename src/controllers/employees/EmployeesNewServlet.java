package controllers.employees;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Department;
import models.Employee;
import utils.DBUtil;

/**
 * Servlet implementation class EmployeesNewServlet
 */
@WebServlet("/employees/new")
public class EmployeesNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setAttribute("_token", request.getSession().getId());
	     request.setAttribute("employee", new Employee());


	     // 部署名一覧表示のため部署情報テーブルのデータを取得する
	     EntityManager em = DBUtil.createEntityManager();
	    List<Department> departments = em.createNamedQuery("getAllDepartmentsNotDeleted", Department.class).getResultList();
	        em.close();

	        request.setAttribute("departments", departments);
	     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employees/new.jsp");
	     rd.forward(request, response);
	}

}
