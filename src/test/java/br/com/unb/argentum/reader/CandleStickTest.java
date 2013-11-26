package br.com.unb.argentum.reader;

import static org.junit.Assert.*;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

import classes.CandleStick;

public class CandleStickTest {

	@Test(expected = IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueOMinimo() {
		new CandleStick(10, 20, 10, 5, 15, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void aberturaNaoPodeSerNegativo() {
		new CandleStick(-10, 20, 10, 15, 15, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void fechamentoNaoPodeSerNegativo() {
		new CandleStick(10, -20, 10, 15, 15, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void minimoNaoPodeSerNegativo() {
		new CandleStick(10, 20, -10, 15, 15, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void volumeNaoPodeSerNegativo() {
		new CandleStick(10, 20, 10, 15, -15, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void dataNaoPodeSerNula() {
		new CandleStick(10, 20, 10, 15, 15, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void maximoNaoPodeSerNegativo() {
		new CandleStick(20, 15, -18, -15, 15, Calendar.getInstance());
	}

	@Test
	public void testeGetData() {

		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 5);

		CandleStick candle = new CandleStick(10, 20, 10, 15, 15, c);

		Assert.assertEquals(5, candle.getData().DAY_OF_MONTH);
	}

	@Test
	public void testeIsAlta(){
		CandleStick candle = new CandleStick(10, 20, 10, 15, 15, Calendar.getInstance());
		
		Assert.assertTrue(candle.isAlta());
		Assert.assertFalse(candle.isBaixa());
	}
	
	@Test
	public void testeIsBaixa(){
		CandleStick candle = new CandleStick(20, 10, 10, 15, 15, Calendar.getInstance());
		
		Assert.assertTrue(candle.isBaixa());
		Assert.assertFalse(candle.isAlta());
	}
}
