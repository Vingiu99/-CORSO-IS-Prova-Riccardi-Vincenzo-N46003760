package prova.IS.RiccardiVincenzo.Entity;

import java.time.LocalDate;

public class Spesa {

	private Integer id;
	private LocalDate data;
	private double costo;
	private DettagliSpesa dettagliSpesa;
	private StatoSpesa stato;
	
	
	public Spesa() {
		super();
	}

	public Spesa(Integer id, double costo) {
		super();
		this.id = id;
		this.costo = costo;
		this.stato=null;
		this.dettagliSpesa=null;
		this.data=LocalDate.now();
	}
	

	public StatoSpesa getStato() {
		return stato;
	}

	public void setStato(StatoSpesa stato) {
		this.stato = stato;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public DettagliSpesa getDettagliSpesa() {
		return dettagliSpesa;
	}

	public void setDettagliSpesa(DettagliSpesa dettagliSpesa) {
		this.dettagliSpesa = dettagliSpesa;
	}
	
	




}
