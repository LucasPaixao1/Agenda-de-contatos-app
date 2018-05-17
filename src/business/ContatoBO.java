package business;

import java.util.ArrayList;
import java.util.List;

import dao.ContatoDAO;
import validator.ContatoValidator;
import vo.ContatoVO;

public class ContatoBO {

	public boolean manterContato(ContatoVO contatoVO) {

		boolean retorno = true;
		/* vamos validar os dados do contato */
		ContatoValidator contatoValidator = new ContatoValidator();
		retorno = contatoValidator.validarContato(contatoVO);

		/* vamos cadastrar o contato */
		ContatoDAO contatoDAO = new ContatoDAO();
		retorno = contatoDAO.inserir(contatoVO);

		return retorno;
	}

	public ContatoVO pesquisarContatoPorId(int id) {
		ContatoDAO contatoDAO = new ContatoDAO();
		ContatoVO contatoVO = contatoDAO.pesquisarContatoPorId(id);
		return contatoVO;
	}

	public List<ContatoVO> pesquisarContatoTodos() {
		List<ContatoVO> retorno = new ArrayList<ContatoVO>();
		ContatoDAO contatoDAO = new ContatoDAO();
		retorno = contatoDAO.pesquisarContatoTodos();
		return retorno;
	}
}