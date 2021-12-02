package interceptors;



import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import beans.StatsBeanLocal;


public class ProdajaInterceptor {

	
	@EJB
	StatsBeanLocal sbl;
	
	
	@AroundInvoke
	public Object intercept (InvocationContext ctx) throws Exception
	{
	   System.out.println("Intercepted prodaja.");
	   sbl.incGlobal();
	   return ctx.proceed();
	}
}
