package prova.IS.RiccardiVincenzo.Control;

import java.util.*;

import prova.IS.RiccardiVincenzo.Entity.Cliente;
import prova.IS.RiccardiVincenzo.Entity.Spesa;



public class GestoreUtente {

	/**
	 * @param clienti: rappresenta la lista dei clienti nel sistema compresi gli abituali. In pancia a ogni cliente è salvato il relativo storico spese.
	 * @param numSpeseMax: rappresenta il massimo numero di spese effettuate da un singolo utente. 
	 */
	private List<Cliente> clienti = new ArrayList<Cliente>();
	int numSpeseMax = 0;
	// private Scanner scanner;


	public void addCliente(Cliente c) {
		this.clienti.add(c);
	}


	
//	 public void checkClienteAbituale(Cliente cliente) {
//	 if( cliente.isAbituale()) {
//	 return;
//	 }else {
//	 if(cliente.getStoricoSpese().size()>=SpeseDefault.getNumeroSpese()) {
//	 cliente.setAbituale(true);
//	 }
//	 }
//	 }

	public void pagaSpesa(Spesa spesa, Cliente cliente) {
		//aggiorno lo storico spese del cliente al momento del pagamento
		List<Spesa> spese = cliente.getStoricoSpese();
		spese.add(spesa);
		cliente.setStoricoSpese(spese);
		//Con il blocco "if" aggiorno la variabile numSpeseMax, qualora un cliente abbia effettuato più superato il valore di Max
		if (spese.size() > this.numSpeseMax) {
			this.numSpeseMax = spese.size();
		}
		//checkClienteAbituale(cliente);

	}

	/**
	 * @param N: rappresenta il numero di spese minime che gli utenti devono aver affettuato per quel determinato report.
	 * @return: ritorna la lista dei clienti validi oppure null peri casi di errore oppure lista vuota nell'eccezioni.
	 */
	public List<Cliente> generaResoconto(int N) {
		
		// questo blocco "if else if"è stato aggiunto per gestire i casi di test con [ERR]
		if (this.clienti.size() <= 0) {

			System.out.println("Non sono presenti clienti nel sistema \n ");

			return null;
		} else if (N < 0) {
			System.out.println("Il parametro immesso non è valido\n");
			return null;
		}
		
		List<Cliente> clientiSelezionati = new ArrayList<Cliente>();
		
		// questo blocco "if else if"è stato aggiunto solo per fornire dei messaggio più chiari al chiamante
		//se commentati la funzionalità è mantenuta con la sola perdita di messaggi informativi.
		if (this.numSpeseMax == 0) {
			System.out.println("Non sono presenti acquisti nel sistema\n");
			return clientiSelezionati;
		} else if (N > this.numSpeseMax) {

			System.out.println(
					"Il parametro è maggiore del numero di spese del cliente con più acquisti sulla piattaforma\n");
			return clientiSelezionati;
		} else {

			System.out.println("I clienti che hanno conseguito almeno " + N + " acquisti sono :");
 
			for (Cliente cliente : this.clienti) {
				// per ogni cliente verifico il numero di spese effettuate e se maggiore di N lo inserisco nella lista di output.
				if (cliente.getnumeroSpese() >= N) {
						float help = (float) cliente.getTotaleSpeso();
						System.out.println("L'utente " + cliente.getNomeUtente() + " ha coseguito "
								+ cliente.getnumeroSpese() + " acquisti, spendendo in euro " + help + "\n");
						clientiSelezionati.add(cliente);
					}
			}

			return clientiSelezionati;
		}

	}

	// public List<Cliente> generaResocontoInterface(){
	//
	// Integer valore = null;
	// scanner = new Scanner(System.in);
	// try {
	// System.out.println("Inserire il valore di N (default :
	// "+SpeseDefault.getNumeroSpese()+") : ");
	// String valoreStr = scanner.nextLine();
	// if (valoreStr.isEmpty()) {
	// System.out.println("valore di DEFAULT: "+SpeseDefault.getNumeroSpese()+"\n");
	// return generaResocontoConValore(SpeseDefault.getNumeroSpese());
	// }else {
	// valore=Integer.parseInt(valoreStr);
	// return generaResocontoConValore(valore);
	// }
	// }catch(NumberFormatException e) {
	// System.out.println("Il parametro immesso non è un numero\n");
	// return null;
	// }
	//

}












/*
 public List<Cliente> generaResocontoClasseAusiliaria() {

 if (this.clienti.size() <= 0) {

 System.out.println("Non sono presenti clienti nel sistema \n ");

 return null;
 } else {

 System.out.println("I clienti (PROVA Classe Ausiliaria) che hanno conseguito
 almeno "+ SpeseDefault.getNumeroSpese()+ " acquisti sono :");

 List<Cliente> clientiSelezionati = new ArrayList<Cliente>();

 for (Iterator<Cliente> iterator = this.clienti.iterator();
 iterator.hasNext();) {
 Cliente cliente = (Cliente) iterator.next();

 if (cliente.getnumeroSpese() >= SpeseDefault.getNumeroSpese()) {
 double help = cliente.getTotaleSpeso();
 System.out.println("L'utente " + cliente.getNomeUtente() + " ha coseguito "
 + cliente.getnumeroSpese() + " acquisti, spendendo in euro " + help + "\n");
 clientiSelezionati.add(cliente);
 }

 }

 if (clientiSelezionati.size() <= 0) {
 System.out.println(
 "Nessun cliente ha conseguito più di " + SpeseDefault.getNumeroSpese() + "
 acquisti \n");
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

 System.out.println("I clienti (PROVA INSTANCEOF) che hanno conseguito almeno
 "+ SpeseDefault.getNumeroSpese()+ " acquisti sono :");
 for (Iterator<Cliente> iterator = this.clienti.iterator();
 iterator.hasNext();) {
 Cliente cliente = (Cliente) iterator.next();

 if (cliente instanceof ClienteAbituale) {
 double help = cliente.getTotaleSpeso();
 System.out.println("L'utente " + cliente.getNomeUtente() + " ha coseguito "
 + cliente.getnumeroSpese() + " acquisti, spendendo in euro " + help + "\n");
 clientiSelezionati.add(cliente);
 }

 }

 if (clientiSelezionati.size() <= 0) {
 System.out.println(
 "Nessun cliente ha conseguito più di " + SpeseDefault.getNumeroSpese() + "
 acquisti \n");
 return null;
 } else {

 return clientiSelezionati;
 }

 }

 }
// public void removeCliente(Cliente c) {
// int index=0;
// for (Iterator<Cliente> iterator = clienti.iterator(); iterator.hasNext();) {
// Cliente cliente = (Cliente) iterator.next();
// if(cliente.equals(c)) {
// this.clienti.remove(index);
// break;
// }
// index++;
// }
//
// }

*/