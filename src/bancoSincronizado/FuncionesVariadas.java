package bancoSincronizado;

import pideDatos.PideDatos;

public class FuncionesVariadas {
	
	//CREO LISTADO DE OPERACIONES A REALIZAR. PASO EL NÚMERO DE OPERACIONES QUE HA INTRODUCIDO EL USUARIO. LOS INGRESOS EN POSITIVO Y LOS REINTEGROS EN NEGATIVO
	public static Double[] crearListaOperaciones(int cantidadOperaciones){
		
		Double arrayOperaciones[] = new Double[cantidadOperaciones];
		
		for (int i = 0; i < cantidadOperaciones; i++) {
			double cantidad = PideDatos.pideDouble("Introduzca la cantidad de la operación " + (i+1) + " a ingresar / reintegrar (con signo -): \n");
			if(cantidad < 0) {
				arrayOperaciones[i] = cantidad;
			}else {
				arrayOperaciones[i] = cantidad;
			}
		}
		
		return arrayOperaciones;
	}
	
	//LISTO POR PANTALLA EL LISTADO DE OPERACIONES CREADO. AÑADIENDO INGRESO SI ES POSITIVO Y REINTEGRO SI ES NEGATIVO
	public static void listarOperaciones(Double[] arrayOperaciones) {
		
		System.out.println("A continuación se detallan las operaciones a realizar: \n");
		for(int i = 0; i < arrayOperaciones.length; i++){
			if(arrayOperaciones[i] < 0) {
				System.out.println("Operación " + i + "; Reintegro cantidad de: " + arrayOperaciones[i] + " €.\n");
			}else {
				System.out.println("Operación " + i + "; Ingreso cantidad de: " + arrayOperaciones[i] + " €.\n");
			}
		}
	}
	
	

}
