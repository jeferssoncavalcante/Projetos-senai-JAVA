package sp.senai.br.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sp.senai.br.dao.ClientesDao;

@WebServlet("/excluircliente")
public class ExcluirCliente extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtId = request.getParameter("txtId");
		int id = Integer.parseInt(txtId);
		
		ClientesDao clientes = new ClientesDao();
		clientes.excluirCliente(id);
		response.sendRedirect("/ClientesJSP-FINAL/listaclientes");
	}
}
