/*
 * Implementa��o do Padr�o de Projeto Factory para os Candles, desta forma � necess�rio
 * um objeto do tipo CandleStickFactory para que a partir dele sejam criados os CandleSticks
 * 
 * 
 */

package br.com.unb.argentum.reader;

import java.util.List;
import java.util.Calendar;

public class CandleStickFactory {

	// M�todo para construir um candlestick para uma data e uma lista de
	// negocios

	public CandleStick constroiCandleParaData(Calendar data,
			List<Negocio> negocios) {
		// Se for passado uma lista de negocios vazia o CandleStick retornado
		// possui apenas zeros

		if (negocios.isEmpty()) {
			return new CandleStick(0, 0, 0, 0, 0, Calendar.getInstance());

		}
		// Atribui ao M�ximo e M�nino o mesmo valor

		double maximo = negocios.get(0).getPreco();
		double minimo = negocios.get(0).getPreco();
		double volume = 0;
		// Soma o volume de negocios do vetor

		for (Negocio negocio : negocios) {
			volume += negocio.getVolume();

			// Busca o maior valor do vetor

			if (negocio.getPreco() > maximo) {
				maximo = negocio.getPreco();
			}// Busca o menor valor

			else if (negocio.getPreco() < minimo) {
				minimo = negocio.getPreco();
			}
		}
		// Atribui valores de m�ximo e minimo

		double abertura = negocios.get(0).getPreco();
		double fechamento = negocios.get(negocios.size() - 1).getPreco();
		// Cria e retorna um CandleStick com os valores pesquisados

		return new CandleStick(abertura, fechamento, minimo, maximo, volume,
				data);

	}

}
