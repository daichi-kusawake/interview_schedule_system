package controllers.schedules;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
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
import models.validators.ScheduleValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ScheduleUpdateServlet
 */
@WebServlet("/schedules/update")
public class SchedulesUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchedulesUpdateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Schedule s = em.find(Schedule.class, (Integer)(request.getSession().getAttribute("schedule_id")));

            s.setProject_title(request.getParameter("project_title"));
            s.setPlace(request.getParameter("place"));
            s.setVendor(request.getParameter("vendor"));
            s.setOrdering_company(request.getParameter("ordering_company"));

            // Employee情報の設定 送られてきた営業のidを検索して従業員データを格納
            Employee sales_employee = em.find(Employee.class,
                    Integer.parseInt(request.getParameter("sales_employee_id")));
            s.setSales_employee(sales_employee);

            Date introduce_date = null;
            String introduce_date_str = request.getParameter("introduce_date");
            if(introduce_date_str != null && !introduce_date_str.equals("")) {
                introduce_date = Date.valueOf(request.getParameter("introduce_date"));
            }
            s.setIntroduce_date(introduce_date);

            s.setProject_overview(request.getParameter("project_overview"));

            Integer number_of_interviews = null;
            String number_of_interviews_str = request.getParameter("number_of_interviews");
            if(number_of_interviews_str != null && !number_of_interviews_str.equals("")) {
                number_of_interviews = Integer.parseInt(request.getParameter("number_of_interviews"));
            }
            s.setNumber_of_interviews(number_of_interviews);

            Integer priority = null;
            String priority_str = request.getParameter("priority");
            if(priority_str != null && !priority_str.equals("")) {
                priority = Integer.parseInt(request.getParameter("priority"));
            }
            s.setPriority(priority);

            Integer aspiration_situation = null;
            String aspiration_situation_str = request.getParameter("aspiration_situation");
            if(aspiration_situation_str != null && !aspiration_situation_str.equals("")) {
                aspiration_situation = Integer.parseInt(request.getParameter("aspiration_situation"));
            }
            s.setAspiration_situation(aspiration_situation);

            Integer interview_situation = null;
            String interview_situation_str = request.getParameter("interview_situation");
            if(interview_situation_str != null && !interview_situation_str.equals("")) {
                interview_situation = Integer.parseInt(request.getParameter("interview_situation"));
            }
            s.setInterview_situation(interview_situation);

            Integer pass_fail_status = null;
            String pass_fail_status_str = request.getParameter("pass_fail_status");
            if(pass_fail_status_str != null && !pass_fail_status_str.equals("")) {
                pass_fail_status = Integer.parseInt(request.getParameter("pass_fail_status"));
            }
            s.setPass_fail_status(pass_fail_status);

            Date first_interview_scheduled_date = null;
            String first_interview_scheduled_date_str = request.getParameter("first_interview_scheduled_date");
            if(first_interview_scheduled_date_str != null && !first_interview_scheduled_date_str.equals("")) {
                first_interview_scheduled_date = Date.valueOf(request.getParameter("first_interview_scheduled_date"));
            }
            s.setFirst_interview_scheduled_date(first_interview_scheduled_date);

            Time first_interview_scheduled_time = null;
            String first_interview_scheduled_time_str = request.getParameter("first_interview_scheduled_time");
            if(first_interview_scheduled_time_str != null && !first_interview_scheduled_time_str.equals("")) {
                first_interview_scheduled_time = Time.valueOf(
                        request.getParameter("first_interview_scheduled_time") + ":00");
            }
            s.setFirst_interview_scheduled_time(first_interview_scheduled_time);

            Integer first_interview_format = null;
            String first_interview_format_str = request.getParameter("first_interview_format");
            if(first_interview_format_str != null && !first_interview_format_str.equals("")) {
                first_interview_format = Integer.parseInt(request.getParameter("first_interview_format"));
            }
            s.setFirst_interview_format(first_interview_format);

            s.setFirst_interview_tool(request.getParameter("first_interview_tool"));
            s.setFirst_interview_url(request.getParameter("first_interview_url"));
            s.setFirst_interview_id(request.getParameter("first_interview_id"));
            s.setFirst_interview_password(request.getParameter("first_interview_password"));

            Date first_interview_date = null;
            String first_interview_date_str = request.getParameter("first_interview_date");
            if(first_interview_date_str != null && !first_interview_date_str.equals("")) {
                first_interview_date = Date.valueOf(request.getParameter("first_interview_date"));
            }
            s.setFirst_interview_date(first_interview_date);

            Time first_interview_time = null;
            String first_interview_time_str = request.getParameter("first_interview_time");
            if(first_interview_time_str != null && !first_interview_time_str.equals("")) {
                first_interview_time = Time.valueOf(request.getParameter("first_interview_time") + ":00");
            }
            s.setFirst_interview_time(first_interview_time);

            Date second_interview_scheduled_date = null;
            String second_interview_scheduled_date_str = request.getParameter("second_interview_scheduled_date");
            if(second_interview_scheduled_date_str != null && !second_interview_scheduled_date_str.equals("")) {
                second_interview_scheduled_date = Date.valueOf(request.getParameter("second_interview_scheduled_date"));
            }
            s.setSecond_interview_scheduled_date(second_interview_scheduled_date);

            Time second_interview_scheduled_time = null;
            String second_interview_scheduled_time_str = request.getParameter("second_interview_scheduled_time");
            if(second_interview_scheduled_time_str != null && !second_interview_scheduled_time_str.equals("")) {
                second_interview_scheduled_time = Time.valueOf(
                        request.getParameter("second_interview_scheduled_time") + ":00");
            }
            s.setSecond_interview_scheduled_time(second_interview_scheduled_time);

            Integer second_interview_format = null;
            String second_interview_format_str = request.getParameter("second_interview_format");
            if(second_interview_format_str != null && !second_interview_format_str.equals("")) {
                second_interview_format = Integer.parseInt(request.getParameter("second_interview_format"));
            }
            s.setSecond_interview_format(second_interview_format);

            s.setSecond_interview_tool(request.getParameter("second_interview_tool"));
            s.setSecond_interview_url(request.getParameter("second_interview_url"));
            s.setSecond_interview_id(request.getParameter("second_interview_id"));
            s.setSecond_interview_password(request.getParameter("second_interview_password"));

            Date second_interview_date = null;
            String second_interview_date_str = request.getParameter("second_interview_date");
            if(second_interview_date_str != null && !second_interview_date_str.equals("")) {
                second_interview_date = Date.valueOf(request.getParameter("second_interview_date"));
            }
            s.setSecond_interview_date(second_interview_date);

            Time second_interview_time = null;
            String second_interview_time_str = request.getParameter("second_interview_time");
            if(second_interview_time_str != null && !second_interview_time_str.equals("")) {
                second_interview_time = Time.valueOf(request.getParameter("second_interview_time") + ":00");
            }
            s.setSecond_interview_time(second_interview_time);

            s.setSupplement(request.getParameter("supplement"));
            s.setUpdated_at(new Timestamp(System.currentTimeMillis()));

            List<String> errors = ScheduleValidator.validate(s);

            if(errors.size() > 0) {

                // 社員情報一覧表示のため社員情報テーブルのデータを取得する
                List<Employee> employees = em.createNamedQuery("getAllSalesEmployeesNotDeleted", Employee.class)
                        .getResultList();
                request.setAttribute("employees", employees);

                em.close();

                request.setAttribute("_token",request.getSession().getId());
                request.setAttribute("schedule", s);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedules/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("schdule_id");

                response.sendRedirect(request.getContextPath() + "/schedules/index");
            }

        }

    }

}
