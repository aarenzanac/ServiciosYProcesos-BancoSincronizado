package bancoSincronizado;

public class CuentaCorriente{
	private String nombre;
	private String numero;
	private Double saldo;
	private boolean haySaldo;
	
	CuentaCorriente(){}

	public CuentaCorriente(String nombre, String numero, Double saldo) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.saldo = saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [Nombre del titular: " + nombre + " -- Numero de cuenta: " + numero + " -- Saldo= " + saldo + "]";
	}
	
	
	public synchronized void reintegrar(double cantidad, CuentaCorriente cuenta, boolean haySaldo ) {
		if(!haySaldo) {
			System.out.println("Pido " + cantidad + " € y hay sólo " + cuenta.getSaldo() + " €.\n");
			System.out.println("Proceso Dormido hasta que haya saldo.\n");
			System.out.println("-----------------------------\n");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {

			System.out.println("Reintegro de: " + Math.abs(cantidad) + " €.\n");
			cuenta.setSaldo(cuenta.getSaldo() + cantidad);
			System.out.println("Nuevo saldo en cuenta de: " + cuenta.getSaldo() + " €.\n");
			System.out.println("-----------------------------\n");			
		}
		
		
		
		
	}						

	
	public synchronized void ingresar(double cantidad, CuentaCorriente cuenta) {
			
		System.out.println("Ingreso de: " + cantidad + " €.\n");
		cuenta.setSaldo(cuenta.getSaldo() + cantidad);
		System.out.println("Nuevo saldo en cuenta de: " + cuenta.getSaldo() + " €.\n");
		System.out.println("-----------------------------\n");
		notifyAll();
	}
	
	
	public boolean comprobarSaldo(Double cantidad, CuentaCorriente cuenta) {
		boolean haySaldo;
		if(Math.abs(cantidad) < cuenta.getSaldo()) {
			haySaldo = true;
		}else {
			haySaldo = false;
		}
		return haySaldo;
	}
}