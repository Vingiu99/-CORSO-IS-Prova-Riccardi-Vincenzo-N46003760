package prova.IS.RiccardiVincenzo.Main;

import prova.IS.RiccardiVincenzo.Control.GestoreUtente;
import prova.IS.RiccardiVincenzo.Entity.Cliente;
import prova.IS.RiccardiVincenzo.Entity.Spesa;
import prova.IS.RiccardiVincenzo.Entity.SpeseDefault;

public class Main {

	public static void main(String[] args) {

		GestoreUtente control = new GestoreUtente();
		 
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
	    control.generaResoconto(SpeseDefault.getNumeroSpese());
	    control.generaResoconto(3);
		
		
	}

}
