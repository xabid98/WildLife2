<%@page import="com.xabi.modelo.dto.Animal"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xabi.modelo.DAO_Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@pageimport="java.util.List"%>
<%@pageimport="com.xabi.modelo.dto.Animal"%>
<%@pageimport="java.util.ArrayList"%>


<%
List<Animal> listaTodosAnimales = new ArrayList<Animal>();

if (request.getAttribute(DAO_Constantes.ATR_LISTA_ANI) != null) {
	listaTodosAnimales = (List<Animal>) request.getAttribute(DAO_Constantes.ATR_LISTA_ANI);
}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" media="screen and (min-width: 481px) "
	href="styles/sobremesa.css">
<link rel="stylesheet" media="screen and (max-width: 480px)"
	href="styles/movil.css">
</head>
<body>

	<%@ include file="includes/cabecera.jsp"%>
	<main>
		<%@ include file="includes/menu_nav.jsp"%>
	
		<section>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRE</th>
						<th>PESO</th>
						<th>EDAD</th>
						<th>FK_ESPECIE</th>
						<th>BORRAR</th>
						<th>MODIFICAR</th>
					</tr>
				</thead>

				<tbody>
					<%
					for (Animal elemento : listaTodosAnimales) {
					%>
					<tr>
						<td><%=elemento.getId()%></td>
						<td><%=elemento.getNombre()%></td>
						<td><%=elemento.getPeso()%></td>
						<td><%=elemento.getEdad()%></td>
						<td><%=elemento.getFk_especie()%></td>
						<td> <a href="BorrarAnimal?id=<%=elemento.getId()%>">BORRAR</a></td>
						<td> <a href="SelecAnimal?id=<%=elemento.getId()%>">MODIFICAR</a></td>
						
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</section>
	</main>

	<%@ include file="includes/pie.jsp"%>

</body>
</html>