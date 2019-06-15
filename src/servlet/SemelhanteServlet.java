package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Resultado;
import lucene.Recomendacao;

/**
 * Servlet implementation class SemelhanteServlet
 */
@WebServlet("/semelhante")
public class SemelhanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, List<String>>palavras = new HashMap<String, List<String>>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemelhanteServlet() {
        super();
        
        
        List<String>titulo1 = new ArrayList<String>();
  	  titulo1.add("verdade");
  	  titulo1.add("tempo");
  	  titulo1.add("amizade");
  	  titulo1.add("vida");
  	  titulo1.add("noite");
  	  titulo1.add("sinto");
  	  titulo1.add("amor");
  	  titulo1.add("ano");
  	  titulo1.add("claro");
  	  titulo1.add("garota");
        palavras.put("Amor ou Amizade.pt.srt", titulo1);
        
        List<String>titulo2 = new ArrayList<String>();
        titulo2.add("amigo");
        titulo2.add("corrida");
        titulo2.add("carro");
        titulo2.add("reboque");
        titulo2.add("professor");
        titulo2.add("mundo");
        titulo2.add("claro");
        titulo2.add("falar");
        titulo2.add("combust�vel");
        titulo2.add("bomba");
        palavras.put("Carros 2.pt.srt", titulo2);
        
        List<String>titulo3 = new ArrayList<String>();
        titulo3.add("noite");
        titulo3.add("deus");
        titulo3.add("m�e");
        titulo3.add("virgem");
        titulo3.add("pessoas");
        titulo3.add("diabo");
        titulo3.add("genial");
        titulo3.add("garotos");
        titulo3.add("casa");
        titulo3.add("caldeir�o");
        palavras.put("Garota Infernal.pt.srt", titulo3);
        
        List<String>titulo4 = new ArrayList<String>();
        titulo4.add("sargento");
        titulo4.add("casa");
        titulo4.add("vivo");
        titulo4.add("pessoas");
        titulo4.add("dom");
        titulo4.add("m�e");
        titulo4.add("deus");
        titulo4.add("torre");
        titulo4.add("dia");
        titulo4.add("tempo");
        palavras.put("World Trade Center.pt.srt", titulo4);
        
        List<String>titulo5 = new ArrayList<String>();
        titulo5.add("brinquedos");
        titulo5.add("lixo");
        titulo5.add("brincar");
        titulo5.add("juntos");
        titulo5.add("casa");
        titulo5.add("faculdade");
        titulo5.add("crian�as");
        titulo5.add("trabalho");
        titulo5.add("cuidado");
        titulo5.add("amigos");
        palavras.put("Toy Story 3.pt.srt", titulo5);
        
        List<String>titulo6 = new ArrayList<String>();
        titulo6.add("casa");
        titulo6.add("crian�as");
        titulo6.add("cabana");
        titulo6.add("deus");
        titulo6.add("querida");
        titulo6.add("claro");
        titulo6.add("ballet");
        titulo6.add("floresta");
        titulo6.add("desculpe");
        titulo6.add("beb�");
        palavras.put("Todo Mundo em Panico 5.pt.srt", titulo6);
        
        List<String>titulo7 = new ArrayList<String>();
        titulo7.add("bom");
        titulo7.add("�timo");
        titulo7.add("sinto");
        titulo7.add("revista");
        titulo7.add("casa");
        titulo7.add("empresa");
        titulo7.add("trabalho");
        titulo7.add("chefe");
        titulo7.add("an�ncios");
        titulo7.add("mundo");
        palavras.put("Em Boa Companhia.pt.srt", titulo7);
        
        List<String>titulo8 = new ArrayList<String>();
        titulo8.add("homem-aranha");
        titulo8.add("noite");
        titulo8.add("aranha");
        titulo8.add("senhor");
        titulo8.add("tio");
        titulo8.add("fotografia");
        titulo8.add("cidade");
        titulo8.add("homem");
        titulo8.add("tempo");
        titulo8.add("namorada");
        palavras.put("Homem-Aranha.pt.srt", titulo8);
        
        List<String>titulo9 = new ArrayList<String>();
        titulo9.add("m�e");
        titulo9.add("china");
        titulo9.add("casaco");
        titulo9.add("pessoas");
        titulo9.add("lutar");
        titulo9.add("homem");
        titulo9.add("�gua");
        titulo9.add("ganhar");
        titulo9.add("r�pido");
        titulo9.add("torneio");
        palavras.put("Karate Kid.pt.srt", titulo9);
        
        List<String>titulo10 = new ArrayList<String>();
        titulo10.add("mestre");
        titulo10.add("panda");
        titulo10.add("kung");
        titulo10.add("massa");
        titulo10.add("pergaminho");
        titulo10.add("ingrediente");
        titulo10.add("guerreiro");
        titulo10.add("sonho");
        titulo10.add("destino");
        titulo10.add("pris�o");
        palavras.put("Kung Fu Panda.pt.srt", titulo10);
        
        List<String>titulo11 = new ArrayList<String>();
        titulo11.add("papai");
        titulo11.add("smurf");
        titulo11.add("azul");
        titulo11.add("lua");
        titulo11.add("desastrado");
        titulo11.add("gente");
        titulo11.add("casa");
        titulo11.add("cruel");
        titulo11.add("socorro");
        titulo11.add("g�nio");
        palavras.put("Os.Smurfs.2011.720p-HDC.AC3.5.1.DUAL-ZMG.srt", titulo11);
        
        List<String>titulo12 = new ArrayList<String>();
        titulo12.add("pai");
        titulo12.add("deus");
        titulo12.add("terremoto");
        titulo12.add("m�e");
        titulo12.add("falha");
        titulo12.add("filha");
        titulo12.add("nevada");
        titulo12.add("amo");
        titulo12.add("querida");
        titulo12.add("helic�ptero");
        palavras.put("Terremoto.A.Falha.de.San.Andreas.2015.720p.BluRay.x264-SPARKS.DUAL-KALAZANS.srt", titulo12);
        
        List<String>titulo13 = new ArrayList<String>();
        titulo13.add("medicamentos");
        titulo13.add("deus");
        titulo13.add("terrorismo");
        titulo13.add("cia");
        titulo13.add("impedir");
        titulo13.add("seguro");
        titulo13.add("fronteira");
        titulo13.add("calma");
        titulo13.add("cabe�a");
        titulo13.add("pessoas");
        palavras.put("Homeland.pt.srt", titulo13);
        
        
        List<String>titulo14 = new ArrayList<String>();
        titulo14.add("pai");
        titulo14.add("m�e");
        titulo14.add("ovos");
        titulo14.add("�rvore");
        titulo14.add("casa");
        titulo14.add("escola");
        titulo14.add("jardim");
        titulo14.add("sorvete");
        titulo14.add("beijo");
        titulo14.add("dinheiro");
        palavras.put("O Primeiro Amor.pt.srt", titulo14);
        
        List<String>titulo15 = new ArrayList<String>();
        titulo15.add("b�blia");
        titulo15.add("atira");
        titulo15.add("tanques");
        titulo15.add("tanque");
        titulo15.add("mata");
        titulo15.add("fogo");
        titulo15.add("sargento");
        titulo15.add("trabalho");
        titulo15.add("matar");
        titulo15.add("flanco");
        palavras.put("Coracoes.de.Ferro.2015.720p.BluRay.x264-SPARKS.DUAL-RK.srt", titulo15);
        
        List<String>titulo16 = new ArrayList<String>();
        titulo16.add("chefe");
        titulo16.add("doutor");
        titulo16.add("b�ffalo");
        titulo16.add("senadora");
        titulo16.add("agente");
        titulo16.add("tempo");
        titulo16.add("menina");
        titulo16.add("sargento");
        titulo16.add("olhos");
        titulo16.add("pele");
        palavras.put("O Silencio dos Inocentes.pt.srt", titulo16);
        
        List<String>titulo17 = new ArrayList<String>();
        titulo17.add("capit�o");
        titulo17.add("voar");
        titulo17.add("mam�e");
        titulo17.add("sombra");
        titulo17.add("m�e");
        titulo17.add("meninos");
        titulo17.add("papai");
        titulo17.add("filha");
        titulo17.add("ilha");
        titulo17.add("enantada");
        palavras.put("Peter Pan.pt.srt", titulo17);
        
        List<String>titulo18 = new ArrayList<String>();
        titulo18.add("ilha");
        titulo18.add("medo");
        titulo18.add("fantasma");
        titulo18.add("cachorro");
        titulo18.add("amuleto");
        titulo18.add("criaturas");
        titulo18.add("castelo");
        titulo18.add("amigo");
        titulo18.add("equipe");
        titulo18.add("amuleto");
        palavras.put("Scooby-Doo.pt.srt", titulo18);
        
        List<String>titulo19 = new ArrayList<String>();
        titulo19.add("agente");
        titulo19.add("amor");
        titulo19.add("diretor");
        titulo19.add("tempo");
        titulo19.add("fbi");
        titulo19.add("hora");
        titulo19.add("cabana");
        titulo19.add("arma");
        titulo19.add("seguran�a");
        titulo19.add("jogar");
        palavras.put("The Blacklist.pt.srt", titulo19);
        
        List<String>titulo20 = new ArrayList<String>();
        titulo20.add("deus");
        titulo20.add("diabo");
        titulo20.add("cristo");
        titulo20.add("casa");
        titulo20.add("esp�rito");
        titulo20.add("medo");
        titulo20.add("padre");
        titulo20.add("jesus");
        titulo20.add("filho");
        titulo20.add("m�e");
        palavras.put("O Ritual.pt.srt", titulo20);
        
        
        
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String>palavrasChave = palavras.get(request.getParameter("titulo"));
		Map<String, Float>melhores = new HashMap<String, Float>();
		for(String palavraChave: palavrasChave){
			List<Resultado>resultados = Recomendacao.searchsemelhante(palavraChave);
			for(Resultado resultado: resultados){
				if(!resultado.getCaminho().equals(request.getParameter("titulo"))){
					if(melhores.get(resultado.getCaminho()) != null){
						melhores.put(resultado.getCaminho(), melhores.get(resultado.getCaminho()) + resultado.getScore());
					}else{
						melhores.put(resultado.getCaminho(), resultado.getScore());
					}
				}
			}
		}
		
		List<Resultado>resultado = new ArrayList<Resultado>();
		Resultado maior = null;
		for(String caminho: melhores.keySet()){
			resultado.add(new Resultado(caminho, melhores.get(caminho)));
			if(maior == null){
				maior = new Resultado(caminho, melhores.get(caminho));
			}else{
				if(maior.getScore() < melhores.get(caminho)){
					maior = new Resultado(caminho, melhores.get(caminho));
				}
			}
			
		}
		Collections.sort(resultado);
		
		request.getSession().setAttribute("maior", maior);
		request.getSession().setAttribute("todos", resultado);
		request.getSession().setAttribute("pretitulo", request.getParameter("titulo"));
		response.sendRedirect("titulosemelhantes.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
