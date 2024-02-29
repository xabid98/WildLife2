<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
			<div class="div_seguridad">
				<button>	
					<a href="CrearCopia">Crear copia</a>
				</button>
				
				<button>	
					<a href="RestaurarCopia">Restaurar copia</a>
				</button>
			</div>
		</section>
	</main>

	<%@ include file="includes/pie.jsp"%>

</body>
</html>