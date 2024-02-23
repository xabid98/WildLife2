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
			<form action="InsertarAnimal" method="get">
			
			<div class="input_div">
					<label for="nombre">Nombre:</label>
				<input type="text" id="nombre" name="nombre" required>
				</div>
			
			<div class="input_div">
					<label for="peso">Peso (kg):</label>
					<input type="text" id="peso" name="peso" required pattern="\d+(\.\d{1,2})?$"><br>
				</div>
			
			<div class="input_div">
					<label for="edad">Edad </label>
					<input type="text" id="edad" name="edad" required pattern="^[0-9]+"><br>
				</div>
			<div class="input_div">
					<label for="fk_especie">Especie</label> 
					<select id="fk_especie" name="fk_especie">
						<option value="1">Perro</option>
						<option value="2">Gato</option>
						<option value="3">Tortuga</option>
						<option value="4">Cabra</option>
						<option value="5">Alpaca</option>
					</select>
				</div>
			
				
				
				<input class="submit" type="submit" value="Insertar" />
			</form>
		</section>
	</main>

	<%@ include file="includes/pie.jsp"%>

</body>
</html>