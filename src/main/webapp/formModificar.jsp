
<%@page import="com.xabi.modelo.DAO_Constantes"%>
<%@page import="com.xabi.modelo.dto.Animal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	Animal ani= new Animal();

if (request.getAttribute(DAO_Constantes.ATR_ANIMAL_MODIFICAR) != null) {
	ani= (Animal) request.getAttribute(DAO_Constantes.ATR_ANIMAL_MODIFICAR);
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
			<form method="post" action="ModificarAnimal">
			
			
			
				<div class="input_div">
					<label for="id">Id</label>
					<input type="text" id="id" name="id" required readonly	value="<%=ani.getId()%>">
				</div>
				
				
				<div class="input_div">
					<label for="nombre">Nombre</label>
					<input type="text" id="nombre" name="nombre" required value="<%=ani.getNombre()%>">	
				</div>
				
				<div class="input_div">
						<label for="peso">Peso (kg):</label>
						<input type="text" id="peso" name="peso" required pattern="\d+(\.\d{1,2})?$" value="<%=ani.getPeso()%>"><br>
					</div>
				<div class="input_div">
					<label for="edad">Edad </label>
					<input type="text" id="edad" name="edad" required pattern="^[0-9]+" value="<%=ani.getEdad()%>"><br>
				</div>
					
				<div class="input_div">
					<label for="fk_especie">Especie </label>
					<input type="text" id="fk_especie" name="fk_especie"  value="<%=ani.getFk_especie()%>"><br>
				</div>
				
				<input class="submit" type="submit" value="Modificar" />
			
			</form>
		</section>
	</main>

	<%@ include file="includes/pie.jsp"%>

</body>
</html>