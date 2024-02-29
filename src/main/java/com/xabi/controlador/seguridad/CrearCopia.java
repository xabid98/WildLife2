package com.xabi.controlador.seguridad;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xabi.modelo.DAO_Constantes;
import com.xabi.modelo.DB_Helper;
import com.xabi.modelo.dto.Animal;
import com.xabi.modelo.dto.Especie;
import com.xabi.modelo.dto.V_Animal;

/**
 * Servlet implementation class CrearCopia
 */
@WebServlet("/CrearCopia")
public class CrearCopia extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    public CrearCopia() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3 Conexión a la BD
		DB_Helper db= new DB_Helper();
		Connection con=db.conectar();
				
		//4 Realización de la funcionalidad
			
		List<Especie> listaEspecies=db.obtenerTodosEspecie(con);
		List<Animal> listaAnimales=db.obtenerTodosAnimal(con);

		Gson gson= new Gson();
		String listaAnimalesJSON = gson.toJson(listaAnimales);

		String listaEspeciesJSON = gson.toJson(listaEspecies);
		
		try {
			FileWriter file= new FileWriter("C:\\Users\\Usuario\\Desktop\\copia\\listaAnimalesJSON.json");
			file.write(listaAnimalesJSON);
			System.out.println("copia si");

			file.close();
		} catch (IOException e) {
			System.out.println("copia no");
			e.printStackTrace();
		}
		
		try {
			FileWriter file= new FileWriter("C:\\Users\\Usuario\\Desktop\\copia\\listaEspeciesJSON.json");
			file.write(listaEspeciesJSON);
			System.out.println("copia si");

			file.close();
		} catch (IOException e) {
			System.out.println("copia no");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(JSP_SEGURIDAD).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
