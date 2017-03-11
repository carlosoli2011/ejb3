package br.com.dextra.treinamento.model.service.interceptor;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dextra.treinamento.model.domain.PostAudit;
import br.com.dextra.treinamento.model.service.jpa.PostServiceImpl;
import jdk.nashorn.internal.runtime.ListAdapter;

public class AuditInterceptor {
	
	@PersistenceContext(unitName = "blog-pu")
	private EntityManager em;
	
	@Resource
	private SessionContext context;
	
	@AroundInvoke
	public Object logar(InvocationContext ctx) throws Exception {
		Object proceed = ctx.proceed();

		String classe = ctx.getTarget().getClass().getName();
		String metodo = ctx.getMethod().getName();
		String parametros = ctx.getParameters()[0].toString();
		//fazer a chamada para o banco
		String login = context.getCallerPrincipal().getName();
		PostAudit postAudit = new PostAudit();
		postAudit.setClasse(classe);
		postAudit.setMetodo(metodo);
		postAudit.setParametros(parametros);
		postAudit.setLogin(login);
		//faz a chamada print
		//System.out.println("Nome da Classe: " + classe);
		//System.out.println("Nome do Metodo: " + metodo);
		em.persist(postAudit);
		
		
		return proceed;
	}

}
