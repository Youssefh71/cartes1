/**
 * 
 */
package fr.geomod.components.cmdecarte.basket.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketCellImpl;

/**
 * @author yhourri
 *
 */
public class BasketCellTest {


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
