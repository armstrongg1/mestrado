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
 * Servlet implementation class AnaliseSentimento
 */
@WebServlet("/AnaliseSentimento")
public class AnaliseSentimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, List<String>>palavras = new HashMap<String, List<String>>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnaliseSentimento() {
    	super();
    	List<String>triste = new ArrayList<String>();
    	triste.add("deprimido");
        triste.add("insatisfeito");
        triste.add("desconfortável");
        triste.add("triste");
        triste.add("câncer");
        triste.add("morte");
        triste.add("doença");
        triste.add("solitário");
        triste.add("tristeza");
        triste.add("sofrimento");
        palavras.put("triste", triste);
        
    	List<String>feliz = new ArrayList<String>();
    	feliz.add("contente");
    	feliz.add("alegre");
    	feliz.add("encantado");
    	feliz.add("extasiado");
    	feliz.add("euforico");
        feliz.add("feliz");
        feliz.add("realização");
        feliz.add("elogio");
        
        palavras.put("feliz", feliz);
        
    	List<String>irritado = new ArrayList<String>();
    	irritado.add("acusado");
    	irritado.add("agressivo");
    	irritado.add("raiva");
    	irritado.add("zangado");
    	irritado.add("traição");
    	irritado.add("furioso");
    	irritado.add("irritado");
   
        palavras.put("irritado", irritado);
        
    	List<String>tenso = new ArrayList<String>();
    	tenso.add("condenacao");
    	tenso.add("contagio");
    	tenso.add("epidemia");
    	tenso.add("sentença");
    	tenso.add("punido");
    	tenso.add("tortura");
    	tenso.add("medo");
    	tenso.add("tenso");
    	tenso.add("explosão");
    	
        palavras.put("tenso", tenso);
        
    	List<String>angustiado = new ArrayList<String>();
    	angustiado.add("aborto");
    	angustiado.add("emergência");
    	angustiado.add("angustiado");
    	angustiado.add("expectativa");
    	angustiado.add("falhar");
    	angustiado.add("refém");	
    	angustiado.add("inseguro");
    	angustiado.add("ciúme");
    	angustiado.add("ansiedade");
    	angustiado.add("ansioso");
    
        palavras.put("angustiado", angustiado);
        
    	List<String>entediado = new ArrayList<String>();
    	entediado.add("apático");
    	entediado.add("tédio");
    	entediado.add("monotóno");
    	entediado.add("desgastado");
    	entediado.add("aborrecido");
    	entediado.add("ocioso");
    	entediado.add("entediado");
    	
   
        palavras.put("entediado", entediado);
        
        List<String>cansado = new ArrayList<String>();
        cansado.add("ressaca");
        cansado.add("derrotado");
        cansado.add("mal-humorado");
        cansado.add("sono");
        cansado.add("fraco");
        cansado.add("cansado");
        
       
        palavras.put("cansado", cansado);
        
        List<String>sonolento = new ArrayList<String>();
        sonolento.add("dor");
        sonolento.add("alcool");
        sonolento.add("preguiça");
        sonolento.add("bêbado");
        sonolento.add("lerdo");
        sonolento.add("desatento");
        sonolento.add("sonolento");
        
    
        palavras.put("sonolento", sonolento);
        
        List<String>sereno = new ArrayList<String>();
        sereno.add("tranquilo");
        sereno.add("manso");
        sereno.add("ordeiro");
        sereno.add("civilizado");
        sereno.add("paciência");
        sereno.add("sereno");
        
    
        palavras.put("sereno", sereno);
        
        List<String>satisfeito = new ArrayList<String>();
        satisfeito.add("elogio");
        satisfeito.add("prêmio");
        satisfeito.add("recompensa");
        satisfeito.add("campeão");
        satisfeito.add("sucesso");
        satisfeito.add("satisfeito");
           
    
    
        palavras.put("satisfeito", satisfeito);
        
        List<String>encantado = new ArrayList<String>();
        encantado.add("brilhante");
        encantado.add("aplauso");
        encantado.add("atraente");
        encantado.add("emocionante");
        encantado.add("mágico");
        encantado.add("apaixonado");
        encantado.add("sensacional");
        encantado.add("encantado");        
    	
        palavras.put("encantado", encantado);
        
        List<String>animado = new ArrayList<String>();
        animado.add("divertido");
        animado.add("animar");
        animado.add("entusiasmo");
        animado.add("diversão");
        animado.add("rindo");
        animado.add("empolgado");
        animado.add("animado");        
    	
        palavras.put("animado", animado);
       
    	
    
          
          
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String>sentimento = palavras.get(request.getParameter("sentimento"));
		
		System.out.println("OK");
		System.out.println(request.getParameter("sentimento"));
		
		
		//List<String>SentimentoTriste = palavras.get("SentimentoTriste");
		//List<String>SentimentoFeliz = palavras.get("SentimentoFeliz");
		//List<String>SentimentoIrritado = palavras.get("SentimentoIrritado");
		//List<String>SentimentoTenso = palavras.get("SentimentoTenso");
		//List<String>SentimentoAngustiado = palavras.get("SentimentoAngustiado");
		//List<String>SentimentoEntediado = palavras.get("SentimentoEntediado");
		//List<String>sentimentoCansado = palavras.get("sentimentoCansado");
		//List<String>sentimentoSonolento = palavras.get("SentimentoSonolento");
		//List<String>sentimentoSereno = palavras.get("SentimentoSereno");
		//List<String>sentimentoSatisfeito = palavras.get("SentimentoSatisfeito");
		//List<String>sentimentoEncantado = palavras.get("SentimentoEncantado");
		//List<String>sentimentoAnimado = palavras.get("SentimentoAnimado");

		
		//Map<String, Float>melhores = new HashMap<String, Float>();
		//String filme = request.getParameter("titulo");
		
		//int resultadoTriste = 0;
		//int resultadoFeliz = 0;
		//int resultadoIrritado = 0;
		//int resultadoTenso = 0;
		//int resultadoAngustiado = 0;
		//int resultadoEntediado = 0;
		//int resultadoCansado = 0;
		//int resultadoSonolento = 0;
		//int resultadoSereno = 0;
		//int resultadoSatisfeito = 0;
		//int resultadoEncantado = 0;
		//int resultadoAnimado = 0;
		System.out.println("ok3");
		
		//List<String>palavrasChave = palavras.get(request.getParameter("titulo"));
		Map<String, Float>melhores = new HashMap<String, Float>();
		System.out.println("ok4");
		
		for(String palavraSentimento: sentimento){
			System.out.println("ok5");
			System.out.println(palavraSentimento);
			List<Resultado>resultados = Recomendacao.search(palavraSentimento);
			for(Resultado resultado: resultados){
				//if(!resultado.getCaminho().equals(request.getParameter("titulo"))){
					if(melhores.get(resultado.getCaminho()) != null){
						melhores.put(resultado.getCaminho(), melhores.get(resultado.getCaminho()) + resultado.getScore());
					}else{
						melhores.put(resultado.getCaminho(), resultado.getScore());
					}
				//}
			}
		}
		
		System.out.println("ok2");
		
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
		
		request.getSession().setAttribute("maiorsentimento", maior);
		request.getSession().setAttribute("todossentimentos", resultado);
		request.getSession().setAttribute("presentimento", request.getParameter("sentimento"));
		response.sendRedirect("sentimentos.jsp");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
