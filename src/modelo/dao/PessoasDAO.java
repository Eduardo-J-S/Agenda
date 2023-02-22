package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import modelo.Pessoas;

public class PessoasDAO {
	
	public void create(Pessoas p) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO pessoas (telefone,nome) VALUES (?, ?)");
			stmt.setString(1, p.getTelefone());
			stmt.setString(2, p.getNome());
			
			stmt.executeUpdate();
			
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Pessoas> read() throws ClassNotFoundException, SQLException{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Pessoas> pessoas = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM pessoas");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Pessoas pessoa = new Pessoas();
				
				pessoa.setNome(rs.getString("nome"));
				pessoa.setTelefone(rs.getString("nome"));
				pessoas.add(pessoa);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return pessoas;
	}
}
