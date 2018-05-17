package controller;

import java.util.ArrayList;
import java.util.List;

import business.ContatoBO;
import vo.ContatoVO;

public class AgendaDeContatosController {

	public boolean salvarContato(ContatoVO contatoVO) {
		boolean retorno = true;
		ContatoBO contatoBO = new ContatoBO();
		retorno = contatoBO.manterContato(contatoVO);
		return retorno;
	}

	public ContatoVO pesquisarContatoPorId(int id) {

		ContatoBO contatoBO = new ContatoBO();
		ContatoVO contatoVO = contatoBO.pesquisarContatoPorId(id);

		return contatoVO;
	}

	public List<ContatoVO> pesquisarContatoTodos() {
		List<ContatoVO> retorno = new ArrayList<ContatoVO>();
		ContatoBO contatoBO = new ContatoBO();
		retorno = contatoBO.pesquisarContatoTodos();
		return retorno;
	}

}