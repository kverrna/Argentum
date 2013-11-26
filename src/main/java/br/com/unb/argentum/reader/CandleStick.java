/*
 * O candlestick representa graficamente a varia��o de pre�os de um determinado ativo na bolsa de valores em uma unidade de tempo, nele est�o representados:
 *
 *   Pre�o de abertura - � o pre�o pelo qual foi fechado o primeiro neg�cio do intervalo.
 *   Pre�o de fechamento - � o pre�o pelo qual foi fechado o �ltimo neg�cio do intervalo.
 *   Pre�o m�ximo - � o maior pre�o negociado no intervalo.
 *   Pre�o m�nimo - � o menor pre�o negociado no intervalo.
 *	
 */

package br.com.unb.argentum.reader;

import java.util.Calendar;

public final class CandleStick {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;
	
	public CandleStick(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {
		
		if(maximo<minimo)
		{
			throw new IllegalArgumentException("Valor máximo não pode ser menor que o minimo");
		}
		
		if(abertura<0)
		{
			throw new IllegalArgumentException("Abertura não pode ser negativo");
		}
		
		if(fechamento<0)
		{
			throw new IllegalArgumentException("Fechamento não pode ser negativo");
		}
		
		if(maximo<0)
		{
			throw new IllegalArgumentException("Máximo não pode ser negativo");
		}
		
		if(minimo<0)
		{
			throw new IllegalArgumentException("Minimo não pode ser negativo");
		}
		
		if(volume<0)
		{
			throw new IllegalArgumentException("Volume não pode ser negativo");
		}
		
		if(data == null)
		{
			throw new IllegalArgumentException("Data não pode ser nula");
		}
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}	

	
	public boolean isAlta(){
		return this.abertura < this.fechamento;
	}
	
	public boolean isBaixa(){
		return this.abertura > this.fechamento;
	}
	
}
