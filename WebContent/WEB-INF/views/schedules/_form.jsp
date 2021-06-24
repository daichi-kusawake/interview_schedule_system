<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- エラーがリクエストスコープに格納されていた場合 -->
<c:if test="${errors != null}">
    <div id="${flush_error}">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>


<label for="project_title">案件名</label><br />

<input type="text" name="project_title" value="${schedule.project_title}" />
<br /><br />

<label for="place">場所</label><br />
<input type="text" name="place" value="${schedule.place}" />
<br /><br />

<label for="vendor">ベンダー</label><br />
<input type="text" name="vendor" value="${schedule.vendor}" />
<br /><br />

<label for="ordering_company">上位会社（発注元企業）</label><br />
<input type="text" name="ordering_company" value="${schedule.ordering_company}" />
<br /><br />

<label for="sales_employee_id">担当営業</label><br />
<select name="sales_employee_id">
    <c:forEach var="sales_employee" items="${employees}">
        <option value="${sales_employee.id}"<c:if test="${sales_employee.id == schedule.sales_employee.id}"> selected</c:if>>
        ${sales_employee.employee_code} : ${sales_employee.employee_name}</option>
    </c:forEach>
</select>
<br /><br />

<label for="introduce_date_date">紹介日</label><br />
<input type="date" name="introduce_date" value="<fmt:formatDate value='${schedule.introduce_date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="project_overview">案件概要</label><br />
<textarea name="project_overview" rows="10" cols="50">${schedule.project_overview}</textarea>
<br /><br />

<label for="number_of_interviews">予定面談回数</label><br />
<input type="text" name="number_of_interviews" value="${schedule.number_of_interviews}" />
<br /><br />

<label for="priority">優先順位</label><br />
<input type="text" name="priority" value="${schedule.priority}" />
<br /><br />

<label for="aspiration_situation">志望状況</label><br />
<select name="aspiration_situation">
    <option value=""<c:if test="${empty schedule.aspiration_situation}"> selected</c:if>></option>
    <option value="1"<c:if test="${schedule.aspiration_situation == 1}"> selected</c:if>>志望する</option>
    <option value="2"<c:if test="${schedule.aspiration_situation == 2}"> selected</c:if>>志望しない</option>
</select>
<br /><br />

<label for="interview_situation">面談状況</label><br />
<select name="interview_situation">
    <option value=""<c:if test="${empty schedule.interview_situation}"> selected</c:if>></option>
    <option value="1"<c:if test="${schedule.interview_situation == 1}"> selected</c:if>>開始前</option>
    <option value="2"<c:if test="${schedule.interview_situation == 2}"> selected</c:if>>一次面談実施済</option>
    <option value="3"<c:if test="${schedule.interview_situation == 3}"> selected</c:if>>二次面談実施済</option>
</select>
<br /><br />

<label for="pass_fail_status">合否状況</label><br />
<select name="pass_fail_status">
    <option value=""<c:if test="${empty schedule.pass_fail_status}"> selected</c:if>></option>
    <option value="1"<c:if test="${schedule.pass_fail_status == 1}"> selected</c:if>>合格</option>
    <option value="2"<c:if test="${schedule.pass_fail_status == 2}"> selected</c:if>>不合格</option>
</select>
<br /><br />

<label for="first_interview_scheduled_date">一次面談予定日</label><br />
<input type="date" name="first_interview_scheduled_date"
value="<fmt:formatDate value='${schedule.first_interview_scheduled_date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="first_interview_scheduled_time">一次面談予定時間</label><br />
<input type="time" name="first_interview_scheduled_time"
value="<fmt:formatDate value='${schedule.first_interview_scheduled_time}' pattern='HH:mm' />" />
<br /><br />

<label for="first_interview_format">一次面談形式</label><br />
<select name="first_interview_format">
    <option value=""<c:if test="${empty schedule.first_interview_format}"> selected</c:if>></option>
    <option value="1"<c:if test="${schedule.first_interview_format == 1}"> selected</c:if>>対面</option>
    <option value="2"<c:if test="${schedule.first_interview_format == 2}"> selected</c:if>>オンライン</option>
</select>
<br /><br />

<label for="first_interview_tool">一次面談ツール</label><br />
<input type="text" name="first_interview_tool" value="${schedule.first_interview_tool}" />
<br /><br />

<label for="first_interview_url">一次面談URL</label><br />
<input type="text" name="first_interview_url" value="${schedule.first_interview_url}" />
<br /><br />

<label for="first_interview_id">一次面談ID</label><br />
<input type="text" name="first_interview_id" value="${schedule.first_interview_id}" />
<br /><br />

<label for="first_interview_password">一次面談パスワード</label><br />
<input type="text" name="first_interview_password" value="${schedule.first_interview_password}" />
<br /><br />

<label for="first_interview_date">一次面談実施日</label><br />
<input type="date" name="first_interview_date"
value="<fmt:formatDate value='${schedule.first_interview_date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="first_interview_time">一次面談実施時間</label><br />
<input type="time" name="first_interview_time"
value="<fmt:formatDate value='${schedule.first_interview_time}' pattern='HH:mm' />" />
<br /><br />

<label for="second_interview_scheduled_date">二次面談予定日</label><br />
<input type="date" name="second_interview_scheduled_date"
value="<fmt:formatDate value='${schedule.second_interview_scheduled_date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="second_interview_scheduled_time">二次面談予定時間</label><br />
<input type="time" name="second_interview_scheduled_time"
value="<fmt:formatDate value='${schedule.second_interview_scheduled_time}' pattern='HH:mm' />" />
<br /><br />

<label for="second_interview_format">二次面談形式</label><br />
<select name="second_interview_format">
    <option value=""<c:if test="${empty schedule.second_interview_format}"> selected</c:if>></option>
    <option value="1"<c:if test="${schedule.second_interview_format == 1}"> selected</c:if>>対面</option>
    <option value="2"<c:if test="${schedule.second_interview_format == 2}"> selected</c:if>>オンライン</option>
</select>
<br /><br />

<label for="second_interview_tool">二次面談ツール</label><br />
<input type="text" name="second_interview_tool" value="${schedule.second_interview_tool}" />
<br /><br />

<label for="second_interview_url">二次面談URL</label><br />
<input type="text" name="second_interview_url" value="${schedule.second_interview_url}" />
<br /><br />

<label for="second_interview_id">二次面談ID</label><br />
<input type="text" name="second_interview_id" value="${schedule.second_interview_id}" />
<br /><br />

<label for="second_interview_password">二次面談パスワード</label><br />
<input type="text" name="second_interview_password" value="${schedule.second_interview_password}" />
<br /><br />

<label for="second_interview_date">二次面談実施日</label><br />
<input type="date" name="second_interview_date"
value="<fmt:formatDate value='${schedule.second_interview_date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="second_interview_time">二次面談実施時間</label><br />
<input type="time" name="second_interview_time"
value="<fmt:formatDate value='${schedule.second_interview_time}' pattern='HH:mm' />" />
<br /><br />

<label for="supplement">補足</label><br />
<textarea name="supplement" rows="10" cols="50">${schedule.supplement}</textarea>
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
