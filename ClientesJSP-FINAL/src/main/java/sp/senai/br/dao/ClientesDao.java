package sp.senai.br.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sp.senai.br.model.Cliente;


public class ClientesDao {
	private String stringConexao = "jdbc:mysql://localhost/avaliacaofinal?useTimezone=true&serverTimezone=UTC";
	private String usuario = "root";
	private String senha = "pepe5686";
	
	private Connection conexao = null;
	
	public boolean conectar() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conexao = DriverManager.getConnection(stringConexao, usuario, senha);
			return true;
		}catch(SQLException e1) {
			return false;
		}
	}
	
	public List<Cliente> listarCliente() {
		
		if (conectar()) {
			String sql = "SELECT id, nome, telefone, endereco FROM avaliacaofinal.clientes";
			
			List<Cliente> lista = new ArrayList<Cliente>();
			try {
				Statement acaoSql = conexao.createStatement();
				acaoSql.execute(sql);
				ResultSet rs = acaoSql.getResultSet();
				while (rs.next()) {	
					Cliente a = new Cliente();
					a.setIdCliente(rs.getInt("id"));
					a.setNomeCliente(rs.getString("nome"));
					a.setTelefoneCliente(rs.getString("telefone"));
					a.setEnderecoCliente(rs.getString("endereco"));
					lista.add(a);
				}
				
			} catch (SQLException e) {
				return null;
			}		
			return lista;
		}
		return null;
	}

	public boolean novoCliente (Cliente cliente) {
		if (conectar()) {
			String sql = "insert into avaliacaofinal.clientes (nome, telefone, endereco)"
					+ "values('" + cliente.getNomeCliente()
					+ "', '" + cliente.getTelefoneCliente()
					+ "', '" + cliente.getEnderecoCliente() + "')";
			try {
				Statement acaoSql = conexao.createStatement();
				acaoSql.execute(sql);
			} catch (SQLException e) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
	
	public boolean excluirCliente(int id) {
		if (conectar()) {
			String sql = "delete from avaliacaofinal.clientes where id = " + id;
			
			try {
				Statement acaoSql = conexao.createStatement();
				acaoSql.execute(sql);
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}
	
	public Cliente buscarPorId(int id) {
		if (conectar()) {
			String sql = "select id, nome, telefone, endereco from avaliacaofinal.clientes where id = " + id;
			
			try {
				Statement acaoSql = conexao.createStatement();
				acaoSql.execute(sql);
				ResultSet rs = acaoSql.getResultSet();
				
				if (rs.next()) {
					Cliente a = new Cliente();
					a.setIdCliente(rs.getInt("id"));	
					a.setNomeCliente(rs.getString("nome"));
					a.setTelefoneCliente(rs.getString("telefone"));
					a.setEnderecoCliente(rs.getString("endereco"));
					return a;
				}
				return null;
			} catch (SQLException e) {
				return null;
			}	
		}
		return null;
	}
	
	public boolean alterarCliente(Cliente a) {
		if (conectar()) {
			String sql = 
					" UPDATE avaliacaofinal.clientes "
							+ " SET nome = ?, "
							+ " telefone = ?, "
							+ " endereco = ? "
							+ " WHERE id = ? ";
			try {
				//Statement acaoSql = conexao.createStatement();
				PreparedStatement acaoSql = conexao.prepareStatement(sql);
				acaoSql.setString(1, a.getNomeCliente());
				acaoSql.setString(2, a.getTelefoneCliente());
				acaoSql.setString(3, a.getEnderecoCliente());
				acaoSql.setInt(4, a.getIdCliente());
				acaoSql.executeUpdate();	
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}
}
