package prova.IS.RiccardiVincenzo.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prova.IS.RiccardiVincenzo.Control.GestoreUtente;
import prova.IS.RiccardiVincenzo.Entity.Cliente;
import prova.IS.RiccardiVincenzo.Entity.Spesa;
import prova.IS.RiccardiVincenzo.Entity.SpeseDefault;

public class GestoreUtenteTest {

	private GestoreUtente control= new GestoreUtente();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void parametroIngressoMinoreDiZero() {
		System.out.println("INIZIO TEST: parametroIngressoMinoreDiZero()\n");
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		List<Cliente> esito =control.generaResoconto(-2);
		assertNull(esito);
		System.out.println("++++FINE TEST++++\n");
	}


	@Test
	public void nessunClienteNelDB () {
		System.out.println("INIZIO TEST: nessunClienteNelDB()\n");
		List<Cliente> esito =control.generaResoconto(1);
		assertNull(esito);
		System.out.println("++++FINE TEST++++\n");
	}
	@Test
	public void nessunClienteValidoNelDB () {
		System.out.println("INIZIO TEST: nessunClienteValidoNelDB()\n");
		Cliente c1 = new Cliente("Pippo","",null);
		Spesa s1 = new Spesa(1,16);
		control.addCliente(c1);
		control.pagaSpesa(s1, c1);
		List<Cliente> esito =control.generaResoconto(3);
		assertEquals(0, esito.size());
		System.out.println("++++FINE TEST++++\n");
	}
	@Test
	public void nessunaSpesaPerClienteNelDB() {
		System.out.println("INIZIO TEST: nessunaSpesaPerClienteNelDB() \n");
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		List<Cliente> esito =control.generaResoconto(1);
		assertEquals(0, esito.size());
		System.out.println("++++FINE TEST++++\n");
	}
	@Test
	public void parametriInIngressoOutOfBound() {
		System.out.println("INIZIO TEST: parametriInIngressoOutOfBound() \n");
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		Spesa s1 = new Spesa(1,16);
		control.pagaSpesa(s1, c1);
		List<Cliente> esito =control.generaResoconto(2);
		assertEquals(0, esito.size());
		System.out.println("++++FINE TEST++++\n");
	}
	@Test
	public void ingressoDefaultClientiUnoValidiUnoSpesaMolti () {
		System.out.println("INIZIO TEST: ingressoDefaultClientiUnoValidiUnoSpesaMolti() \n");
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		Spesa s1 = new Spesa(1,16);
		Spesa s2 = new Spesa(2,5.36);
		control.pagaSpesa(s1, c1);
		control.pagaSpesa(s2, c1);
		List<Cliente> esito =control.generaResoconto(SpeseDefault.getNumeroSpese());
		double tmp = esito.get(0).getnumeroSpese();
		assertEquals(2, tmp, 0.1);
		tmp=esito.get(0).getTotaleSpeso();
		assertEquals(21.36, tmp, 0.01);
		System.out.println("++++FINE TEST++++\n");
		
	}
	@Test
	public void ingressoDefaultClientiMoltiValidiUnoSpesaMolti () {
		System.out.println("INIZIO TEST: ingressoDefaultClientiMoltiValidiUnoSpesaMolti() \n");
		Cliente c2 = new Cliente("Pluto", "", null);
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		control.addCliente(c2);
		Spesa s1 = new Spesa(1,16);
		Spesa s2 = new Spesa(2,5.36);
		control.pagaSpesa(s1, c1);
		control.pagaSpesa(s2, c1);
		List<Cliente> esito =control.generaResoconto(SpeseDefault.getNumeroSpese());
		double tmp = esito.get(0).getnumeroSpese();
		assertEquals(2, tmp, 0.1);
		tmp=esito.get(0).getTotaleSpeso();
		assertEquals(21.36, tmp, 0.01);
		System.out.println("++++FINE TEST++++\n");
		
	}
	@Test
	public void ingressoDefaultClientiMoltiValidiMoltiSpesaMolti () {
		System.out.println("INIZIO TEST: ingressoDefaultClientiMoltiValidiMoltiSpesaMolti() \n");
		Cliente c2 = new Cliente("Pluto", "", null);
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		control.addCliente(c2);
		Spesa s1 = new Spesa(1,16);
		Spesa s2 = new Spesa(2,5.36);
		control.pagaSpesa(s1, c1);
		control.pagaSpesa(s2, c1);
		Spesa s3 = new Spesa(3,5.99);
		Spesa s4 = new Spesa(4,4.99);
		Spesa s5 = new Spesa(5,12.99);
		control.pagaSpesa(s3, c2);
		control.pagaSpesa(s4, c2);
		control.pagaSpesa(s5, c2);
		List<Cliente> esito =control.generaResoconto(SpeseDefault.getNumeroSpese());
		double tmp = esito.get(0).getnumeroSpese();
		assertEquals(2, tmp, 0.1);
		tmp=esito.get(0).getTotaleSpeso();
		assertEquals(21.36, tmp, 0.01);
		tmp=esito.get(1).getnumeroSpese();
		assertEquals(3, tmp, 0.1);
		tmp=esito.get(1).getTotaleSpeso();
		assertEquals(23.97, tmp, 0.01);
		System.out.println("++++FINE TEST++++\n");
		
	}
	@Test
	public void ingressoValidoClientiUnoValidiUnoSpesaUno() {
		System.out.println("INIZIO TEST: ingressoValidoClientiUnoValidiUnoSpesaUno() \n");
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		Spesa s1 = new Spesa(1,16);
		control.pagaSpesa(s1, c1);
		List<Cliente> esito =control.generaResoconto(1);
		double tmp = esito.get(0).getnumeroSpese();
		assertEquals(1, tmp, 0.1);
		tmp=esito.get(0).getTotaleSpeso();
		assertEquals(16, tmp, 0.01);
		System.out.println("++++FINE TEST++++\n");
	}
	@Test
	public void ingressoValidoClientiUnoValidiUnoSpesaMolti () {
		System.out.println("INIZIO TEST: ingressoValidoClientiUnoValidiUnoSpesaMolti() \n");
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		Spesa s1 = new Spesa(1,16);
		Spesa s2 = new Spesa(2,5.36);
		Spesa s3 = new Spesa(3,5.99);
		control.pagaSpesa(s1, c1);
		control.pagaSpesa(s2, c1);
		control.pagaSpesa(s3, c1);
		List<Cliente> esito =control.generaResoconto(3);
		double tmp = esito.get(0).getnumeroSpese();
		assertEquals(3, tmp, 0.1);
		tmp=esito.get(0).getTotaleSpeso();
		assertEquals(27.35, tmp, 0.01);
		System.out.println("++++FINE TEST++++\n");
	}
	
	@Test
	public void ingressoValidoClientiMoltiValidiUnoSpesaUno() {
		System.out.println("INIZIO TEST: ingressoValidoClientiMoltiValidiUnoSpesaUno() \n");
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		Spesa s1 = new Spesa(1,16);
		control.pagaSpesa(s1, c1);
		Cliente c2 = new Cliente("Pluto", "", null);
		control.addCliente(c2);
		List<Cliente> esito =control.generaResoconto(1);
		double tmp = esito.get(0).getnumeroSpese();
		assertEquals(1, tmp, 0.1);
		tmp=esito.get(0).getTotaleSpeso();
		assertEquals(16, tmp, 0.01);
		System.out.println("++++FINE TEST++++\n");
	}
	@Test
	public void ingressoValidoClientiMoltiValidiUnoSpesaMolti() {
		System.out.println("INIZIO TEST: ingressoValidoClientiMoltiValidiUnoSpesaMolti() \n");
		Cliente c2 = new Cliente("Pluto", "", null);
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		control.addCliente(c2);
		Spesa s1 = new Spesa(1,16);
		Spesa s2 = new Spesa(2,5.36);
		control.pagaSpesa(s1, c1);
		control.pagaSpesa(s2, c1);
		Spesa s3 = new Spesa(3,5.99);
		Spesa s4 = new Spesa(4,4.99);
		Spesa s5 = new Spesa(5,12.99);
		control.pagaSpesa(s3, c2);
		control.pagaSpesa(s4, c2);
		control.pagaSpesa(s5, c2);
		List<Cliente> esito =control.generaResoconto(3);
		double tmp =esito.get(0).getnumeroSpese();
		assertEquals(3, tmp, 0.1);
		tmp=esito.get(0).getTotaleSpeso();
		assertEquals(23.97, tmp, 0.01);
		System.out.println("++++FINE TEST++++\n");
}
	@Test
	public void ingressoValidoClientiMoltiValidiMoltiSpesaUno() {
		System.out.println("INIZIO TEST: ingressoValidoClientiMoltiValidiMoltiSpesaUno() \n");
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		Spesa s1 = new Spesa(1,16);
		control.pagaSpesa(s1, c1);
		Cliente c2 = new Cliente("Pluto", "", null);
		control.addCliente(c2);
		List<Cliente> esito =control.generaResoconto(0);
		double tmp = esito.get(0).getnumeroSpese();
		assertEquals(1, tmp, 0.1);
		tmp=esito.get(0).getTotaleSpeso();
		assertEquals(16, tmp, 0.01);
		tmp=esito.get(1).getnumeroSpese();
		assertEquals(0, tmp, 0.1);
		tmp=esito.get(1).getTotaleSpeso();
		assertEquals(0, tmp, 0.01);
		System.out.println("++++FINE TEST++++\n");

	}
	@Test
	public void ingressoValidoClientiMoltiValidiMoltiSpesaMolti () {
		System.out.println("INIZIO TEST: ingressoValidoClientiMoltiValidiMoltiSpesaMolti() \n");
		Cliente c2 = new Cliente("Pluto", "", null);
		Cliente c1 = new Cliente("Pippo","",null);
		control.addCliente(c1);
		control.addCliente(c2);
		Spesa s1 = new Spesa(1,16);
		Spesa s2 = new Spesa(2,5.36);
		Spesa s3 = new Spesa(3,8.01);
		control.pagaSpesa(s1, c1);
		control.pagaSpesa(s2, c1);
		control.pagaSpesa(s3, c1);
		Spesa s4 = new Spesa(4,5.99);
		Spesa s5 = new Spesa(5,4.99);
		Spesa s6 = new Spesa(6,12.99);
		control.pagaSpesa(s4, c2);
		control.pagaSpesa(s5, c2);
		control.pagaSpesa(s6, c2);
		List<Cliente> esito =control.generaResoconto(3);
		double tmp =esito.get(0).getnumeroSpese();
		assertEquals(3, tmp, 0.1);
		tmp=esito.get(0).getTotaleSpeso();
		assertEquals(29.37, tmp, 0.01);
		tmp =esito.get(1).getnumeroSpese();
		assertEquals(3, tmp, 0.1);
		tmp=esito.get(1).getTotaleSpeso();
		assertEquals(23.97, tmp, 0.01);
		System.out.println("++++FINE TEST++++\n");
	}

//	@Test
//	public void parametroIngressoNonValido() {
//	
//		System.out.println("TEST parametroIngressoNonValido\n");
//		List<Cliente> esito =control.generaResoconto();
//		assertNull(esito);
//	}
	
}
