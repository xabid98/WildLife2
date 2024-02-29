package com.xabi.controlador.seguridad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xabi.modelo.DAO_Constantes;
import com.xabi.modelo.DB_Helper;
import com.xabi.modelo.dto.Animal;
import com.xabi.modelo.dto.Especie;


@WebServlet("/RestaurarCopia")
public class RestaurarCopia extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    public RestaurarCopia() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DB_Helper db= new DB_Helper();
		Connection con=db.conectar();
		db.borrarTablas(con);
		
		try {
		    // Lee el contenido del archivo JSON
		    FileReader fileReader = new FileReader("C:\\Users\\Usuario\\Desktop\\copia\\listaEspeciesJSON.json");
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    String listaEspeciesJSON = bufferedReader.readLine();
		    bufferedReader.close();

		    // Convierte la cadena JSON a una lista de objetos Especie
		    
		    Type tipoObjetoLista = new TypeToken<List<Especie>>() {}.getType();
			Gson gson = new Gson();
			List<Especie> restoredListaEspecies = gson.fromJson(listaEspeciesJSON, tipoObjetoLista);
  		    
			for (Especie especie : restoredListaEspecies) {
				  db.insertarEspecieConId(con, especie);
	            }
		    
		} catch (IOException e) {
		    System.out.println("Error al leer el archivo JSON: " + e.getMessage());
		    e.printStackTrace();
		}
		
		try {
		    // Lee el contenido del archivo JSON
		    FileReader fileReader = new FileReader("C:\\Users\\Usuario\\Desktop\\copia\\listaAnimalesJSON.json");
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    String listaAnimalesJSON = bufferedReader.readLine();
		    bufferedReader.close();

		    // Convierte la cadena JSON a una lista de objetos Animal
		    
		    Type tipoObjetoLista = new TypeToken<List<Animal>>() {}.getType();

			Gson gson = new Gson();
			List<Animal> restoredListaAnimales = gson.fromJson(listaAnimalesJSON, tipoObjetoLista);

			for (Animal animal : restoredListaAnimales) {
				  db.insertarAnimalConId(con, animal);
	            }
		    
		} 
		catch (IOException e) {
		    System.out.println("Error al leer el archivo JSON: " + e.getMessage());
		    e.printStackTrace();
		}
		
		request.getRequestDispatcher(JSP_SEGURIDAD).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
