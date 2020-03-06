package bancoSincronizado;


import pideDatos.PideDatos;

public class BancoSincronizado {

	public static void main(String[] args) throws InterruptedException {
		
		//CREO LA CUENTA CORRIENTE
		CuentaCorriente cuenta = new CuentaCorriente("Alejandro Arenzana", "0081-0343-12-1234567890", 10.00);
		System.out.println(cuenta.toString() + "\n");
		System.out.println("-----------------------------\n");
		
		//PIDO AL USUARIO LA CANTIDAD DE OPERACIONES A REALIZAR	
		int cantidadOperaciones = PideDatos.pideEntero("Introduzca el número de operaciones a realizar: \n");
		System.out.println("Ha elegido crear " + cantidadOperaciones + " operaciones.\n");
		
		//CREO UNA LISTA DE OPERACIONES EN FUNCIÓN DE INGRESAR O SACAR DINERO CON SIGNO NEGATIVO
		Double[] arrayOperaciones = FuncionesVariadas.crearListaOperaciones(cantidadOperaciones);
		
		System.out.println("-----------------------------\n");
		
		//MUESTRO EL LISTADO DE OPERACIONES
		FuncionesVariadas.listarOperaciones(arrayOperaciones);
				
		//MUESTRO EL SALDO INICIAL DE LA CUENTA CREADA EN LAS PRIMERAS LINEAS		
		System.out.println("Saldo inicial de la cuenta = " + cuenta.getSaldo() + "€.\n");
		
		System.out.println("-----------------------------\n");
		
		//CREACIÓN DE TANTOS PROCESOS COMO OPERACIONES HAY EN EL LISTADO		
		for (int i = 0; i < cantidadOperaciones; i++){
            OperacionesBanco ob = new OperacionesBanco(arrayOperaciones[i], cuenta);
            ob.start();
            ob.sleep(5000);
                        
        }
		System.out.println("Fin de las operaciones.\n");
	}
}