package com.xabi.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xabi.modelo.dto.Animal;
import com.xabi.modelo.dto.Especie;
import com.xabi.modelo.dto.V_Animal;

public class DB_Helper implements DAO_Constantes {

	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USUARIO, PASS);
			System.out.println("BASE DE DATOS CONECTADA");
		} catch (ClassNotFoundException e) {
			System.out.println("NO SE ENCONTRO EL DRIVER");
		} catch (SQLException e) {
			System.out.println("ERROR AL CONECTAR A LA BD");
		}
		return con;
	}

	public void desconectar(Connection con) {
		try {
			con.close();
			System.out.println("BASE DE DATOS DESCONECTADA");
		} catch (SQLException e) {
			System.out.println("NO SE PUDO DESCONECTAR");
		}
	}

	public List<Animal> obtenerTodosAnimal(Connection con) {

		List<Animal> listaAnimales = new ArrayList<Animal>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODOS_ANIMALES);

			boolean tiene_select = cStmt.execute();
			if (tiene_select) {

				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {
					Animal nuevoAnimal = new Animal();

					nuevoAnimal.setId(rs.getInt(ANIMALES_ID));
					nuevoAnimal.setNombre(rs.getString(ANIMALES_NOMBRE));
					nuevoAnimal.setPeso(rs.getByte(ANIMALES_PESO));
					nuevoAnimal.setEdad(rs.getInt(ANIMALES_EDAD));
					nuevoAnimal.setFk_especie(rs.getInt(ANIMALES_FK_ESPECIE));

					listaAnimales.add(nuevoAnimal);
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Animal>();
		}
		
		return listaAnimales;
	}

	public void insertaAnimal(Connection con, Animal nuevoAnimal) {
		try {
			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_ANIMALES);

			cStmt.setString(1, nuevoAnimal.getNombre());
			cStmt.setDouble(2, nuevoAnimal.getPeso());
			cStmt.setInt(3, nuevoAnimal.getEdad());
			cStmt.setInt(4, nuevoAnimal.getFk_especie());

			cStmt.execute();

			System.out.println("INSERTADO");

		} catch (SQLException e) {
			System.out.println("ERROR: no se inserto");
			e.printStackTrace();
		} //

	}

	public void borrarAnimalPorId(Connection con, int id) {

		try {
			CallableStatement cStmt = con.prepareCall(SP_BORRAR_ANIMAL_ID);

			cStmt.setInt(1, id);
			cStmt.execute();

			System.out.println("BORRADO");

		} catch (SQLException e) {
			System.out.println("ERROR: no se BORRO");
			e.printStackTrace();
		}

	}

	public Animal obtenerAnimalPorId(Connection con, int id) {

		Animal ani = new Animal();

		try {
			CallableStatement cStmt = con.prepareCall(SP_SELEC_ANIMAL_ID);

			cStmt.setInt(1, id);
			boolean tiene_select = cStmt.execute();

			if (tiene_select) {
				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {

					ani.setId(rs.getInt(ANIMALES_ID));
					ani.setNombre(rs.getString(ANIMALES_NOMBRE));
					ani.setPeso(rs.getByte(ANIMALES_PESO));
					ani.setEdad(rs.getInt(ANIMALES_EDAD));
					ani.setFk_especie(rs.getInt(ANIMALES_FK_ESPECIE));
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
			return new Animal();
		}
		return ani;
	}

	public void modificarAnimal(Connection con, Animal nuevoAnimal) {

		try {
			CallableStatement cStmt = con.prepareCall(SP_MODIFICAR_ANIMAL);
			cStmt.setInt(1, nuevoAnimal.getId());
			cStmt.setString(2, nuevoAnimal.getNombre());
			cStmt.setDouble(3, nuevoAnimal.getPeso());
			cStmt.setInt(4, nuevoAnimal.getEdad());
			cStmt.setInt(5, nuevoAnimal.getFk_especie());

			cStmt.execute();

			System.out.println("MODIFICADO");

		} catch (SQLException e) {
			
			System.out.println("ERROR: no se modifico");
			e.printStackTrace();
		} //

	}

	public List<V_Animal> obtenerTodosAnimalV(Connection con) {
		List<V_Animal> listaAnimales = new ArrayList<V_Animal>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODOS_ANIMALES_V);

			boolean tiene_select = cStmt.execute();
			if (tiene_select) {

				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {
					V_Animal nuevoAnimal = new V_Animal();

					nuevoAnimal.setId(rs.getInt(V_ANIMALES_ID));
					nuevoAnimal.setNombre(rs.getString(V_ANIMALES_NOMBRE));
					nuevoAnimal.setPeso(rs.getByte(V_ANIMALES_PESO));
					nuevoAnimal.setEdad(rs.getInt(V_ANIMALES_EDAD));
					nuevoAnimal.setFk_especie(rs.getInt(V_ANIMALES_FK_ESPECIE));
					nuevoAnimal.setEspecie(rs.getString(V_ANIMALES_ESPECIE));

					listaAnimales.add(nuevoAnimal);
				}
			}
		} 
		catch (SQLException e) {

			e.printStackTrace();
			return new ArrayList<V_Animal>();
		}

		return listaAnimales;
	}

	public List<Especie> obtenerTodosEspecie(Connection con) {

		List<Especie> listaEspecies = new ArrayList<Especie>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODOS_ESPECIES);

			boolean tiene_select = cStmt.execute();
			if (tiene_select) {

				ResultSet rs = cStmt.getResultSet();
				while (rs.next()) {
					Especie nuevoEspecie = new Especie();

					nuevoEspecie.setId(rs.getInt(ESPECIES_ID));
					nuevoEspecie.setEspecie(rs.getString(ESPECIES_ESPECIE));;
				
					listaEspecies.add(nuevoEspecie);
				}
			}
		} 
		catch (SQLException e) {

			e.printStackTrace();
			return new ArrayList<Especie>();
		}

		return listaEspecies;
	}

	public void insertarEspecieConId(Connection con, Especie especie) {
		try {
			CallableStatement cStmt = con.prepareCall(BACK_INSERTAR_ESPECIE_ID);

			cStmt.setInt(1, especie.getId());
			cStmt.setString(2, especie.getEspecie());
			
			cStmt.execute();

			System.out.println("INSERTADO");

		} catch (SQLException e) {
			System.out.println("ERROR: no se inserto");
			e.printStackTrace();
		} 
	}

	
	public void insertarAnimalConId(Connection con, Animal animal) {
		try {
			CallableStatement cStmt = con.prepareCall(BACK_INSERTAR_ANIMAL_ID);

			cStmt.setInt(1, animal.getId());
			cStmt.setString(2, animal.getNombre());
			cStmt.setDouble(3, animal.getPeso());
			cStmt.setInt(4,animal.getEdad());
			cStmt.setInt(5,animal.getFk_especie());
			cStmt.execute();

			System.out.println("INSERTADO");

		} catch (SQLException e) {
			System.out.println("ERROR: no se inserto");
			e.printStackTrace();
		} //		
	}

	public void borrarTablas(Connection con) {
		try {
			CallableStatement cStmt = con.prepareCall(BACK_BORRAR_TABLAS);
			
			cStmt.execute();

			System.out.println("Borrado correctamente");
		} catch (SQLException e) {
			System.out.println("ERROR: no se borro");
			e.printStackTrace();
		}					
	}

}
