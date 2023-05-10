package br.com.ToolsChallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ToolsChallenge.transacao.Transacao;
import br.com.ToolsChallenge.transacao.TransacaoServico;

@RestController
@RequestMapping("/api")
public class Endpointer {

	@Autowired
	TransacaoServico transacaoServico;
	
	Transacao transacao;
	
	@PostMapping("/transacao")
	public Transacao addTransacao(@RequestBody Transacao t) {
		transacaoServico.addTransacao(t);
	return t;
	}
	

}
