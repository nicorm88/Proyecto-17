/*
*Nombre: Nicolas Rodriguez Martin
*Clase: 1ºDAM
*Practica 7.26
*Ejercicio3
*/
package ejercicio3;

public class Trabajador {
	private String nombre;
	private int edad;
	private boolean sexo;
	private String estadoCivil;
	private int salarioBase;
	
	public Trabajador(String nombre,int edad,boolean sexo,String estadoCivil,int salarioBase) {
		this.nombre=nombre;
		this.edad=edad;
		this.sexo=sexo;
		this.estadoCivil=estadoCivil;
		this.salarioBase=salarioBase;
	}
	public String getSexo() {
		if(sexo==true) {
			return "H";
		}else {
			return "M";
		}
	}
	public int getSalario() {
		return salarioBase;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
}
