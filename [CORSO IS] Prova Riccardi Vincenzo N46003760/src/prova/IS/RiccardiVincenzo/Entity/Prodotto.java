package prova.IS.RiccardiVincenzo.Entity;

public class Prodotto {

	
	private Integer codice;
	private String nome;
	private String descrizione;
	private Number prezzo;
	private Number quantita;
	
	
	
	public Prodotto() {
		super();
	}
	
	
	public Prodotto(Integer codice, String nome, String descrizione, Number prezzo, Number quantita) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}


	public Integer getCodice() {
		return codice;
	}
	public void setCodice(Integer codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Number getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Number prezzo) {
		this.prezzo = prezzo;
	}
	public Number getQuantita() {
		return quantita;
	}
	public void setQuantita(Number quantita) {
		this.quantita = quantita;
	}
	
	
}
