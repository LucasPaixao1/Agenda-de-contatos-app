package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import vo.ContatoVO;

public class ContatoDAO {

	public boolean inserir(ContatoVO contatoVO) {
		String url = "jdbc:mysql://localhost:3306/agenda_contatos";
		String user = "root";
		String password = "";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);

			String comandoSql = "INSERT INTO contato (id, nome, ddd, telefone) VALUES (?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(comandoSql);

			preparedStatement.setInt(1, contatoVO.getId());
			preparedStatement.setString(2, contatoVO.getNome());
			preparedStatement.setString(3, contatoVO.getDdd());
			preparedStatement.setString(4, contatoVO.getTelefone());
			int cont = preparedStatement.executeUpdate();
			if (cont == 1) {
				JOptionPane.showMessageDialog(null,"FUNCIONOU.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}


}
