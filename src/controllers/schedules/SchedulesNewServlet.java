package controllers.schedules;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Schedule;
import utils.DBUtil;

/**
 * Servlet implementation class SchedulesNewServlet
 */
@WebServlet("/schedules/new")
public class SchedulesNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchedulesNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("_token", request.getSession().getId());

        Schedule s = new Schedule();

        //本日の日付を取得
        s.setIntroduce_date(new Date(System.currentTimeMillis()));

        request.setAttribute("schedule", s);

        // 社員情報一覧表示のため社員情報テーブルのデータを取得する
        EntityManager em = DBUtil.createEntityManager();
        List<Employee> employees = em.createNamedQuery("getAllEmployeesNotDeleted", Employee.class)
                .getResultList();
        em.close();

        request.setAttribute("employees", employees);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedules/new.jsp");
        rd.forward(request, response);
	}

}
