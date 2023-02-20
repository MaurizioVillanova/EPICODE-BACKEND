package it.epicode.be.godfather.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
public class Ordine {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordine_seq")
    @SequenceGenerator(name = "ordine_seq", sequenceName = "ordine_seq")
    private Long id;

	private Integer numeroOrdine;
	@ManyToOne
	private Tavolo tavolo;
	@ElementCollection
	@CollectionTable(name = "menuitem_to_orders")     
	@MapKeyJoinColumn(name = "menuitem_id")
	@Column(name = "menuitem_quantity")
	private Map<MenuItem, Integer> ordinato = new HashMap<MenuItem, Integer>();
	@Enumerated(EnumType.STRING)
	private StatoOrdine stato = StatoOrdine.IN_CORSO;
	private Integer numeroCoperti = 1;
	private Double costoCoperto;

	public StatoOrdine getStato() {
		return stato;
	}

	public void setStato(StatoOrdine stato) {
		this.stato = stato;
	}

	public Double getCostoCoperto() {
		return costoCoperto;
	}

	public Integer getNumeroOrdine() {
		return numeroOrdine;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public Map<MenuItem, Integer> getOrdinato() {
		return this.ordinato;
	}

	public Integer addMenuItem(MenuItem item) {
		if (!ordinato.containsKey(item)) {
			ordinato.put(item, 1);
		} else {
			ordinato.put(item, ordinato.get(item) + 1);
		}

		return ordinato.get(item);
	}

	public Integer removeMenuItem(MenuItem item) {
		if (ordinato.containsKey(item)) {
			int currentNumber = ordinato.get(item);
			if (currentNumber == 1) {
				ordinato.remove(item);
				return 0;
			} else {
				ordinato.put(item, ordinato.get(item) - 1);
				return ordinato.get(item);
			}
		} else
			return 0;
	}

	public Double getTotale() {
		Double totale = 0d;
		for (MenuItem item : ordinato.keySet()) {
			totale += (item.getPrice() * ordinato.get(item));
		}
		totale += numeroCoperti * getCostoCoperto();
		return totale;
	}

	public Integer getNumeroCoperti() {
		return numeroCoperti;
	}

	public void setNumeroCoperti(Integer numeroCoperti) {
		this.numeroCoperti = numeroCoperti;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public void setNumeroOrdine(Integer numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public void setCostoCoperto(Double costoCoperto) {
		this.costoCoperto = costoCoperto;
	}

}
