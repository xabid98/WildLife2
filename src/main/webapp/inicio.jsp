<%@page import="com.xabi.modelo.dto.V_Animal"%>
<%@page import="com.xabi.modelo.dto.Animal"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xabi.modelo.DAO_Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@pageimport="java.util.List"%>
<%@pageimport="com.xabi.modelo.dto.V_Animal"%>
<%@pageimport="java.util.ArrayList"%>

<%
List<V_Animal> listaTodosAnimales = new ArrayList<V_Animal>();

if (request.getAttribute(DAO_Constantes.ATR_LISTA_ANI) != null) {
	listaTodosAnimales = (List<V_Animal>) request.getAttribute(DAO_Constantes.ATR_LISTA_ANI);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/style.css">
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
						<th>ESPECIE</th>
						<th>MODIFICAR</th>
						<th>BORRAR</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (V_Animal elemento : listaTodosAnimales) {
					%>
					<tr>
						<td><%=elemento.getId()%></td>
						<td><%=elemento.getNombre()%></td>
						<td><%=elemento.getPeso()%></td>
						<td><%=elemento.getEdad()%></td>
						<td><%=elemento.getEspecie()%></td>
						<td> 
							<a href="BorrarAnimal?id=<%=elemento.getId()%>">
								<img alt="MODIFICAR" src="images/modificar.png">
							</a>
						</td>
						<td> 
							<a href="SelecAnimal?id=<%=elemento.getId()%>">
								<img alt="BORRAR" src="images/borrar.png">
							</a>
						</td>						
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