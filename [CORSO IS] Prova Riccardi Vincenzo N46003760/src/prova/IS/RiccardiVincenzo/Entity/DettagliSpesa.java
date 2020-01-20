package prova.IS.RiccardiVincenzo.Entity;

import java.util.Map;
import java.util.TreeMap;

public class DettagliSpesa {

	
	
	private Map<Prodotto,Integer> prodotti = new TreeMap<Prodotto,Integer>();

	public DettagliSpesa() {
		super();
	}

	public Map<Prodotto, Integer> getProdotti() {
		return prodotti;
	}

	public void setProdotti(Map<Prodotto, Integer> prodotti) {
		this.prodotti = prodotti;
	}
	
	
	
	
}
