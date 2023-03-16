/*
*Nombre: Nicolas Rodriguez Martin
*Clase: 1ºDAM
*Practica 7.26
*Ejercicio2
*/
package ejercicio2;

import java.time.LocalDate;

public class Contacto {
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private LocalDate fechNacimiento;
	
	public Contacto(String nombre,String direccion, String telefono,String email,LocalDate fechaNacimiento) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.telefono=telefono;
		this.email=email;
		this.fechNacimiento=fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getEmail() {
		return email;
	}
	public String getFechaNacimiento() {
		return "("+fechNacimiento.getDayOfMonth()+"-"+fechNacimiento.getMonthValue()+"-"+fechNacimiento.getYear()+")";
	}
}
