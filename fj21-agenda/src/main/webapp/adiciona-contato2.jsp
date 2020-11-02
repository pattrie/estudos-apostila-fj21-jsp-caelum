<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <link href="webjars/jquery-ui/1.12.1/jquery-ui.css" rel="stylesheet">--%>
<%--    <script src="webjars/jquery-ui/1.12.1/jquery-ui.js"/>--%>
<%--    <script src="webjars/jquery/3.5.0/jquery.js"/>--%>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"/>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"/>
    <title>Adiciona Contato Exercício</title>
</head>
<body>

<c:import url="cabecalho.jsp"/>

<form action="adicionaContato">
    Nome: <input type="text" name="nome"/><br/>
    E-mail: <input type="text" name="email"/><br/>
    Endereço: <input type="text" name="endereco"/><br/>
    Data de Nascimento: <tag:campoData id="dataNascimento"/><br/>

    <input type="submit" value="Gravar">

</form>

<c:import url="rodape.jsp"/>

</body>
</html>
