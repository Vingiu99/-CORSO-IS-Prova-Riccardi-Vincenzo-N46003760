package prova.IS.RiccardiVincenzo.Main;

import prova.IS.RiccardiVincenzo.Control.GestoreUtente;
import prova.IS.RiccardiVincenzo.Entity.Cliente;
import prova.IS.RiccardiVincenzo.Entity.ClienteAbituale;
import prova.IS.RiccardiVincenzo.Entity.Spesa;

public class Main {

	public static void main(String[] args) {

		GestoreUtente control = new GestoreUtente();
		
		Spesa s1 = new Spesa(1,16);
		Spesa s2 = new Spesa(2,5.36);
		Cliente c1 = new Cliente("PeppOStuort","",null);
		control.pagaSpesa(s1,c1);
		control.pagaSpesa(s2, c1);
		Spesa s3 = new Spesa(5,16);
		Cliente c2 = new Cliente("Pat't annur","",null);
		control.pagaSpesa(s3, c2);
		control.addCliente(c1);
		control.addCliente(c2);
		ClienteAbituale c3 = new ClienteAbituale("Zit't ca scocc","",null);
		control.addCliente(c3);
		control.pagaSpesa(s1, c3);
		control.pagaSpesa(s2, c3);
		control.pagaSpesa(s3, c3);
		control.generaResocontoClasseAusiliaria();
		control.generaResocontoClientiAbituali();
		control.generaResocontoConValore(1);
		
		
	}

}
