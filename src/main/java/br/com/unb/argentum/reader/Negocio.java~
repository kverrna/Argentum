package classes;
import java.util.Calendar;

public final class Negocio {
	
	//nomes de atributos não significativos
	private final double p;
	private final int qtd;
	private final Calendar d;

	public Negocio(double preco, int quantidade, Calendar data) {		
	
	//pode não ser responsabilidade do construtor validar atributo	
	if(data == null){
		throw new IllegalArgumentException("Data não pode ser nula");
	}
	
		this.p = preco;
		this.qtd = quantidade;
		this.d = data;
	}

	public double getPreco() {
		return p;
	}

	public int getQuantidade() {
		return qtd;
	}

	public Calendar getData() {
		return (Calendar) this.d.clone();
	}
	
	
	public double getVolume(){
		return p * qtd;
	}
	
}
