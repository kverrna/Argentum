package br.com.unb.argentum.reader;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import classes.Negocio;

public class NegocioTest {

	//Teste o m�todo getData deve retornar uma c�pia do objeto
	@Test
	public void dataDoNegocioEhImutavel() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negocio n = new Negocio(10,5,c);
		
		n.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
		
	}


	//Teste espera que uma exce��o seja lan�ada, e n�o permite que a data seja nula

	@Test(expected = IllegalArgumentException.class)
	public void negocioComDataNula() {
		new Negocio(5,10,null);
	}
	

}