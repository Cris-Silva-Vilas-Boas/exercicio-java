package br.edu.ifrs.canoas.jee.exercicio;

public class LimiteUltrapassadoException extends RuntimeException {

	public LimiteUltrapassadoException(double valor) {
		System.out.println(valor);
	}

}
