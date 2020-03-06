package bancoSincronizado;

public class OperacionesBanco extends Thread{
	
	private Double cantidad;
	private CuentaCorriente cuenta;
	private boolean haySaldo = false;
	
	
	OperacionesBanco(Double cantidad, CuentaCorriente cuenta){
		this.cantidad = cantidad;
		this.cuenta = cuenta;
	}
	
		
	public void run() {
		
		if(cantidad < 0) {
			do{
				haySaldo = cuenta.comprobarSaldo(cantidad, cuenta);
				cuenta.reintegrar(cantidad, cuenta, haySaldo);
				
			}while(!haySaldo);
			
		}else{
			cuenta.ingresar(cantidad, cuenta);
		}			
		
	}
}