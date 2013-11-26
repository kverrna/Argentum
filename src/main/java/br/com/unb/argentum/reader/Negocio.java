/*
 * Para calcular as informa��es necess�rias para a constru��o de um Candlestick, s�o necess�rios os dados de
 * todos as negocia��es (trades) de um dia.Uma negocia��o tem as seguintes informa��es:
 * 
 *  Pre�o: Pelo qual foi vendido;
 *  
 * 	Quantidade: De Ativos;
 * 
 *  Data: Em que foi executado;
 * 
 */

package br.com.unb.argentum.reader;

import java.util.Calendar;
import java.util.List;

public final class Negocio {

	private final double preco;
	private final int quantidade;
	private final Calendar data;

	// Apenas um m�todo contrutor de um negocio

	public Negocio(double preco, int quantidade, Calendar data) {
		// Valida��o para data n�o poder ser nula

		if (data == null) {
			throw new IllegalArgumentException("Data não pode ser nula");
		}

		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	//M�todos Getters

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	// O getData deve retornar uma c�pia da instancia de calendar

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}

	public double getVolume() {
		return preco * quantidade;
	}

}
