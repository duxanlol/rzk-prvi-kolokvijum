package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the AvioLet database table.
 * 
 */
@Entity
@NamedQuery(name="AvioLet.findAll", query="SELECT a FROM AvioLet a")
public class AvioLet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAvioLet;

	private int cena;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private String destinacija;

	private String polazniAerodrom;

	//bi-directional many-to-one association to AvioProdaja
	@OneToMany(mappedBy="avioLet")
	private List<AvioProdaja> avioProdajas;

	public AvioLet() {
	}

	public int getIdAvioLet() {
		return this.idAvioLet;
	}

	public void setIdAvioLet(int idAvioLet) {
		this.idAvioLet = idAvioLet;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getDestinacija() {
		return this.destinacija;
	}

	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}

	public String getPolazniAerodrom() {
		return this.polazniAerodrom;
	}

	public void setPolazniAerodrom(String polazniAerodrom) {
		this.polazniAerodrom = polazniAerodrom;
	}

	public List<AvioProdaja> getAvioProdajas() {
		return this.avioProdajas;
	}

	public void setAvioProdajas(List<AvioProdaja> avioProdajas) {
		this.avioProdajas = avioProdajas;
	}

	public AvioProdaja addAvioProdaja(AvioProdaja avioProdaja) {
		getAvioProdajas().add(avioProdaja);
		avioProdaja.setAvioLet(this);

		return avioProdaja;
	}

	public AvioProdaja removeAvioProdaja(AvioProdaja avioProdaja) {
		getAvioProdajas().remove(avioProdaja);
		avioProdaja.setAvioLet(null);

		return avioProdaja;
	}

}