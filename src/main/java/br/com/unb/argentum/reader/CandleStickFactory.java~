package classes;
import java.util.List;
import java.util.Calendar;

public class CandleStickFactory {

	//método muito extenso, exerce várias funções
	public CandleStick constroiCandleParaData(Calendar data, List<Negocio> negocios){
		
		//validação pode ser feita em outro lugar do código
		if(negocios.isEmpty()){
			//pod-se substituir os '0's por uma constante
			return new CandleStick(0, 0, 0, 0, 0, Calendar.getInstance());
		}
		
		double maximo = negocios.get(0).getPreco();
		double minimo = negocios.get(0).getPreco();
		double volume = 0;	
		
		//poderia haver um método para exercer tal função
		for(Negocio negocio : negocios){
			volume += negocio.getVolume();
				
			if(negocio.getPreco() > maximo){
				maximo = negocio.getPreco();
			}else if(negocio.getPreco() < minimo){
					minimo = negocio.getPreco();
			}
		}
			
		double abertura = negocios.get(0).getPreco();
		double fechamento = negocios.get(negocios.size()-1).getPreco();
			
		return new CandleStick(abertura, fechamento, minimo, maximo, volume, data);
				
	}
		
}
