package br.edu.ifrs.canoas.jee.exercicio;

public abstract class Conta implements Comparable<Conta> {

	private Integer numeroConta;
	private Integer agencia;
	private Double saldo;

	public Conta() {
		super();
	}

	public Conta(int numeroConta, int agencia) {
		this.numeroConta = numeroConta;
		this.agencia = agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	abstract boolean saca(double valor) throws LimiteUltrapassadoException;

	public boolean deposita(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Conta o) {
		if (this.saldo < o.saldo) {
			return 1;
		}
		if (this.saldo > o.saldo) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + "]";
	}
}
