package br.edu.ifrs.canoas.jee.exercicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
	private Map<Conta, Cliente> carteiraContas = new HashMap<>();
	public List<Conta> getContasOrdenadas() {
		
		List<Conta> contas = new ArrayList<>();

		for (Map.Entry<Conta, Cliente> conta : carteiraContas.entrySet()) {
			contas.add(conta.getKey());
		}
		Collections.sort(contas);
		return contas;
	}

	public Map<Conta, Cliente> getCarteiraContas() {
		return carteiraContas;
	}
}
