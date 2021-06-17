<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${department != null}">
                <h2>id : ${department.id} の部署情報　詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>部署コード</th>
                            <td><c:out value="${department.department_code}" /></td>
                        </tr>
                        <tr>
                            <th>部署名</th>
                            <td><c:out value="${department.department_name}" /></td>
                        </tr>
                        <tr>

                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${department.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${department.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>

                <p><a href="<c:url value='/departments/edit?id=${department.id}' />">この部署情報を編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/departments/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>
