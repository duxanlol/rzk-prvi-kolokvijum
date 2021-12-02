package beans;

import java.util.HashMap;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.persistence.criteria.CriteriaBuilder.In;

import model.AvioLet;

/**
 * Session Bean implementation class StatsBean
 */
@Singleton
@LocalBean
public class StatsBean implements StatsBeanLocal {

	int globalCounter;
	HashMap<Integer, Integer> viewsLet;
	
    /**
     * Default constructor. 
     */
    public StatsBean() {
    	globalCounter = 0;
    	viewsLet = new HashMap<Integer, Integer>();
    }

	@Override
	public void incZaLetove(List<AvioLet> letovi) {
		for(AvioLet l : letovi) {
			viewsLet.putIfAbsent(l.getIdAvioLet(), 0);
			viewsLet.put(l.getIdAvioLet(), viewsLet.get(l.getIdAvioLet()) +1);
		}
		
	}
	@Schedule( persistent = false)
	public void pisi() {
		System.out.println("Bilo je " + globalCounter + "prodaja.");
		for( Integer i : viewsLet.keySet()) {
			System.out.println("Let sa id-em: " + i + " je imao "+ viewsLet.get(i) + "pregleda");
		}
		globalCounter = 0;
		viewsLet.clear();
	}
	
	@Override
	public void incGlobal() {
		globalCounter +=1;
		
	}

}
