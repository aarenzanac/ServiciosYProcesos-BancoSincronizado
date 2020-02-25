package bancoSincronizado;

public class CuentaCorriente {
	private String nombre;
	private String numero;
	private Double saldo;
	
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
	
	
}
