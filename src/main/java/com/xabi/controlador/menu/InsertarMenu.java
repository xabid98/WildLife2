package com.xabi.controlador.menu;

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
import com.xabi.modelo.dto.Especie;
import com.xabi.modelo.dto.V_Animal;

@WebServlet("/InsertarMenu")
public class InsertarMenu extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;

	public InsertarMenu() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		// 4 Realización de la funcionalidad
		List<V_Animal> listaAnimales = db.obtenerTodosAnimalV(con);
		List<Especie> listaEspecies = db.obtenerTodosEspecie(con);

		// 5 Cierre de conexión

		db.desconectar(con);

		// 6 Empaquetado de datos
		request.setAttribute(ATR_LISTA_ANI, listaAnimales);
		request.setAttribute(ATR_LISTA_ESP, listaEspecies);

		// 7 Redireccion a una vista
		request.getRequestDispatcher(JSP_INSERTAR).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
