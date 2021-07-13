package sp.senai.aluno2.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sp.senai.aluno2.model.Aluno2;


@RestController
@RequestMapping("/aluno2")
public class aluno2Controller {
	private String urlConexao = "jdbc:mysql://localhost/exercicio1504?useTimezone=true&serverTimezone=UTC";
	private String usuario = "root";
	private String senha = "pepe5686";
	private Connection conexao = null;
	
	
	private boolean Conectar() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conexao = (DriverManager.getConnection(urlConexao, usuario, senha));
			return true;
		}catch(SQLException e1) {
			System.out.println(e1.getMessage());
			return false;
		}	
	}
	@GetMapping
	public List<Aluno2> listarAluno(){
	  if (Conectar()) {
		String sql = "select id, nome, telefone, status from exercicio1504.alunos";
		
		List<Aluno2> lista = new ArrayList<Aluno2>();
		try {
			Statement acaoSql = conexao.createStatement();
			acaoSql.execute(sql);
			ResultSet rs = acaoSql.getResultSet();
			while(rs.next()) {
				Aluno2 a = new Aluno2();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				a.setTelefone(rs.getString("telefone"));
				a.setStatus(rs.getString("status"));
				lista.add(a);
			}
		} catch (SQLException e) {
			return null;
		}
		return lista;
	  }
		return null;
	}
	@GetMapping("/{id}")
	public Aluno2 buscarPorId(@PathVariable int id, String nome) {
		if (Conectar()) {
			String sql = "select id, nome, telefone, status FROM exercicio1504.alunos WHERE id = " + id;
			
			try {
				Statement acaoSql = conexao.createStatement();
				acaoSql.execute(sql);
				ResultSet rs = acaoSql.getResultSet();
				if (rs.next()) {
					Aluno2 a = new Aluno2();
					a.setId(id);
					a.setNome(rs.getString("nome"));
					a.setTelefone(rs.getString("telefone"));
					a.setStatus(rs.getString("status"));
					return a;
				}
				return null;	
			} catch (SQLException e) {
				return null;
			}		
		}
		return null;
	}
	@PostMapping
	public boolean inserir(@RequestBody Aluno2 aluno2) {
		if (Conectar()) {
			String sql = String.format("insert into exercicio1504.alunos (nome, telefone, status) "
					+ "values ('%s', '%s', '%s' )", 
					aluno2.getNome(), aluno2.getTelefone(), aluno2.getStatus());
			try {
				Statement acaoSql = conexao.createStatement();
				acaoSql.execute(sql);
				return true;
			}catch (SQLException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		return false;		
	}
	@PutMapping("/{id}")
	private boolean alterar(@RequestBody Aluno2 a, @PathVariable int id) {
		if (Conectar()) {
			String sql = "update exercicio1504.alunos set nome = ?, telefone = ?, status = ? where id = ? ";
			
			try {
				//Statement acaoSql = conexao.createStatement();
				PreparedStatement acaoSql = conexao.prepareStatement(sql);
				acaoSql.setString(3, a.getStatus());
				acaoSql.setString(1, a.getNome());
				acaoSql.setString(2, a.getTelefone());
				acaoSql.setInt(4, id);
				acaoSql.executeUpdate();
				return true;		
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		return false;
	}
	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable int id) {
		if (Conectar()) {
			String sql = "delete from exercicio1504.alunos where id =" + id;
			try {
				Statement acaoSql = conexao.createStatement();
				acaoSql.execute(sql);
				return true;
			}catch (SQLException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		return false;
	}
}