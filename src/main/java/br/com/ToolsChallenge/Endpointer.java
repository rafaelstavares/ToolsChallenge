package br.com.ToolsChallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import br.com.ToolsChallenge.dto.PagamentoDto;
import br.com.ToolsChallenge.dto.TransacaoDTO;
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
	
	@PostMapping("/transacao2")
	public ResponseEntity<PagamentoDto> addPagamento(@RequestBody Transacao t) {
		PagamentoDto pagamentoDto = new PagamentoDto();
		TransacaoDTO transacaoDTO = new TransacaoDTO();
		transacaoDTO.setCartao(t.getCartao());
		pagamentoDto.setTransacao(transacaoDTO);
	return ResponseEntity.ok().body(pagamentoDto);
	}

}
