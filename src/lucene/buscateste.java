package lucene;

import java.util.List;

import domain.Resultado;

public class buscateste {

	private static List<Resultado> vetors;
	//private static String vetors;

	public static void main(String[] args) {
		
		vetors = Recomendacao.search("galo");
		
		//System.out.println("teste");
		
		for (Resultado vetors  : vetors){
		System.out.println(vetors);
		//System.out.println("teste222");
		}
		

	}

}
