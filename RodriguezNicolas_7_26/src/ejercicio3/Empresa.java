/*
*Nombre: Nicolas Rodriguez Martin
*Clase: 1ºDAM
*Practica 7.26
*Ejercicio3
*/
package ejercicio3;

import java.util.ArrayList;

public class Empresa {
	private ArrayList<Trabajador> empleados;
	
	public Empresa() {
		empleados=new ArrayList();
	}
	public void nuevoTrabajador(Trabajador nuevo) {
		empleados.add(nuevo);
	}
	public int cantidadTrabajadoresHombre() {
		int hombres=0;
		for(Trabajador empleado:empleados) {
			if(empleado.getSexo()=="H") {
				hombres++;
			}
		}
		return hombres;
	}
	public int cantidadTrabajadorasCasadas() {
		int mujeresCasadas=0;
		for(Trabajador empleado:empleados) {
			if(empleado.getEstadoCivil().equalsIgnoreCase("casada")) {
				mujeresCasadas++;
			}
		}
		return mujeresCasadas;
	}
	public int totalSalarios() {
		int salarioTotal=0;
		for(Trabajador empleado:empleados) {
				salarioTotal+=empleado.getSalario();
		}
		return salarioTotal;
	}
}
