/**
 * 
 */
package fr.geomod.components.cmdecarte.basket.model;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.geomod.components.cmdecarte.basket.model.impl.BasketCellImpl;

/**
 * @author yhourri
 *
 */
public class BasketCellTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	
	/**
	 * 
	 */
	@Test
	public void test() {
		final String idRef = "Toto";
		final int edtn = 2;
		final int service = 3;
		
		BasketCell cell = new  BasketCellImpl(idRef, edtn, service);
		
		String idNew = cell.getCellId();
		assertEquals(idRef, idNew);
		
		int edtnNew = cell.getCellEdtn();
		assertEquals(edtn, edtnNew);
		
		int servicenew = cell.getCellService();
		assertEquals(service, servicenew);
		
		
		 
	}

}
