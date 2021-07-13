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

@WebServlet("/detalhacliente")
public class DetalhaCliente extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtId = request.getParameter("txtId");
		int id = Integer.parseInt(txtId);
		
		ClientesDao clientesDao = new ClientesDao();
		Cliente cliente = clientesDao.buscarPorId(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("detalhacliente.jsp");
		request.setAttribute("detalha", cliente);
		dispatcher.forward(request, response);
	}
}
