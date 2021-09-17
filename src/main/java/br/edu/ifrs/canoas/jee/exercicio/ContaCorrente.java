package br.edu.ifrs.canoas.jee.exercicio;

public class ContaCorrente extends Conta {

	@Override
	boolean saca(double valor) throws LimiteUltrapassadoException {
		
		if(valor <= 0)
		{
			throw new LimiteUltrapassadoException(valor);
		}
		else
		{
			if(valor>super.getSaldo())
			{
				throw new LimiteUltrapassadoException(valor);
			}
			else
			{
				this.setSaldo(this.getSaldo() - valor);
				return true;
			}
		}

	}
}
