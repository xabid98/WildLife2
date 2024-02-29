package com.xabi.controlador.crud;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xabi.modelo.DAO_Constantes;
import com.xabi.modelo.DB_Helper;
import com.xabi.modelo.dto.Animal;
import com.xabi.modelo.dto.Especie;
import com.xabi.modelo.dto.V_Animal;

@WebServlet("/ModificarAnimal")
public class ModificarAnimal extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;

	public ModificarAnimal() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1 Obtención de datos
		int id = 0;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}

		String nombre = "";
		if (request.getParameter("nombre") != null) {
			nombre = request.getParameter("nombre");
		}

		double peso = 0;
		if (request.getParameter("peso") != null) {
			peso = Double.parseDouble(request.getParameter("peso"));
		}
		int edad = 0;
		if (request.getParameter("edad") != null) {
			edad = Integer.parseInt(request.getParameter("edad"));
		}

		int fk_especie = 0;
		if (request.getParameter("fk_especie") != null) {
			fk_especie = Integer.parseInt(request.getParameter("fk_especie"));
		}

		// 2 Maquetar los datos a DTO
		Animal nuevoAnimal = new Animal(id, nombre, peso, edad, fk_especie);

		// 3 Conexión a la BD
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		// 4 Realización de la funcionalidad
		db.modificarAnimal(con,nuevoAnimal);
		
		List<V_Animal> listaAnimales=db.obtenerTodosAnimalV(con);

		// 5 Cierre de conexión
		db.desconectar(con);

		// 6 Empaquetado de datos
		request.setAttribute(ATR_LISTA_ANI, listaAnimales);

		// 7 Redireccion a una vista
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
