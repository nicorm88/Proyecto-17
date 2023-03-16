/*
*Nombre: Nicolas Rodriguez Martin
*Clase: 1ºDAM
*Practica 7.26
*Ejercicio2
*/
package ejercicio2;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner info=new Scanner(System.in);
		Agenda contactos=new Agenda();
		//atributos del menu(switch) y los exception
		boolean flag=true;
		int menu=0;
		//atributo que se va a usar para buscar el contacto
		String nombre;
		//Atributos del localdate
		int dia,mes,anno;
		
		do {
			while(flag) {
				try {
					flag=false;
					System.out.println("Dime que operacion quieres realizar:\n1-Anadir contacto\n2-Consultar informacion mediante un nombre\n3-Mostrar la informacion de toda la agenda\n4-Consultar informacion mediante un cumpleaños\n0-Para salir");
					menu=info.nextInt();
					info.nextLine();
				}
				catch(InputMismatchException e){
					info.nextLine();
					flag=true;
					System.out.println("\nPor favor introduzca un numero entero\n");
				}
			}
			//Para que vuelva a entrar despues del switch
			flag=true;
			
			switch(menu) {
				case 0:{
					System.out.println("\nSalio del programa");
					break;
				}case 1:{
					contactos.nuevoContacto(annadirContacto());
					break;
				}case 2:{
					System.out.println("\nDime el nombre del contacto que buscas: ");
					nombre=info.nextLine();
					System.out.println("\n"+contactos.toString(nombre)+"\n");
					break;
				}case 3:{
					System.out.println(contactos.toString());
					break;
				}case 4:{
					System.out.println("Dime el dia de su cumple:");
					dia=info.nextInt();
					System.out.println("Dime el mes de su cumple en un entero:");
					mes=info.nextInt();
					System.out.println("Dime el año de su cumple:");
					anno=info.nextInt();
					System.out.println(contactos.mostrarCumpleañero(LocalDate.of(anno, mes, dia)));
					break;
				}default:{
					System.out.println("\nNUMERO ERRONEO\n");
					break;
				}
			}
		}while(menu!=0);
	}
	//Metodo que pide informacion del contacto y devuelve el contacto ya creado
	public static Contacto annadirContacto() {
		Scanner info=new Scanner(System.in);
		boolean flag=true;
		//atributos del contacto
		String nombre = null,direccion = null,telefono = null,email = null;
		//Atributos del localdate
		int dia=0,mes=0,anno=0;
		
		while(flag) {
			try {
				flag=false;
				System.out.println("Dime como se llama el contacto:");
				nombre=info.nextLine();
				System.out.println("Dime su direccion:");
				direccion=info.nextLine();
				System.out.println("Dime su telefono:");
				telefono=info.nextLine();
				System.out.println("Dime su email:");
				email=info.nextLine();
				System.out.println("Dime el dia de su cumple:");
				dia=info.nextInt();
				System.out.println("Dime el mes de su cumple en un entero:");
				mes=info.nextInt();
				System.out.println("Dime el año de su cumple:");
				anno=info.nextInt();
			}catch(InputMismatchException e){
				flag=true;
				System.out.println("\nIntrodujo mal la fecha de nacimiento, vuelva a introducirlo\n");
				info.nextLine();
			}
		}
		Contacto nuevoContacto=new Contacto(nombre,direccion,telefono,email,(LocalDate.of(anno, mes, dia)));
		return nuevoContacto;
		
	}

}
