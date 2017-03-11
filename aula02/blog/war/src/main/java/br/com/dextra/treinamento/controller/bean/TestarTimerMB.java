package br.com.dextra.treinamento.controller.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.dextra.treinamento.model.service.timer.TesteTimerLocal;

@ManagedBean(name = "testarTimerMB")
@RequestScoped
public class TestarTimerMB {
	
	@EJB
	private TesteTimerLocal testeTimerLocal;
	
	public void agendar(){
		long intervalo = 1*30*1000;
		testeTimerLocal.agendar(intervalo, intervalo);
		System.out.println("Timer agendado :D");
	}
	
	public void cancelar(){
		testeTimerLocal.cancelar();
		System.out.println("Timer cancelado :/");
	}

}
