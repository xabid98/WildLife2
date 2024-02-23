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


@WebServlet("/SelecAnimal")
public class SelecAnimal extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
   
    public SelecAnimal() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 Obtención de datos
		int id = 0;
		if (request.getParameter("id") != null) {
			id =Integer.parseInt(request.getParameter("id"));
		}
		//2 Maquetar los datos a DTO
		
		//3 Conexión a la BD
		
		DB_Helper db= new DB_Helper();
		Connection con=db.conectar();
		
		//4 Realización de la funcionalidad

		Animal animal= db.obtenerAnimalPorId(con, id);

		System.out.println(animal);
		//5 Cierre de conexión
		
		db.desconectar(con); 
		
		//6 Empaquetado de datos 
		request.setAttribute(ATR_ANIMAL_MODIFICAR, animal);

	//7 Redireccion a una vista
		
		request.getRequestDispatcher(JSP_FORM_MODIFICAR).forward(request, response);
		
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
