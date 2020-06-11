import static org.junit.Assert.*;

import org.junit.Test;

import uninorte.poo.frota.dao.CarroDao;
import uninorte.poo.frota.modelo.Carro;

public class TestaCarro {

	@Test
	public void testaCrud() {
		
		Carro c1 = new Carro();
		c1.setPlaca("aa111");
		c1.setModelo("fiat uno");
		
		Carro c2 = new Carro();
		c2.setPlaca("bb222");
		c2.setCor("amarelo");
		
		CarroDao dao = new CarroDao();
		dao.cadastra(c1);
		System.out.println(dao.recuperaTodos().toString());
		
		dao.cadastra(c2);
		System.out.println(dao.recuperaTodos().toString());
	}

}
