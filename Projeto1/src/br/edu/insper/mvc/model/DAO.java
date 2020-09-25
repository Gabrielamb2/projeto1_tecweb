package br.edu.insper.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.insper.Tarefas;


public class DAO {
	private Connection connection = null;
	public DAO() throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.jdbc.Driver");
	 connection = DriverManager.getConnection(
	"jdbc:mysql://localhost/meus_dados", "root", "SaraPs396984");
	}
	public List<Tarefas> getLista() throws SQLException {
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		PreparedStatement stmt = connection.
		 prepareStatement("SELECT * FROM Tarefas");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
		Tarefas tarefa = new Tarefas();
		tarefa.setId(rs.getInt("id"));
		tarefa.setNome(rs.getString("nome"));
		tarefa.setTag(rs.getString("tag"));
		tarefa.setPessoa(rs.getString("pessoa"));
		tarefas.add(tarefa);
		}
		rs.close();
		stmt.close();
		return tarefas;
}
	public void close() throws SQLException {
		connection.close();
	}
	public void adiciona(Tarefas tarefa) throws SQLException {
		String sql = "INSERT INTO Tarefas" +
		"(nome,tag,pessoa) values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,tarefa.getNome());
		stmt.setString(2,tarefa.getTag());
		stmt.setString(3,tarefa.getPessoa());
		stmt.execute();
		stmt.close();
		}
	
	public void altera(Tarefas tarefa) throws SQLException {
		String sql = "UPDATE Tarefas SET " +"nome=?, tag=?, pessoa=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getNome());
		stmt.setString(2, tarefa.getTag());
		stmt.setString(3, tarefa.getPessoa());
		stmt.setInt(4, tarefa.getId());
		stmt.execute();
		stmt.close();
	}
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM Tarefas WHERE id=?");
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
	public List<Tarefas>ordenar(String tipo) throws SQLException {
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pessoas ORDER BY ?");
		stmt.setString(1, tipo);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setNome(rs.getString("nome"));
			tarefa.setTag(rs.getString("tag"));
			tarefa.setPessoa(rs.getString("pessoa"));
			tarefas.add(tarefa);
		}
		rs.close();
		stmt.close();
		return tarefas;
}
	
	}

