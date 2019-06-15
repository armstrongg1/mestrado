package domain;

public class Resultado implements Comparable<Resultado>{
	private String caminho;
	private Float score;
	
	
	public Resultado(String caminho, Float score){
		this.caminho = caminho;
		this.score = score;
	}

	public String getCaminho() {
		return caminho;
	}


	public Float getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return caminho.toUpperCase() + " " + score;
	}

	@Override
	public int compareTo(Resultado o) {
		return o.getScore().compareTo(this.getScore());
	}
	
}
