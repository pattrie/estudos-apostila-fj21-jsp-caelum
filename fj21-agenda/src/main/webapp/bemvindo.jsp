<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.caelum.dao.ContatoDao" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.caelum.modelo.Contato" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World!</title>
</head>
<body>

<% String mensagem = "Seja muito bem vindo ao sistema de agenda FJ-21!"; %>

<% out.println(mensagem); %>
</br>
<% String desenvolvido = "Desenvolvido por Patrícia!"; %>
</br>

<%= desenvolvido %>

<% System.out.println("Tudo foi executado!");%>

<%  ContatoDao contatoDao = new ContatoDao();
    List<Contato> contatos = contatoDao.getLista();
    Date date;
%>

<table border="1">
        <th>Nome</th>
        <th>Email</th>
        <th>Endereço</th>
        <th>Data de Nascimento</th>
<%
        for (Contato contato: contatos) {
%>
    <%--<li><%=contato.getNome()%>, <%=contato.getEmail()%>:
        <%=contato.getEndereco()%></li>--%>
<table border="1">
    <tr>
        <td><%=contato.getNome()%></td>
        <td><%=contato.getEmail()%></td>
        <td><%=contato.getEndereco()%></td>
        <td><%=new SimpleDateFormat("yyyy-MM-dd").format(contato.getDataNascimento().getTime())%></td>
    </tr>
</table>
    <%
    }
    %>

</body>
</html>
