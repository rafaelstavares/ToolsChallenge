package br.com.ToolsChallenge.descricao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ToolsChallenge.transacao.Transacao;
import br.com.ToolsChallenge.util.Status;
import br.com.ToolsChallenge.util.Utilitaria;

@Service
public class DescricaoServico {

	@Autowired
	DescricaoRepositorio descricaoRepositorio;

	Descricao descricao;

	public Descricao addDescricao(Descricao t, Transacao temp) {
		descricao = t;
		descricao.setDataHora(t.getDataHora());
		descricao.setEstabelecimento(t.getEstabelecimento());
		descricao.setValor(t.getValor());
		descricao.setTransacao(temp);
		descricao.setStatus(Status.AUTORIZADO);
		descricao.setNsu(Utilitaria.numeroAleatorio());
		descricao.setCodigoAutorizacao(Utilitaria.numeroAleatorio());
		descricao = descricaoRepositorio.save(descricao);
		return descricao;
	}

}
