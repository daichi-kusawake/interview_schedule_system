<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>部署データ　一覧</h2>
        <table id="department_list">
            <tbody>
                <tr>
                    <th>部署コード</th>
                    <th>部署名</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="department" items="${departments}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${department.department_code}" /></td>
                        <td><c:out value="${department.department_name}" /></td>
                        <td>
                            <c:choose>
                                <c:when test="${department.is_deleted == 1}">
                                    （削除済み）
                                </c:when>
                                <c:otherwise>
                                    <a href="<c:url value='/departments/show?id=${department.id}' />">詳細を表示</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            <p>（全 ${departments_count} 件）</p>

            <c:forEach var="i" begin="1" end="${((departments_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/departments/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/departments/new' />">新規の登録</a></p>

    </c:param>
</c:import>