package beans;

import javax.ejb.Remote;

import model.AvioLet;

@Remote
public interface AvioSessionBeanRemote {

	public void logout();
	public boolean rezervisi(int letId, int brojKarata);
	public boolean kupi();
	public boolean login(String username, String password);
	
	
}
