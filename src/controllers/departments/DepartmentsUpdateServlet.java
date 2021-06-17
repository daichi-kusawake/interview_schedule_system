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
 * Servlet implementation class DepartmentsUpdateServlet
 */
@WebServlet("/departments/update")
public class DepartmentsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentsUpdateServlet() {
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

            Department d = em.find(Department.class, (Integer)(request.getSession().getAttribute("department_id")));

            // 現在の値と異なる部署コードが入力されていたら
            // 重複チェックを行う指定をする
            Boolean codeDuplicateCheckFlag = true;
            if(d.getDepartment_code().equals(request.getParameter("department_code"))) {
                codeDuplicateCheckFlag = false;
            } else {
                d.setDepartment_code(request.getParameter("department_code"));
            }

            d.setDepartment_name(request.getParameter("department_name"));
            d.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            d.setIs_deleted(0);

            List<String> errors = DepartmentValidator.validate(d, codeDuplicateCheckFlag);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("department", d);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employees/edit.jsp");
                rd.forward(request, response);

            } else {

                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();

                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("department_id");
                response.sendRedirect(request.getContextPath() + "/departments/index");
            }
        }

	}

}
