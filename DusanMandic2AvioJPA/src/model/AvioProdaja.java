package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AvioProdaja database table.
 * 
 */
@Entity
@NamedQuery(name="AvioProdaja.findAll", query="SELECT a FROM AvioProdaja a")
public class AvioProdaja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAvioProdaja;

	private int brojKarata;

	//bi-directional many-to-one association to AvioKorisnik
	@ManyToOne
	@JoinColumn(name="fk_korisnik")
	private AvioKorisnik avioKorisnik;

	//bi-directional many-to-one association to AvioLet
	@ManyToOne
	@JoinColumn(name="fk_let")
	private AvioLet avioLet;

	public AvioProdaja() {
	}

	public int getIdAvioProdaja() {
		return this.idAvioProdaja;
	}

	public void setIdAvioProdaja(int idAvioProdaja) {
		this.idAvioProdaja = idAvioProdaja;
	}

	public int getBrojKarata() {
		return this.brojKarata;
	}

	public void setBrojKarata(int brojKarata) {
		this.brojKarata = brojKarata;
	}

	public AvioKorisnik getAvioKorisnik() {
		return this.avioKorisnik;
	}

	public void setAvioKorisnik(AvioKorisnik avioKorisnik) {
		this.avioKorisnik = avioKorisnik;
	}

	public AvioLet getAvioLet() {
		return this.avioLet;
	}

	public void setAvioLet(AvioLet avioLet) {
		this.avioLet = avioLet;
	}

}