package bancoSincronizado;

public class OperacionesBanco extends Thread{
	
	private Thread t;
	private Double cantidad;
	private CuentaCorriente cuenta;
	
	
	
	OperacionesBanco(Double cantidad, CuentaCorriente cuenta){
		this.cantidad = cantidad;
		this.cuenta = cuenta;
	}
	
	public void run() {
				
		if(cantidad < 0) {
			System.out.println("Reintegro de: " + Math.abs(cantidad) + " €.\n");
			System.out.println("-----------------------------\n");
			if(this.cuenta.getSaldo() < Math.abs(cantidad)) {
				System.out.println("Proceso Dormido hasta que haya saldo.\n");
				System.out.println("-----------------------------\n");
				do {try {					
						Thread.sleep(50);
					}catch (InterruptedException e) {
						System.out.println("Error " + e.getMessage());
						e.printStackTrace();
					}
				}while(this.cuenta.getSaldo() < Math.abs(cantidad));
				
			}else {
					this.cuenta.setSaldo(this.cuenta.getSaldo() + cantidad);
					System.out.println("Nuevo saldo en cuenta de: " + this.cuenta.getSaldo() + " €.\n");
					
			}						
		}else {
			System.out.println("Ingreso de: " + cantidad + " €.\n");
			System.out.println("-----------------------------\n");
			
			this.cuenta.setSaldo(this.cuenta.getSaldo() + cantidad);
			System.out.println("Nuevo saldo en cuenta de: " + this.cuenta.getSaldo() + " €.\n");
				
		}
	}
}
