package br.com.ToolsChallenge.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransacaoControle {

	@Autowired
	TransacaoServico transacaoServico;
	
	Transacao transacao;
	
	@PostMapping("/transacao")
	public Transacao addTransacao(@RequestBody Transacao t) {
		transacaoServico.addTransacao(t);
	return t;
	}
	

}
