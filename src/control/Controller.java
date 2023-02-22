package control;

import java.sql.SQLException;

import modelo.Pessoas;
import modelo.dao.PessoasDAO;

public class Controller {
	
	
	public static void entrarValores(String nome, String telefone) throws ClassNotFoundException, SQLException {
		if(nome.isBlank() || telefone.isBlank()) {
			throw new RuntimeException("Informe nome e telefone.");
		}
		
		Pessoas p = new Pessoas();
		p.setNome(nome);
		p.setTelefone(telefone);
		insertValor(p);
	}
	
	private static void insertValor(Pessoas valor) throws ClassNotFoundException, SQLException{
		PessoasDAO dao = new PessoasDAO();
		dao.create(valor);
	}
}
