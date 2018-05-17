package validator;

import javax.swing.JOptionPane;

import vo.ContatoVO;

public class ContatoValidator {

	public boolean validarContato(ContatoVO contatoVO) {

		boolean retorno = true;

		if (contatoVO.getId() <= 0) {
			JOptionPane.showMessageDialog(null,"Favor informar um ID maior que 0.");
			retorno = false;
		}

		if (contatoVO.getNome() == null) {
			JOptionPane.showMessageDialog(null,"O nome do contato não pode ser nulo.");
			retorno = false;
		}

		if (contatoVO.getNome().equals("")) {
			JOptionPane.showMessageDialog(null,"Favor informar o nome do contato.");
			retorno = false;
		}

		if (contatoVO.getNome().trim().equals("")) {
			JOptionPane.showMessageDialog(null,"Favor informar o nome do contato.");
			retorno = false;
		}

		if (contatoVO.getDdd() == null || contatoVO.getDdd().trim().equals("") || contatoVO.getDdd().length() != 3) {
			JOptionPane.showMessageDialog(null,"Favor informar um DDD válido.");
			retorno = false;
		}

		if (contatoVO.getTelefone() == null || contatoVO.getTelefone().trim().equals("")
				|| (contatoVO.getTelefone().length() != 8 && contatoVO.getTelefone().length() != 9)) {
			JOptionPane.showMessageDialog(null,"Favor informar um telefone válido.");
			retorno = false;

		}

		return retorno;
	}

}
