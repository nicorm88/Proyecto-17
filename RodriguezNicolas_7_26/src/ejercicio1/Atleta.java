/*
*Nombre: Nicolas Rodriguez Martin
*Clase: 1ºDAM
*Practica 7.26
*Ejercicio1
*/
package ejercicio1;

public class Atleta {
	private String nombre;
	private int edad;
	private double altura;
	
	public Atleta(String nombre, int edad, double altura) {
		this.nombre=nombre;
		this.edad=edad;
		this.altura=altura;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public double getAltura() {
		return altura;
	}
}
