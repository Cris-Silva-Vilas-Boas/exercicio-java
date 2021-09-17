package br.edu.ifrs.canoas.jee.exercicio;
import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

public class TesteBanco {
	
	Banco banco;
	
	@Before
	public void setup() {
		banco = new Banco();
	}
	
	@Test
	public void testOrdenacao()
	{
		ContaCorrente c1 = new ContaCorrente();
		c1.setSaldo(2);
		
		ContaCorrente c2 = new ContaCorrente();
		c2.setSaldo(3);
		
		ContaCorrente c3 = new ContaCorrente();
		c3.setSaldo(0);
		
		ContaCorrente c4 = new ContaCorrente();
		c4.setSaldo(8);
		
		banco.getCarteiraContas().put(c1, new Cliente("Cliente 1"));
		banco.getCarteiraContas().put(c2, new Cliente("Cliente 2"));
		banco.getCarteiraContas().put(c3, new Cliente("Cliente 3"));
		
		//1
		assertThat(banco.getContasOrdenadas()).hasSize(3).contains(c1, c2, c3);
		//2
		assertThat(banco.getContasOrdenadas().get(1)).isEqualByComparingTo(c1);
		//3 
		assertThat(banco.getContasOrdenadas()).contains(c1, atIndex(1));
		//4
		assertThat(banco.getContasOrdenadas()).isNotEmpty().hasSize(3);
		//5
		assertThat(banco.getContasOrdenadas()).contains(c1,c2,c3);
		//6
		assertThat(banco.getCarteiraContas()).doesNotContainKeys(c4);
	}
}
