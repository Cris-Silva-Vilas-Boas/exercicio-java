package br.edu.ifrs.canoas.jee.exercicio;
import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

public class TesteConta {
	ContaCorrente conta1;
	ContaCorrente conta2;
	ContaCorrente conta3;

	ContaPoupanca conta4;
	ContaPoupanca conta5;
	ContaPoupanca conta6;

	@Before
	public void setup() {
		conta1 = new ContaCorrente();
		conta2 = new ContaCorrente();
		conta3 = new ContaCorrente();

		conta4 = new ContaPoupanca();
		conta5 = new ContaPoupanca();
		conta6 = new ContaPoupanca();
	}

	@Test
	public void testDeposita() {

		// Conta corrente
		conta1.setSaldo(50);
		conta1.deposita(10);
		// 1
		assertThat(conta1.getSaldo()).isEqualTo(60);
		// 2
		assertThat(conta1.deposita(-1)).isEqualTo(false);
		// 3
		assertThat(conta1.deposita(-2)).isNotEqualTo(true);

		// Conta Poupança
		conta4.setSaldo(40);
		conta4.deposita(10);
		// 1
		assertThat(conta4.getSaldo()).isEqualTo(50);
		// 2
		assertThat(conta4.deposita(-1)).isEqualTo(false);
		// 3
		assertThat(conta4.deposita(-2)).isNotEqualTo(true);
	}

	@Test
	public void testSaca() throws LimiteUltrapassadoException {

		// Conta corrente
		conta1.setSaldo(50);
		conta1.saca(10);
		// 1
		assertThat(conta1.getSaldo()).isEqualTo(40);
		// 2
		try {
			conta1.saca(-10);
		} catch (LimiteUltrapassadoException e) {
			assertThat(e).isInstanceOf(RuntimeException.class);
			System.out.println("Valor inválido");
		}
		// 3
		try {
			conta1.saca(600);
		} catch (LimiteUltrapassadoException e) {
			assertThat(e).isInstanceOf(RuntimeException.class);
			System.out.println("Saque indisponível");
		}
		
		// Conta Poupança
		conta4.setSaldo(80);
		conta4.saca(20);
		// 1
		assertThat(conta4.getSaldo()).isEqualTo(60);
		// 2
		try {
			conta4.saca(-2);
		} catch (LimiteUltrapassadoException e) {
			assertThat(e).isInstanceOf(RuntimeException.class);
			System.out.println("Valor inválido");
		}
		// 3
		try {
			conta4.saca(800);
		} catch (LimiteUltrapassadoException e) {
			assertThat(e).isInstanceOf(RuntimeException.class);
			System.out.println("Saque indisponível");
		}
	}

	@Test
	public void testeGetSaldo() throws LimiteUltrapassadoException {
		conta1.setSaldo(100);
		conta2.setSaldo(200);
		conta1.deposita(10);

		// Coonta Corrente
		// 1
		assertThat(conta1.getSaldo()).isEqualTo(110);
		conta1.saca(10);
		// 2
		assertThat(conta1.getSaldo()).isEqualTo(100);
		// 3
		assertThat(conta1.getSaldo()).isNotEqualTo(conta2.getSaldo());

		// Conta Poupança
		conta4.setSaldo(100);
		conta5.setSaldo(200);
		conta4.deposita(10);
		// 1
		assertThat(conta4.getSaldo()).isEqualTo(110);
		conta4.saca(10);
		// 2
		assertThat(conta4.getSaldo()).isEqualTo(100);
		// 3
		assertThat(conta4.getSaldo()).isNotEqualTo(conta5.getSaldo());
	}

	@Test
	public void testeCompareTo() {
		conta1.setSaldo(200);
		conta2.setSaldo(250);
		// 1
		assertThat(conta1.compareTo(conta2)).isEqualTo(1);
		assertThat(conta2.compareTo(conta1)).isEqualTo(-1);
	}
}
