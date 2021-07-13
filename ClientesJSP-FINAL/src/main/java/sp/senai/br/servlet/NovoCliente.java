package sp.senai.br.servlet;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sp.senai.br.dao.ClientesDao;
import sp.senai.br.model.Cliente;

@WebServlet("/novocliente")
public class NovoCliente extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = null;
		try {
			String nome = request.getParameter("txtNome");
			String telefone = request.getParameter("txtTelefone");
			String endereco = request.getParameter("txtEndereco");
			
			cliente = new Cliente();
			cliente.setNomeCliente(nome);
			cliente.setTelefoneCliente(telefone);
			cliente.setEnderecoCliente(endereco);
		}catch (Exception e) {
			throw new IOException("Erro nos parâmetros enviados! " + e.getMessage());
		}
		
		ClientesDao clientesDao = new ClientesDao();
		clientesDao.novoCliente(cliente);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/novocliente.jsp");
		request.setAttribute("cliente", cliente);
		dispatcher.forward(request, response);
	}
}
