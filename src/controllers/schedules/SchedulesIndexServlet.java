package controllers.schedules;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Schedule;
import utils.DBUtil;

/**
 * Servlet implementation class SchedulesIndexServlet
 */
@WebServlet("/schedules/index")
public class SchedulesIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchedulesIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// EntityManagerのオブジェクトを生成
		EntityManager em = DBUtil.createEntityManager();


		int page;
		try{
			page = Integer.parseInt(request.getParameter("page"));

		}catch(Exception e){
			page = 1;
		}


		List<Schedule> schedules = em.createNamedQuery("getAllSchedules",Schedule.class).setFirstResult(15*(page -1))
				.setMaxResults(15).getResultList();

		long schedules_count = (long)em.createNamedQuery("getSchedulesCount",Long.class).getSingleResult();

		em.close();

		//リクエストスコープに取得したデータをセット
		request.setAttribute("schedules", schedules);
		request.setAttribute("schedules_count", schedules_count);
		request.setAttribute("page", page);


		//フラッシュメッセージがある場合はセッションスコープからデータを取得して、リクエストスコープにセットする
		if(request.getSession().getAttribute("flush") != null){
			request.setAttribute("flush", request.getSession().getAttribute("flush"));
			request.getSession().removeAttribute("flush");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedules/index.jsp");
		rd.forward(request, response);
	}

}
