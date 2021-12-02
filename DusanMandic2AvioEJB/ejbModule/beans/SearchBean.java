package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interceptors.SearchInterceptor;
import model.AvioLet;

/**
 * Session Bean implementation class SearchBean
 */
@Stateless
@LocalBean
public class SearchBean implements SearchBeanLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext
	EntityManager em;

	public SearchBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Interceptors(SearchInterceptor.class)
	public List<AvioLet> pretrazi(String text) {
		List<AvioLet> letovi = em.createQuery("SELECT al from AvioLet al WHERE al.polazniAerodrom=:text")
				.setParameter("text", text).getResultList();
		return letovi;
	}

}
