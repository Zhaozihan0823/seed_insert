<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<table width="100%">
	<c:forEach items="${list}" var="e" varStatus="state">
		<c:if test="${state.index mod 3==0 }">
			<tr>
		</c:if>
			<td><input type="checkbox" name="receiveEmpId" value="${e.empid}" empName="${e.empName }"/>${e.empName }</td>
		<c:if test="${state.index mod 3==2 }" var="flag">
			</tr>
		</c:if>
	</c:forEach>
	<c:if test="${!flag }">
		</tr>
	</c:if>
</table>