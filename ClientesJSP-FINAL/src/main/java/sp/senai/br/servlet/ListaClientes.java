package sp.senai.br.servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import sp.senai.br.dao.ClientesDao;
import sp.senai.br.model.Cliente;

@WebServlet("/listaclientes")
public class ListaClientes extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientesDao clientesDao = new ClientesDao();
		List<Cliente> lista = clientesDao.listarCliente();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listaclientes.jsp");
		request.setAttribute("lista", lista);
		dispatcher.forward(request, response);
	}
}
