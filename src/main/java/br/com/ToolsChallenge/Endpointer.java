package br.com.ToolsChallenge;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	List<Transacao> lista;

	@PostMapping("/pagamento")
	public ResponseEntity<PagamentoDto> addTransacao(@Valid @RequestBody Transacao t) throws Exception {
		validaJson(t);
		PagamentoDto pagamentoDto = new PagamentoDto();
		TransacaoDTO transacaoDTO = new TransacaoDTO();
		transacao = transacaoServico.addTransacao(t);
		montarDescricaoDto(transacao);
		montaFormaPagamentoDto(transacao);
		transacaoDTO.setCartao(t.getCartao());
		transacaoDTO.setId(t.getId());
		transacaoDTO.setDescricao(descricaoDto);
		transacaoDTO.setFormaPagamento(formaPagamentoDto);
		pagamentoDto.setTransacao(transacaoDTO);
		return new ResponseEntity<PagamentoDto>(pagamentoDto, HttpStatus.CREATED);
	}

	@GetMapping("/pagamento")
	public ResponseEntity<PagamentoDto> buscarPagamentoId(@RequestParam Long id) {
		transacao = transacaoServico.buscarPorId(id);
		PagamentoDto pagamentoDto = new PagamentoDto();
		TransacaoDTO transacaoDTO = new TransacaoDTO();
		montarDescricaoDto(transacao);
		montaFormaPagamentoDto(transacao);
		transacaoDTO.setCartao(transacao.getCartao());
		transacaoDTO.setId(transacao.getId());
		transacaoDTO.setDescricao(descricaoDto);
		transacaoDTO.setFormaPagamento(formaPagamentoDto);
		pagamentoDto.setTransacao(transacaoDTO);
		return ResponseEntity.ok().body(pagamentoDto);
	}

	@GetMapping("/pagamento/todos")
	public ResponseEntity<List<PagamentoDto>> listarTodos() {
		List<PagamentoDto> listaDto = new ArrayList<>();
		lista = transacaoServico.listarTodos();
		for (Transacao transacao : lista) {
			PagamentoDto pagamentoDto = new PagamentoDto();
			TransacaoDTO transacaoDTO = new TransacaoDTO();
			montarDescricaoDto(transacao);
			montaFormaPagamentoDto(transacao);
			transacaoDTO.setCartao(transacao.getCartao());
			transacaoDTO.setId(transacao.getId());
			transacaoDTO.setDescricao(descricaoDto);
			transacaoDTO.setFormaPagamento(formaPagamentoDto);
			pagamentoDto.setTransacao(transacaoDTO);
			listaDto.add(pagamentoDto);
		}
		return ResponseEntity.ok().body(listaDto);
	}

	@PostMapping("/pagamento/estorno")
	public ResponseEntity<PagamentoDto> estornoPagamento(@RequestParam Long id) {
		transacao = transacaoServico.estornoPagamento(id);
		PagamentoDto pagamentoDto = new PagamentoDto();
		TransacaoDTO transacaoDTO = new TransacaoDTO();
		montarDescricaoDto(transacao);
		montaFormaPagamentoDto(transacao);
		transacaoDTO.setCartao(transacao.getCartao());
		transacaoDTO.setId(transacao.getId());
		transacaoDTO.setDescricao(descricaoDto);
		transacaoDTO.setFormaPagamento(formaPagamentoDto);
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
		formaPagamentoDto.setTipo(transacao.getFormaPagamento().getTipo().getNome());
		formaPagamentoDto.setParcelas(transacao.getFormaPagamento().getParcelas());

	}
	
	private void validaJson(Transacao t) throws Exception {
		String cartao = t.getCartao();
		Long id = t.getId();
		if (cartao.isEmpty()|cartao.isBlank()) {
			throw new Exception("Campo Cartao em Branco");
			}
			if (id < 1) {
				throw new Exception("Campo ID zerado");
			}

		}
	
}
