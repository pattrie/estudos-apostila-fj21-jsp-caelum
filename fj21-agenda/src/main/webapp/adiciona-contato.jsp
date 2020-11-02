<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>

<c:import url="cabecalho.jsp"/>

<!--cria o DAO-->
<jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDao"/>

<table border="1">
    <th>id</th>
    <th>Nome</th>
    <th>Email</th>
    <th>Endereço</th>
    <th>Data de Nascimento</th>
    <!--percorre contatos montando as linhas da tabela-->
    <c:forEach var="contato" items="${dao.lista}" varStatus="id">
        <tr bgcolor="#${id.count % 2 == 0 ? 'add8e6' : 'ffffff'}">
            <td>${id.count}</td>
            <td>${contato.nome}</td>
            <c:choose>
                <c:when test="${not empty contato.email}">
                    <td><a href="mailto:${contato.email}">${contato.email}</a></td>
                </c:when>
                <c:otherwise><td>Email não informado.</td></c:otherwise>
            </c:choose>
<%--            <c:if test="${not empty contato.email}">--%>
<%--            <td><a href="mailto:${contato.email}">${contato.email}</a></td>--%>
<%--            </c:if>--%>
            <td>${contato.endereco}</td>
            <td><fmt:formatDate value="${contato.dataNascimento.time}"
            pattern="dd/MM/yyyy"/></td>
        </tr>
    </c:forEach>
</table>

<c:import url="rodape.jsp"/>

</body>
</html>
