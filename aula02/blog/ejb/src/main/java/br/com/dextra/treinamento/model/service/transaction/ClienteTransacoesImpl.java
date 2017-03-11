package br.com.dextra.treinamento.model.service.transaction;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ClienteTransacoesImpl implements ClienteTransacoesLocal{

	@EJB
	private TestarTransacoesLocal testarTransacoesLocal;
	
	@Override
	public void testarRequired() {
		// TODO Auto-generated method stub
		testarTransacoesLocal.criarPostRequired("Titulo required");
		testarTransacoesLocal.criarPostRequired(null);
	}

	@Override
	public void testarRequiresNew() {
		// TODO Auto-generated method stub
		testarTransacoesLocal.criarPostRequiresNew("Titulo requires new");
		testarTransacoesLocal.criarPostRequiresNew(null);
	}

	

}
