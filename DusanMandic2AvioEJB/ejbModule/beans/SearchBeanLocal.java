package beans;

import java.util.List;

import javax.ejb.Local;

import model.AvioLet;

@Local
public interface SearchBeanLocal {
	List<AvioLet> pretrazi(String text);
}
