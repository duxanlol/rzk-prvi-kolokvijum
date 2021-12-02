package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interceptors.ProdajaInterceptor;
import model.AvioKorisnik;
import model.AvioLet;
import model.AvioProdaja;

/**
 * Session Bean implementation class AvioSessionBean
 */
@Stateful
@LocalBean
public class AvioSessionBean implements AvioSessionBeanRemote {

	AvioKorisnik user;
	List<AvioProdaja> rezervacije;

	@PersistenceContext
	EntityManager em;

	public AvioSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Remove
	public void logout() {
		System.out.println("Logging out.");

	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Construted stateful bean.");
		rezervacije = new ArrayList<AvioProdaja>();
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Going to destroy stateful bean.");
	}

	@Override
	public boolean rezervisi(int letId, int brojKarata) {
		AvioProdaja rezervacija = new AvioProdaja();
		rezervacija.setAvioKorisnik(user);
		rezervacija.setAvioLet(em.find(AvioLet.class, letId));
		rezervacija.setBrojKarata(brojKarata);
		System.out.println("Rezervisao, trenutni rezervisani su:");
		rezervacije.add(rezervacija);
		System.out.println(rezervacije);
		return true;
	}

	@Override
	@Interceptors(ProdajaInterceptor.class)
	public boolean kupi() {
		// Interceptor nema preterano smisla jer pamti samo prodaje a ne broj karata ali
		// posto je jedan vec hashmap mrzi me.
		for (AvioProdaja a : rezervacije) {
			em.persist(a);
		}
		rezervacije.clear();
		System.out.println("Kupio");
		return true;
	}

	@Override
	public boolean login(String username, String password) {
		user = (AvioKorisnik) em.createQuery("SELECT ak FROM AvioKorisnik ak WHERE ak.username=:username AND ak.password=:password")
				.setParameter("username", username).setParameter("password", password).getSingleResult();
		if (user != null) {
			return true;
		}
		return false;
		
	}

}
