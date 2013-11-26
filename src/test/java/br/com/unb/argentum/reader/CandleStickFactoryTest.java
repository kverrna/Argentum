package br.com.unb.argentum.reader;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.unb.argentum.reader.CandleStick;
import br.com.unb.argentum.reader.CandleStickFactory;
import br.com.unb.argentum.reader.Negocio;

public class CandleStickFactoryTest {
	/*
	 * Teste cria uma lista de negocios e depois cria um Candlestick com as informa��es e testa-las
	 * utilizando os valores passados
	 *
	 */
@Mock
private CandleStick mockCandle;
private Negocio mockNegocio;
private CandleStickFactory candleFac = Mockito.spy(new CandleStickFactory());

//Mockito testa se CandleStickFactory est� criando um candlestick a partir de uma lista de negocios
	@Test
	public void sequenciaSimplesDeNegocios() {
		Calendar hoje = Calendar.getInstance();
		List <Negocio> negocios = Arrays.asList(mockNegocio);
		Mockito.doReturn(mockCandle).when(candleFac).constroiCandleParaData(hoje, negocios);
	}
	
	/*
	 * Teste deveria criar uma lista de negocios e depois criar um Candlestick com as informa��es e testa-las
	 *  porem como a lista de negocios � vazia o candlestick � gerado com zeros
	 *  
	 */

	@Test
	public void semNegociosGeraCandleComZeros(){
		Calendar hoje = Calendar.getInstance();
		
		List<Negocio> negocios = Arrays.asList();
		
		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		
		Assert.assertEquals(0.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(0.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(0.0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(0.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
	
	}
	
	/*
	 * Teste deveria criar uma lista de negocios e depois criar um Candlestick com as informa��es e testa-las
	 *  como s� existe um negocio os valores ser�o todos iguais
	 */

	@Test
	public void apenasUmNegocioGeraCandleComValoresIguais(){
		Calendar hoje = Calendar.getInstance();
		
		Negocio negocio1 = new Negocio(40.5, 100, hoje);
		
		List <Negocio> negocios = Arrays.asList(negocio1);
		
		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);
		
		
		
	}

}
