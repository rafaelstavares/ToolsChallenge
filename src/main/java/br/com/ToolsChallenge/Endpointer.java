package br.com.ToolsChallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import br.com.ToolsChallenge.dto.DescricaoDto;
import br.com.ToolsChallenge.dto.FormaPagamentoDto;
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
	
	DescricaoDto descricaoDto;
	
	FormaPagamentoDto formaPagamentoDto;
	
	@PostMapping("/pagamento")
	public ResponseEntity<PagamentoDto> addTransacao(@RequestBody Transacao t) {
		PagamentoDto pagamentoDto = new PagamentoDto();
		TransacaoDTO transacaoDTO = new TransacaoDTO();
		transacao = transacaoServico.addTransacao(t);
		montarDescricaoDto(transacao);
		montaFormaPagamentoDto(transacao);
		transacaoDTO.setCartao(t.getCartao());
		transacaoDTO.setId(t.getId());
		transacaoDTO.setDescricaoDto(descricaoDto);
		transacaoDTO.setFormaPagamentoDto(formaPagamentoDto);
		pagamentoDto.setTransacao(transacaoDTO);
	return ResponseEntity.ok().body(pagamentoDto);
	}
	
	@PostMapping("/transacao2")
	public ResponseEntity<PagamentoDto> addPagamento(@RequestBody Transacao t) {
		PagamentoDto pagamentoDto = new PagamentoDto();
		TransacaoDTO transacaoDTO = new TransacaoDTO();
		transacaoDTO.setCartao(t.getCartao());
		transacaoDTO.setId(t.getId());
		pagamentoDto.setTransacao(transacaoDTO);
	return ResponseEntity.ok().body(pagamentoDto);
	}
	
	private void montarDescricaoDto(Transacao transacao) {
		descricaoDto = new DescricaoDto();
		descricaoDto.setValor(transacao.getDescricao().getValor());
		descricaoDto.setDataHora(transacao.getDescricao().getDataHora());
		descricaoDto.setEstabelecimento(transacao.getDescricao().getEstabelecimento());
		descricaoDto.setNsu(transacao.getDescricao().getNsu());
		descricaoDto.setCodigoAutorizacao(transacao.getDescricao().getCodigoAutorizacao());
		descricaoDto.setStatus(transacao.getDescricao().getStatus().getNome());
	}
	private void montaFormaPagamentoDto(Transacao transacao) {
		formaPagamentoDto = new FormaPagamentoDto();
		formaPagamentoDto.setTipo(transacao.getFormaPagamento().getTipo());
		formaPagamentoDto.setParcelas(transacao.getFormaPagamento().getParcelas());
		
	}
}
