package com.xabi.modelo;

public interface DAO_Constantes {

	// cadenas de conexion
		String BASE_DATOS = "bd_wild_life_2";
		String DRIVER = "com.mysql.jdbc.Driver";
		String CONEXION = "jdbc:mysql://localhost:3306/" + BASE_DATOS;
		String USUARIO = "root";
		String PASS = "1234";
		
	// cosntantes de tablas y vistas
		String TABLA_ANIMALES = "animales";
		String ANIMALES_ID = "id";	
		String ANIMALES_NOMBRE = "nombre";	
		String ANIMALES_PESO = "peso";	
		String ANIMALES_EDAD = "edad";
		String ANIMALES_FK_ESPECIE = "FK_especie";	


		
		String TABLA_ESPECIES = "especies";
		String ESPECIES_ID = "id";	
		String ESPECIES_ESPECIE = "especie";	

	// constantes de llamadas a Stored procedures
		String SP_OBTENER_TODOS_ANIMALES = "call sp_obtenenTodosAnimales();";
		String SP_INSERTAR_ANIMALES = "call sp_insertarAnimal(?,?,?,?);";
		String SP_TODAS_ESPECIES = "call sp_obtenerTodasEspecies();";
		String SP_BORRAR_ANIMAL_ID = "call sp_borraAnimalId(?);";
		String SP_SELEC_ANIMAL_ID = "call sp_selecAnimalId(?);";
		String SP_MODIFICAR_ANIMAL = "call sp_modificar_animal(?,?,?,?,?);";

		

		
		


	// atributos de la mochila
		String ATR_LISTA_ANI = "atr_lista_animales";
		String  ATR_ANIMAL_MODIFICAR = "atr_animal_modificar";

		
	// archivos JSP
		String JSP_INDEX = "inicio.jsp";
		String JSP_INSERTAR = "insertar.jsp";
		String JSP_FORM_MODIFICAR = "formModificar.jsp";

		
}
