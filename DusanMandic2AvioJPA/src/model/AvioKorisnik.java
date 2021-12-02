package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AvioKorisnik database table.
 * 
 */
@Entity
@NamedQuery(name="AvioKorisnik.findAll", query="SELECT a FROM AvioKorisnik a")
public class AvioKorisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAvioKorisnik;

	@Column(name="Ime")
	private String ime;

	private String password;

	@Column(name="Prezime")
	private String prezime;

	private String username;

	//bi-directional many-to-one association to AvioProdaja
	@OneToMany(mappedBy="avioKorisnik")
	private List<AvioProdaja> avioProdajas;

	public AvioKorisnik() {
	}

	public int getIdAvioKorisnik() {
		return this.idAvioKorisnik;
	}

	public void setIdAvioKorisnik(int idAvioKorisnik) {
		this.idAvioKorisnik = idAvioKorisnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<AvioProdaja> getAvioProdajas() {
		return this.avioProdajas;
	}

	public void setAvioProdajas(List<AvioProdaja> avioProdajas) {
		this.avioProdajas = avioProdajas;
	}

	public AvioProdaja addAvioProdaja(AvioProdaja avioProdaja) {
		getAvioProdajas().add(avioProdaja);
		avioProdaja.setAvioKorisnik(this);

		return avioProdaja;
	}

	public AvioProdaja removeAvioProdaja(AvioProdaja avioProdaja) {
		getAvioProdajas().remove(avioProdaja);
		avioProdaja.setAvioKorisnik(null);

		return avioProdaja;
	}

}