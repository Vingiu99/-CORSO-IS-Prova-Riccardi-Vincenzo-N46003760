package prova.IS.RiccardiVincenzo.Entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {

	
	private String nomeUtente;
	private String password;
	private Number numeroCell;
	private List<Spesa> storicoSpese = new ArrayList<Spesa>();
	private boolean abituale;
	 
	
	
	
	public Cliente() {
		super();
		this.abituale=false;
	}
	
	public Cliente(String nomeUtente, String password, Number numeroCell) {
		super();
		this.nomeUtente = nomeUtente;
		this.password = password;
		this.numeroCell = numeroCell;
		this.abituale=false;
	}
	
	public boolean isAbituale() {
		return abituale;
	}
	public void setAbituale(boolean abituale) {
		this.abituale = abituale;
	}
	public String getNomeUtente() {
		return nomeUtente;
	}
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Number getNumeroCell() {
		return numeroCell;
	}
	public void setNumeroCell(Number numeroCell) {
		this.numeroCell = numeroCell;
	}
	public List<Spesa> getStoricoSpese() {
		return storicoSpese;
	}
	public void setStoricoSpese(List<Spesa> storicoSpese) {
		this.storicoSpese = storicoSpese;
	}
	public Integer getnumeroSpese() {
		return this.storicoSpese.size();
	}
	public double getTotaleSpeso() {
		double costo=0;
		
		for (Iterator<Spesa> iterator = storicoSpese.iterator(); iterator.hasNext();) {
			Spesa spesa = (Spesa) iterator.next();
			double tmp = spesa.getCosto();
			costo=costo+tmp;
		}
		
		return costo;
	}

}
