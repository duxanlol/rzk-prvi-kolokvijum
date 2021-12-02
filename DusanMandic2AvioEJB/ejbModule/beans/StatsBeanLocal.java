package beans;

import java.util.List;

import javax.ejb.Local;

import model.AvioLet;

@Local
public interface StatsBeanLocal {

	public void incZaLetove(List<AvioLet> letovi);
	public void incGlobal();
	
	
}
