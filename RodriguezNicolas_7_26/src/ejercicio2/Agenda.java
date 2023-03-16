/*
*Nombre: Nicolas Rodriguez Martin
*Clase: 1ºDAM
*Practica 7.26
*Ejercicio2
*/
package ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Agenda {
	private ArrayList<Contacto> contactos;
	
	public Agenda() {
		contactos=new ArrayList();
	}
	public void nuevoContacto(Contacto nuevoContacto) {
		contactos.add(nuevoContacto);
	}
	//Metodo para imprimir toda la inforrmacion del contacto que se busca por nombre
	public String toString(String nombre) {
		String infoContacto="";
		//Compruebo si el arraylist esta vacio
		if(contactos.size()==0) {
			infoContacto+="\nLa agenda esta vacia\n";
		}else {
			for(Contacto contacto:contactos) {
				//Llamo al metodo compareTo que me compara String y si es igual le paso la informacion
				if(compareTo(contacto.getNombre(),nombre)==1) {
					infoContacto+="Informacion del contacto ("+contacto.getNombre()+")\nDireccion: "+contacto.getDireccion()+"\nTelefono: "+contacto.getTelefono()+"\nEmail: "+contacto.getEmail()+"\nFecha de nacimiento: "+contacto.getFechaNacimiento();
				}
			}
		}
		return infoContacto;
	}
	//Metodo para imprimir toda la inforrmacion de la agenda
	public String toString() {
		String infoAgenda="";
		if(contactos.size()==0) {
			infoAgenda+="\nLa agenda esta vacia\n";
		}else {
			for(Contacto contacto:contactos) {
					infoAgenda+="\nInformacion del contacto ("+contacto.getNombre()+")\nDireccion: "+contacto.getDireccion()+"\nTelefono: "+contacto.getTelefono()+"\nEmail: "+contacto.getEmail()+"\nFecha de nacimiento: "+contacto.getFechaNacimiento()+"\n";
			}
		}
		return infoAgenda;
	}
	//Compara los dos nombres caracter por caracter y devuelve 1 si es igual y un cero si es diferente
	public int compareTo(String nombreContacto,String nombreBusqueda) {
		int contador=0;
		if(nombreContacto.length()==nombreBusqueda.length()) {
			for(int i=0;i<nombreContacto.length();i++) {
				if(nombreContacto.charAt(i)==nombreBusqueda.charAt(i)) {
					contador++;
				}
			}
			if(contador==nombreContacto.length()) {
				return 1;
			}else {
				return 0;
			}
		}else {
			return 0;
		}
		
	}
	//Metodo para imprimir toda la inforrmacion del contacto que se busca por cumpleaños
	public String mostrarCumpleañero(LocalDate fechaCumple) {
		String infoContacto="";
		if(contactos.size()==0) {
			infoContacto+="\nLa agenda esta vacia\n";
		}else {
			for(Contacto contacto:contactos) {
				if(esCumple(contacto.getFechaNacimiento(),fechaCumple)==1) {
					infoContacto+="\nInformacion del contacto ("+contacto.getNombre()+")\nDireccion: "+contacto.getDireccion()+"\nTelefono: "+contacto.getTelefono()+"\nEmail: "+contacto.getEmail()+"\nFecha de nacimiento: "+contacto.getFechaNacimiento()+"\n";
				}
			}
		}
		return infoContacto;
	}
	//Pasa a String la fecha que se busca para compararla con la fecha del contacto mediante el compareTo
	public int esCumple(String cumpleContacto,LocalDate fechaCumple) {
		String fechaCumpl="("+fechaCumple.getDayOfMonth()+"-"+fechaCumple.getMonthValue()+"-"+fechaCumple.getYear()+")";
		if(compareTo(cumpleContacto,fechaCumpl)==1) {
			return 1;
		}else {
			return 0;
		}
	}
}
