<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
	<c:param name="content">
		<c:if test="${flush != null}">
			<div id="flush_success">
				<c:out value="${flush}"></c:out>
			</div>
		</c:if>
		<h2>面談予定管理システムへようこそ</h2>


		<c:if test="${schedule != null }">

			<h3>【自分の面談予定 一覧】</h3>

			<table id="schedule_list">
				<tbody>
					<tr>
						<th class="schedule_employee_name">氏名</th>
						<th class="schedule_project_title">案件名</th>
						<th class="schedule_place">場所</th>
						<th class="schedule_ordering_company">発注企業</th>
						<th class="schedule_sales_employee_name">担当営業</th>
						<th class="schedule_priority">優先順位</th>
						<th class="schedule_aspiration_situation">志望状況</th>
						<th class="schedule_interview_situation">面談状況</th>
						<th class="schedule_pass_fail_status">合否状況</th>
						<th class="schedule_first_interview_scheduled_date">一次面談予定日</th>
						<th class="schedule_first_interview_scheduled_time">一次面談予定時間</th>
						<th class="schedule_second_interview_scheduled_date">二次面談予定日</th>
						<th class="schedule_second_interview_scheduled_time">二次面談予定時間</th>
						<th class="schedule_action">操作</th>
					</tr>
					<c:forEach var="schedule" items="${schedules}" varStatus="status">
						<tr class="row${status.count % 2}">
							<td class="schedule_employee_name"><c:out
									value="${schedule.employee.employee_name}" /></td>
							<td class="schedule_project_title"><c:out
									value="${schedule.project_title}" /></td>
							<td class="schedule_place"><c:out value="${schedule.place}" /></td>
							<td class="schedule_ordering_company"><c:out
									value="${schedule.ordering_company}" /></td>
							<td class="schedule_sales_employee_name"><c:out
									value="${schedule.sales_employee.employee_name}" /></td>
							<td class="schedule_priority"><c:out
									value="${schedule.priority}" /></td>
							<td class="schedule_aspiration_situation"><c:choose>
									<c:when test="${schedule.aspiration_situation == 1}">志望する</c:when>
									<c:when test="${schedule.aspiration_situation == 2}">志望しない</c:when>
									<c:otherwise>（未入力）</c:otherwise>
								</c:choose></td>
							<td class="schedule_interview_situation"><c:choose>
									<c:when test="${schedule.interview_situation == 1}">開始前</c:when>
									<c:when test="${schedule.interview_situation == 2}">一次面談実施済</c:when>
									<c:when test="${schedule.interview_situation == 3}">二次面談実施済</c:when>
									<c:otherwise>（未入力）</c:otherwise>
								</c:choose></td>
							<td class="schedule_pass_fail_status"><c:choose>
									<c:when test="${schedule.pass_fail_status == 1}">合格</c:when>
									<c:when test="${schedule.pass_fail_status == 2}">不合格</c:when>
									<c:otherwise>（未入力）</c:otherwise>
								</c:choose></td>
							<td class="schedule_first_interview_scheduled_date"><fmt:formatDate
									value='${schedule.first_interview_scheduled_date}'
									pattern='yyyy-MM-dd' /></td>
							<td class="schedule_first_interview_scheduled_time"><fmt:formatDate
									value='${schedule.first_interview_scheduled_time}'
									pattern='HH:mm' /></td>
							<td class="schedule_second_interview_scheduled_date"><fmt:formatDate
									value='${schedule.second_interview_scheduled_date}'
									pattern='yyyy-MM-dd' /></td>
							<td class="schedule_second_interview_scheduled_time"><fmt:formatDate
									value='${schedule.second_interview_scheduled_time}'
									pattern='HH:mm' /></td>
							<td class="schedule_action"><a
								href="<c:url value='/schedules/show?id=${schedule.id}' />">詳細を見る</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div id="paginattion">
				(全 ${schedules_count} 件)<br />
				<c:forEach var="i" begin="1"
					end="${((schedules_count - 1) / 15) + 1}" step="1">
					<c:choose>
						<c:when test="${i == page}">
							<c:out value="${i}" />&nbsp;
                    </c:when>
						<c:otherwise>
							<a href="<c:url value='/?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<p>
				<a href="<c:url value='/schedules/new' />">新規予定の登録</a>
			</p>

		</c:if>
	</c:param>
</c:import>