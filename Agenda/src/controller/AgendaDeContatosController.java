package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import business.ContatoBO;
import dao.ContatoDAO;
import vo.ContatoVO;

public class AgendaDeContatosController {

	public String excluir(ContatoVO contatoVO) {
		
		ContatoDAO contatoDAO = new ContatoDAO();
		
		return contatoDAO.excluir(contatoVO);
	}
	
	public boolean salvarContato(ContatoVO contatoVO) throws SQLException {
		boolean retorno = true;
		
		try {
			ContatoBO contatoBO = new ContatoBO();
			retorno = contatoBO.manterContato(contatoVO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}

	public ContatoVO pesquisarContatoPorId(int id, String nome, String telefone, JTable tabela) {

		ContatoVO contatoVO = new ContatoVO();

		
		ContatoBO contatoBO = new ContatoBO();
		contatoVO = contatoBO.pesquisarContatoPorId(id, nome, telefone,  tabela);

		return contatoVO;
	}

	public List<ContatoVO> pesquisarContatoTodos(JTable tabela) {
		List<ContatoVO> retorno = new ArrayList<ContatoVO>();
		ContatoBO contatoBO = new ContatoBO();
		retorno = contatoBO.pesquisarContatoTodos(tabela);
		return retorno;
	}

	public boolean altera(ContatoVO contatoVO) throws SQLException {
		
		boolean retorno = true;
		try {
			ContatoBO contatoBO = new ContatoBO();
			retorno = contatoBO.alterar(contatoVO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}

	public ContatoVO pesquisarContatoPorNome(String nome, JTable table) {

		ContatoVO contatoVO = new ContatoVO();

		
		ContatoBO contatoBO = new ContatoBO();
		contatoVO = contatoBO.pesquisarContatoPorNome(nome,table);

		return contatoVO;
		
	}

	public ContatoVO pesquisarContatoPorTelefone(String telefone, JTable table) {
		ContatoVO contatoVO = new ContatoVO();

		
		ContatoBO contatoBO = new ContatoBO();
		contatoVO = contatoBO.pesquisarContatoPorTelefone(telefone,table);

		return contatoVO;
		
	}
	

}