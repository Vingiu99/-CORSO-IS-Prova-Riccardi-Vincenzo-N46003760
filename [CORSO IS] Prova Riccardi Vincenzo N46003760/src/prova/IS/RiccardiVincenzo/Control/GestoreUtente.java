package prova.IS.RiccardiVincenzo.Control;

import java.util.*;

import prova.IS.RiccardiVincenzo.Entity.Cliente;
import prova.IS.RiccardiVincenzo.Entity.ClienteAbituale;
import prova.IS.RiccardiVincenzo.Entity.SpesePerAbituale;
import prova.IS.RiccardiVincenzo.Entity.Spesa;

public class GestoreUtente {

	private List<Cliente> clienti = new ArrayList<Cliente>();
	
	
	public void addCliente(Cliente c) {
		this.clienti.add(c);
	}
	public void pagaSpesa(Spesa spesa, Cliente cliente) {
		
		List <Spesa> spese = cliente.getStoricoSpese();
		spese.add(spesa);
		cliente.setStoricoSpese(spese);
		
		
	}
	
	public List<Cliente> generaResocontoClasseAusiliaria() {

		if (this.clienti.size() <= 0) {

			System.out.println("Non sono presenti clienti nel sistema \n ");

			return null;
		} else {
			
			System.out.println("I clienti (PROVA Classe Ausiliaria) che hanno conseguito almeno "+ SpesePerAbituale.getNumeroSpese()+ " acquisti sono :");
			
			List<Cliente> clientiSelezionati = new ArrayList<Cliente>();

			for (Iterator<Cliente> iterator = this.clienti.iterator(); iterator.hasNext();) {
				Cliente cliente = (Cliente) iterator.next();

				if (cliente.getnumeroSpese() >= SpesePerAbituale.getNumeroSpese()) {
					double help = cliente.getTotaleSpeso();
					System.out.println("L'utente " + cliente.getNomeUtente() + " ha coseguito "
							+ cliente.getnumeroSpese() + " acquisti, spendendo in euro " + help + "\n");
					clientiSelezionati.add(cliente);
				}

			}

			if (clientiSelezionati.size() <= 0) {
				System.out.println(
						"Nessun cliente ha conseguito più di " + SpesePerAbituale.getNumeroSpese() + " acquisti \n");
				return null;
			} else {

				return clientiSelezionati;
			}

		}

	}

	

	public List<Cliente> generaResocontoClientiAbituali() {

		if (this.clienti.size() <= 0) {

			System.out.println("Non sono presenti clienti nel sistema \n ");

			return null;
		} else {

			List<Cliente> clientiSelezionati = new ArrayList<Cliente>();

			System.out.println("I clienti (PROVA INSTANCEOF) che hanno conseguito almeno "+ SpesePerAbituale.getNumeroSpese()+ " acquisti sono :");
			for (Iterator<Cliente> iterator = this.clienti.iterator(); iterator.hasNext();) {
				Cliente cliente = (Cliente) iterator.next();

				if (cliente instanceof  ClienteAbituale) {
					double help = cliente.getTotaleSpeso();
					System.out.println("L'utente " + cliente.getNomeUtente() + " ha coseguito "
							+ cliente.getnumeroSpese() + " acquisti, spendendo in euro " + help + "\n");
					clientiSelezionati.add(cliente);
				}

			}

			if (clientiSelezionati.size() <= 0) {
				System.out.println(
						"Nessun cliente ha conseguito più di " + SpesePerAbituale.getNumeroSpese() + " acquisti \n");
				return null;
			} else {

				return clientiSelezionati;
			}

		}

	}
		public List<Cliente> generaResocontoConValore(int N) {

			if (this.clienti.size() <= 0) {

				System.out.println("Non sono presenti clienti nel sistema \n ");

				return null;
			} else {

				List<Cliente> clientiSelezionati = new ArrayList<Cliente>();

				System.out.println("I clienti (PROVA Parametro in ingresso) che hanno conseguito almeno "+ N+ " acquisti sono :");
				for (Iterator<Cliente> iterator = this.clienti.iterator(); iterator.hasNext();) {
					Cliente cliente = (Cliente) iterator.next();

					if (cliente.getnumeroSpese()>= N) {
						float help = (float)cliente.getTotaleSpeso();
						System.out.println("L'utente " + cliente.getNomeUtente() + " ha coseguito "
								+ cliente.getnumeroSpese() + " acquisti, spendendo in euro " + help + "\n");
						clientiSelezionati.add(cliente);
					}

				}

				if (clientiSelezionati.size() <= 0) {
					System.out.println(
							"Nessun cliente ha conseguito più di " + SpesePerAbituale.getNumeroSpese() + " acquisti \n");
					return null;
				} else {

					return clientiSelezionati;
				}

			}

	}

}
