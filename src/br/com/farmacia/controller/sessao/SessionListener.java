package br.com.farmacia.controller.sessao;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	private final AtomicInteger sessoesAtivas;

	public SessionListener() {
			super();
			sessoesAtivas = new AtomicInteger();
	}
	
	public int getTotalSessoesAtivas() {
		return sessoesAtivas.get();
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		sessoesAtivas.incrementAndGet();
		if(event.getSession().getMaxInactiveInterval() > 120)
			event.getSession().invalidate();
		
		System.out.println(sessoesAtivas);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		sessoesAtivas.decrementAndGet();
		System.out.println(sessoesAtivas);
	}

}
