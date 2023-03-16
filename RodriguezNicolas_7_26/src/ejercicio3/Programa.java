package ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		Empresa empresa=new Empresa();
		//atributos del menu(switch) y los exception
		boolean flag=true;
		int menu=0;
		do {
			while(flag) {
				try {
					flag=false;
					System.out.println("Dime que operacion quieres realizar:\n1-Añadir trabajador: \n2-Saber la cantidad de trabajadores masculinos\n3-Cantidad de trabajadoras casadas\n4-Total salarios\n0-Para salir");
					menu=input.nextInt();
					input.nextLine();
				}
				catch(InputMismatchException e){
					input.nextLine();
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
					empresa.nuevoTrabajador(annadirEmpleado());
					break;
				}case 2:{
					System.out.println("\nHay "+empresa.cantidadTrabajadoresHombre()+" trabajadores masculinos\n");
					break;
				}case 3:{
					System.out.println("\nHay "+empresa.cantidadTrabajadorasCasadas()+" trabajadoras casadas\n");
					break;
				}case 4:{
					System.out.println("\nEl salario total de todos los empleados es de: "+empresa.totalSalarios()+"\n");
					break;
				}
				default:{
					System.out.println("\nNUMERO ERRONEO\n");
					break;
				}
			}
		}while(menu!=0);
	}
	//Metodo que pide informacion del trabajador y devuelve el trabajador ya creado
	public static Trabajador annadirEmpleado() {
		Scanner input=new Scanner(System.in);
		boolean flag=true;
		//atributos del trabajador
		boolean sexo = false;
		String nombre = null,estadoCivil = null,genero=null;
		int edad=0,salario=0;
		
		while(flag) {
			try {
				flag=false;
				System.out.println("Dime como se llama el trabajador:");
				nombre=input.nextLine();
				System.out.println("Dime la edad del trabajador");
				edad=input.nextInt();
				input.nextLine();
				System.out.println("Dime el salario que cobra:");
				salario=input.nextInt();
				input.nextLine();
				System.out.println("Dime el sexo:");
				genero=input.nextLine();
				sexo=dimeGenero(genero);
				System.out.println("Dime su estado civil(solter@,divorciad@,casad@,viud@):");
				estadoCivil=input.nextLine();
				estadoCivil=dimeEstadoCivil(estadoCivil);
				
				
			}catch(InputMismatchException e){
				flag=true;
				System.out.println("\nIntrodujo mal la informacion, vuelva a introducirlo\n");
				input.nextLine();//Refresca bufer
			}
		}
		Trabajador nuevoEmpleado=new Trabajador(nombre,edad,sexo,estadoCivil,salario);
		return nuevoEmpleado;
		
	}
	//Metodo para comprobar que el genero está bien escrito
	private static boolean dimeGenero(String caracterSx) {
        Scanner input = new Scanner(System.in);
        switch (caracterSx) {
            case "H": {
                return true;
            }
            case "M": {
                return false;
            }
            default : {
                System.out.println("\nIntroduzca bien el sexo(H o M)\n");
                //Aqui uso recursividad por optimizacion
                return dimeGenero(input.nextLine());
            }
        }
    }
	//Metodo para comprobar que el estado civil está bien escrito
	private static String dimeEstadoCivil(String estadoCivil) {
        Scanner input = new Scanner(System.in);
	        	switch (estadoCivil) {
	            case "soltero":
	            case "divorciado": 
	            case "casado":
	            case "viudo":
	            case "soltera":
	            case "divorciada":
	            case "casada":
	            case "viuda":{
	            	return estadoCivil;
	            }
	            default : {
	                System.out.println("\nIntroduzca bien el estado civil(solter@,divorciad@,casad@,viud@)\n");
	                //Aqui uso recursividad por optimizacion
	                return dimeEstadoCivil(input.nextLine());
	            }
        	}
        
    }
		
		
}


