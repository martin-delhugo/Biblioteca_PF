package com.miapp.biblioteca;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String id;
	private ArrayList<Libro> librosPrestados;
	
	// CONSTRUCTORES
	public Usuario(String nombre, String id) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.librosPrestados = new ArrayList<>();
	}
	
	public Usuario(){
	}

	
	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Libro> getLibrosPrestados() {
		return librosPrestados;
	}

	public void setLibrosPrestados(ArrayList<Libro> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}

	
	// TO STRING
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", id=" + id + ", librosPrestados=" + librosPrestados + "]";
	}
	

	
	
	
	
	
}
