package br.com.dextra.treinamento.model.service.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor {
	
	@PostConstruct
	public void construct(InvocationContext ctx) {
		System.out.println("EJB FOI CRIADO: " + ctx.getTarget().getClass().getSimpleName());
	}
	
	@PreDestroy
	public void destroy(InvocationContext ctx) {
		System.out.println("EJB FOI DESTRUIDO");
	}
	
	@PrePassivate
	public void passivate(InvocationContext ctx) {
		System.out.println("EJB FOI PASSIVADO");
	}
	
	@PostActivate
	public void activate(InvocationContext ctx) {
		System.out.println("EJB FOI ATIVADO");
	}
	
	@AroundInvoke
	public Object logar(InvocationContext ctx) throws Exception {
		String classse = ctx.getTarget().getClass().getName();
		String metodo = ctx.getMethod().getName();
		//poderia fazer a chamada para o banco
		
		//faz a chamada print
		System.out.println("Nome da Classe: " + classse);
		System.out.println("Nome do Metodo: " + metodo);
		return ctx.proceed();
	}
	
	

}
