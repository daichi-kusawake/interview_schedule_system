<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">
    <head>
        <meta charset = "UTF-8">
        <title>面談予定管理システム</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
            	<div id="header_menu">
                 	<h1><a href="<c:url value='/' />">面談予定管理システム</a></h1>&nbsp;&nbsp;&nbsp;&nbsp;

                 	<!-- ログイン状態の場合 -->
                 	<c:if test="${sessionScope.login_employee != null}">

                        <c:if test="${sessionScope.login_employee.admin_flag == 1}">
                        	<a href="<c:url value='/departments/index' />">部署管理</a>&nbsp;
                            <a href="<c:url value='/employees/index' />">社員管理</a>&nbsp;
                        </c:if>

                        <a href="<c:url value='/schedules/index' />">面談予定管理</a>&nbsp;

                    </c:if>
                </div>

                <c:if test="${sessionScope.login_employee != null}">
                    <div id="employee_name">
                        <c:out value="${sessionScope.login_employee.employee_name}" />&nbsp;さん&nbsp;&nbsp;&nbsp;
                        <a href="<c:url value='/logout' />">ログアウト</a>
                    </div>
                </c:if>

            </div>

            <div id="content">
                ${param.content}
            </div>
			<br/>
            <footer>
    		© All rights reserved by i-inc
    		</footer>
        </div>
    </body>

</html>