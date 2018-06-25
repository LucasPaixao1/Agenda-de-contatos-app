package business;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import dao.ContatoDAO;
import validator.ContatoValidator;
import vo.ContatoVO;

public class ContatoBO {

	public boolean manterContato(ContatoVO contatoVO) throws SQLException, IOException {

		boolean retorno = true;
		ContatoValidator contatoValidator = new ContatoValidator();
		retorno = contatoValidator.validarContato(contatoVO);

		if (retorno) {
			ContatoDAO contatoDAO = new ContatoDAO();
			retorno = contatoDAO.inserir(contatoVO);
		}

		return retorno;
	}

	public ContatoVO pesquisarContatoPorId(int id, String nome, String telefone, JTable tabela) {

		ContatoVO contatoVO = new ContatoVO();

		ContatoDAO contatoDAO = new ContatoDAO();
		contatoVO = contatoDAO.pesquisarContatoPorId(id, nome, telefone, tabela);
		return contatoVO;
	}

	public List<ContatoVO> pesquisarContatoTodos(JTable tabela) {
		List<ContatoVO> retorno = new ArrayList<ContatoVO>();
		ContatoDAO contatoDAO = new ContatoDAO();
		retorno = contatoDAO.pesquisarContatoTodos(tabela);
		return retorno;
	}

	public ContatoVO pesquisarContatoPorNome(String nome, JTable table) {
		ContatoVO contatoVO = new ContatoVO();

		ContatoDAO contatoDAO = new ContatoDAO();
		contatoVO = contatoDAO.pesquisarContatoPorNome(nome, table);
		return contatoVO;
	}

	public ContatoVO pesquisarContatoPorTelefone(String telefone, JTable table) {
		ContatoVO contatoVO = new ContatoVO();

		ContatoDAO contatoDAO = new ContatoDAO();
		contatoVO = contatoDAO.pesquisarContatoPorTelefone(telefone, table);
		return contatoVO;
	}

	public boolean alterar(ContatoVO contatoVO) throws SQLException, IOException {

		boolean retorno = true;
		ContatoValidator contatoValidator = new ContatoValidator();
		retorno = contatoValidator.alterarContato(contatoVO);
		if (retorno) {
			ContatoDAO contatoDAO = new ContatoDAO();
			retorno = (boolean) contatoDAO.alter(contatoVO);
		}
		return retorno;

	}

}