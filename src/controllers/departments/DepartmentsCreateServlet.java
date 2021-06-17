package controllers.departments;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Department;
import models.validators.DepartmentValidator;
import utils.DBUtil;

/**
 * Servlet implementation class DepartmentsCreateServlet
 */
@WebServlet("/departments/create")
public class DepartmentsCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentsCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String _token = request.getParameter("_token");

	        if(_token != null && _token.equals(request.getSession().getId())) {

	        	EntityManager em = DBUtil.createEntityManager();

	            Department d = new Department();

	            //リクエストスコープからパラメータを取得してDTOに代入
	            d.setDepartment_code(request.getParameter("department_code"));
	            d.setDepartment_name(request.getParameter("department_name"));



	            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

	            d.setCreated_at(currentTime);
	            d.setUpdated_at(currentTime);
	            d.setIs_deleted(0);

	            //データベースから取得したデータのエラーをチェック
	            List<String> errors = DepartmentValidator.validate(d, true);

	            if(errors.size() > 0) {
	                em.close();

	                request.setAttribute("_token", request.getSession().getId());
	                request.setAttribute("department", d);
	                request.setAttribute("errors", errors);

	                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/departments/new.jsp");
	                rd.forward(request, response);

	            } else {
	                em.getTransaction().begin();
	                em.persist(d);
	                em.getTransaction().commit();
	                request.getSession().setAttribute("flush", "登録が完了しました。");
	                em.close();

	                response.sendRedirect(request.getContextPath() + "/departments/index");
	            }
	        }
	}
}
