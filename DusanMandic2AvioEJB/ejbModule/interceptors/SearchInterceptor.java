package interceptors;

import java.util.List;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import beans.StatsBeanLocal;
import model.AvioLet;

public class SearchInterceptor {

	@EJB
	StatsBeanLocal sbl;
	
	
	@AroundInvoke
	public Object intercept (InvocationContext ctx) throws Exception
	{
	   System.out.println("Intercepted search.");
	   List<AvioLet> letovi = (List<AvioLet>) ctx.getMethod().invoke(ctx.getTarget(), ctx.getParameters());
	   sbl.incZaLetove(letovi);
	   return ctx.proceed();
	}
		
	
}
