package br.com.ToolsChallenge.transacao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import br.com.ToolsChallenge.ToolsAppTest;
import br.com.ToolsChallenge.descricao.Descricao;
import br.com.ToolsChallenge.descricao.DescricaoServico;
import br.com.ToolsChallenge.formaPagamento.FormaPagamento;
import br.com.ToolsChallenge.formaPagamento.FormaPagamentoServico;
import br.com.ToolsChallenge.util.Status;
import br.com.ToolsChallenge.util.Tipo;

@DisplayName("TransacaoServicoTest")
@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
public class TransacaoServicoTest extends ToolsAppTest{

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	TransacaoRepositorio transacaoRepositorio;

	@MockBean
	DescricaoServico descricaoServico;

	@MockBean
	FormaPagamentoServico formaPagamentoServico;
	
	@Autowired
	TransacaoServico transacaoServico;
	
	@Autowired
	private JacksonTester<Transacao> json;

	
	@Test
	@DisplayName("Teste de Transação")
	public void funionamentoTransacaoTest() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(
                post("/pagamento")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                        json.write(new Transacao(1,"12531",122556,null,null)).getJson()
                    )
            )
            .andReturn()
            .getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
		assertThat(response.getContentAsString())
			.isEqualTo(
				json.write(new Transacao(1,"12531",122556,null,null)).getJson()
			);
}

	@Test
	@DisplayName(value = "retorna erro ")
	void deveInformarErroPagamento() throws Exception {

}
}
