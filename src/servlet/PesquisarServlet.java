package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Resultado;
import lucene.Recomendacao;

/**
 * Servlet implementation class PesquisarServlet
 */



@WebServlet("/pesquisar")
public class PesquisarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Resultado>resultado = Recomendacao.search(request.getParameter("nome"));
		Collections.sort(resultado);
		request.getSession().setAttribute("resultadoPesquisa", resultado);
		//request.setAttribute("resultadoPesquisa", resultado);
		//request.setAttribute("palavrachave", request.getParameter("nome"));
		request.getSession().setAttribute("palavrachave", request.getParameter("nome"));
		response.sendRedirect("pesquisa.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
