package com.xabi.modelo.dto;

public class V_Animal {

	private int id;
	private String nombre;
	private double peso;
	private int edad;
	private int fk_especie;
	private String especie;
	
	public V_Animal(int id, String nombre, double peso, int edad, int fk_especie, String especie) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.peso = peso;
		this.edad = edad;
		this.fk_especie = fk_especie;
		this.especie = especie;
	}
	
	public V_Animal() {
		super();
		this.id = 0;
		this.nombre = "";
		this.peso = 0;
		this.edad = 0;
		this.fk_especie = 0;
		this.especie = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getFk_especie() {
		return fk_especie;
	}

	public void setFk_especie(int fk_especie) {
		this.fk_especie = fk_especie;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "V_Animal [id=" + id + ", nombre=" + nombre + ", peso=" + peso + ", edad=" + edad + ", fk_especie="
				+ fk_especie + ", especie=" + especie + "]";
	}
	
}
