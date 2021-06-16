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
                <h1>面談予定管理システム</h1>
            </div>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">
                by i-inc
            </div>
        </div>
    </body>
</html>