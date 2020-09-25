package br.edu.insper.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.insper.Login;
import br.edu.insper.Tarefas;


public class DAO_login {
	private Connection connection = null;
	public DAO_login() throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.jdbc.Driver");
	 connection = DriverManager.getConnection(
	"jdbc:mysql://localhost/meus_dados", "root", "SaraPs396984");
	}
	public List<Login> getLista() throws SQLException {
		List<Login> logins = new ArrayList<Login>();
		PreparedStatement stmt = connection.
		 prepareStatement("SELECT * FROM Login");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
		Login login = new Login();
		login.setId(rs.getInt("id"));
		login.setNome(rs.getString("nome"));
		login.setSenha(rs.getString("senha"));
		
		logins.add(login);
		}
		rs.close();
		stmt.close();
		return logins;
}
	public void close() throws SQLException {
		connection.close();
	}
	public void adiciona(Login login) throws SQLException {
		String sql = "INSERT INTO Login" +
		"(nome,senha) values(?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,login.getNome());
		stmt.setString(2,login.getSenha());
		stmt.execute();
		stmt.close();
		}
	
	public void altera(Login login) throws SQLException {
		String sql = "UPDATE Login SET " +"nome=?, senha=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, login.getNome());
		stmt.setString(2, login.getSenha());
		stmt.setInt(3, login.getId());
		stmt.execute();
		stmt.close();
	}
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM Login WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		}
//	public void ordenar(String tipo) throws SQLException {
//		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pessoas ORDER BY ?");
//		stmt.setString(1, tipo);
//		stmt.execute();
//		stmt.close();
//		}
//	public List<Tarefas>ordenar(String tipo) throws SQLException {
//		List<Tarefas> tarefas = new ArrayList<Tarefas>();
//		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pessoas ORDER BY ?");
//		stmt.setString(1, tipo);
//		ResultSet rs = stmt.executeQuery();
//		
//		while (rs.next()) {
//			Tarefas tarefa = new Tarefas();
//			tarefa.setId(rs.getInt("id"));
//			tarefa.setNome(rs.getString("nome"));
//			tarefa.setTag(rs.getString("tag"));
//			tarefa.setPessoa(rs.getString("pessoa"));
//			tarefas.add(tarefa);
//		}
//		rs.close();
//		stmt.close();
//		return tarefas;
//}
	
	}

