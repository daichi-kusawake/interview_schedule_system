<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="employee_code">社員番号</label><br />
<input type="text" name="employee_code" value="${employee.employee_code}" />
<br /><br />

<label for="employee_name">氏名</label><br />
<input type="text" name="employee_name" value="${employee.employee_name}" />
<br /><br />

<label for="password">パスワード</label><br />
<input type="password" name="password" />
<br /><br />

<label for="admin_flag">権限</label><br />
<select name="admin_flag">
    <option value="0"<c:if test="${employee.admin_flag == 0}"> selected</c:if> >一般</option>
    <option value="1"<c:if test="${employee.admin_flag == 1}"> selected</c:if> >管理者</option>
</select>
<br /><br />

<label for="department_id">所属部署</label><br />
<select name="department_id">
    <c:forEach var="department" items="${departments}">
        <option value="${department.id}"<c:if test="${department.id == employee.department.id}"> selected</c:if>>
        ${department.department_code} : ${department.department_name}</option>
    </c:forEach>
</select>
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
