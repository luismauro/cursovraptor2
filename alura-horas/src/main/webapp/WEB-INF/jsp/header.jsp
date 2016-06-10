<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sistema de horas</title>
    <link href="<c:url value='/bootstrap/css/bootstrap.css'/>" rel="stylesheet" />
    <link href="<c:url value='/css/site.css'/>" rel="stylesheet" />
</head>
<body>
    <header>
    </header>
    <nav>
        <ul class="nav nav-tabs">
     
            <li><a href="${linkTo[IndexController].index()}">Home</a></li>
            <li><a href="${linkTo[UsuarioController].lista()}">Usuarios</a></li>
            <li><a href="${linkTo[HoraLancadaController].lista()}">Lista de Horas</a></li>
            <li><a href="${linkTo[HoraLancadaController].relatorioDeHoras()}">Relatorio de Horas</a></li>
            
            <c:if test="${usuarioLogado.logado}">
            	<li><a href="${linkTo[LoginController].desloga()}">Deslogar</a></li>
            </c:if>
            <c:if test="${!usuarioLogado.logado}">
            	<li><a href="${linkTo[LoginController].form()}">Autenticar</a></li>
            </c:if>
            
           
        </ul>
    </nav>
    <div class="container">
        <main class="col-sm-8">
        <!-- conteudo das pagina  -->
