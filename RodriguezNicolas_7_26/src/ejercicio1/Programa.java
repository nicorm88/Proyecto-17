package ejercicio1;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Atleta> equipo=new ArrayList();
		Scanner info=new Scanner(System.in);
		String nombre;
		int edad,menu = 0;
		double altura;
		//Con la que vamos a controlar las excepciones 
		boolean flag = true;
		int sumadorEdad=0,mayoresDeEdad=0,menoresDeEdad = 0;
		double sumadorAltura=0;
		do {
			while(flag) {
				try {
					flag=false;
					System.out.println("Dime que operacion quieres realizar:\n1-Anadir atleta a la lista\n2-Calcular promedio edad y altura\n3-Saber cuantos son menores de edad y mayores de edad\n4-Saber los nombres de los mas altos que el promedio\n0-Para salir");
					menu=info.nextInt();
					info.nextLine();
				}
				catch(InputMismatchException e){
					info.nextLine();
					flag=true;
					System.out.println("\nPor favot inttroduzca un numero entero\n");
				}
			}
			//Para que vuelva a entrar despues del switch
			flag=true;
			
			switch(menu) {
				case 0:{
					System.out.println("\nSalio del programa");
					break;
				}case 1:{
					while(flag) {
						try {
							flag=false;
							System.out.println("Dime como se llama el atleta");
							nombre=info.nextLine();
							System.out.println("Dime su edad");
							edad=info.nextInt();
							System.out.println("Dime su altura(Formato: 1,8):");
							altura=info.nextDouble();
							Atleta nuevo=new Atleta(nombre,edad,altura);
							equipo.add(nuevo);
						}catch(InputMismatchException e){
							flag=true;
							System.out.println("\nIntrodujo mal la edad o la altura, vuelva a introducirlo\n");
							info.nextLine();
						}
					}
					flag=true;//Para que vuelva a entrar si quieren añadir otro atleta
					break;
				}case 2:{
					sumadorEdad=0;
					sumadorAltura=0;
					if(equipo.isEmpty()==true) {
						System.out.println("\nNo hay atletas\n");
					}else {
						for(Atleta miembro:equipo) {
							sumadorEdad+=miembro.getEdad();
							sumadorAltura+=miembro.getAltura();
						}
						sumadorEdad/=equipo.size();
						sumadorAltura/=(double)equipo.size();
						System.out.println("\nPromedio de edad: "+sumadorEdad+"\nPromedio de altura: "+sumadorAltura+"\n");
					}
					break;
				}case 3:{
					sumadorEdad=0;
					sumadorAltura=0;
					if(equipo.isEmpty()==false) {
						for(Atleta miembro:equipo) {
							if(miembro.getEdad()<18) {
								menoresDeEdad++;
							}else {
								mayoresDeEdad++;
							}
						}
						System.out.println("\nMayores de edad son: "+mayoresDeEdad+"\nMenores de edad son: "+menoresDeEdad+"\n");
					}else {
						System.out.println("\nNo hay atletas\n");
					}
					break;
				}case 4:{
					sumadorEdad=0;
					sumadorAltura=0;
					if(equipo.isEmpty()==false) {
						for(Atleta miembro:equipo) {
							sumadorAltura+=miembro.getAltura();
						}
						System.out.println("\nLos mas altos de todos los atletas son: ");
						for(Atleta miembro:equipo) {
							if(miembro.getAltura()>(sumadorAltura/(double)equipo.size())) {
								System.out.println("-"+miembro.getNombre());
							}
						}
						System.out.println();
					}else {
						System.out.println("\nNo hay atletas\n");
					}
					break;
				}default:{
					System.out.println("\nNUMERO ERRONEO\n");
					break;
				}
			}
		}while(menu!=0);
	}
}
