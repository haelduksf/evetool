/**
 * 
 */
package com.hael.evetool.jUnit;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hael.evetool.dao.NavDAO;
import com.hael.evetool.domain.MapSolarSystem;
import com.hael.evetool.domain.SolarSystem;
import com.hael.evetool.exception.NotARealSolarSystemException;

/**
 * @author alecross
 * 
 */
public class NavDaoTest {

	NavDAO tester;

	@Before
	public void setup() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"springConfig.xml");
		tester = context.getBean(com.hael.evetool.dao.NavDAO.class);
		
	}
	
	@Test
	public void testGetNeighbours() throws Exception {
		List<Integer> neighbours = tester.getNeighbours(30000001);
		List<Integer> expected = Arrays.asList(30000003, 30000005, 30000007);
		Assert.assertEquals(expected, neighbours);
		neighbours = tester.getNeighbours(31000001);
		expected = Arrays.asList();
		Assert.assertEquals(expected, neighbours);
	}
	
	@Test
	public void testIsRealSystem() throws Exception {
		Assert.assertTrue(tester.isRealSystem("Jita"));
		Assert.assertTrue(tester.isRealSystem("JITA"));
		Assert.assertTrue(tester.isRealSystem("jita"));
		Assert.assertTrue(tester.isRealSystem("Jita "));
		Assert.assertTrue(tester.isRealSystem("j213058"));
		Assert.assertTrue(tester.isRealSystem("GE-8JV"));
		
		Assert.assertFalse(tester.isRealSystem("Jyta"));
		Assert.assertFalse(tester.isRealSystem(""));
		Assert.assertFalse(tester.isRealSystem(null));
		
	}
	
	@Test
	public void testGetSolarSystem() throws Exception {
		int errors = 0;
		MapSolarSystem expectedMap = (new MapSolarSystem());
		expectedMap.setSolarSystemName("Jita");
		expectedMap.setSolarSystemID(30000142);
		SolarSystem expected = new SolarSystem(expectedMap);
		SolarSystem actual = tester.getSystem("Jita");
		Assert.assertEquals(expected, actual);
		
		
		expectedMap.setSolarSystemID(31000498);
		expectedMap.setSolarSystemName("J213058");
		actual = tester.getSystem("J213058");
		Assert.assertEquals(expected, actual);
		
		try {
			tester.getSystem("hsadfh");
		} catch (NotARealSolarSystemException e) {
			errors++;			
		}
		Assert.assertEquals(1, errors);
		try {
			tester.getSystem(null);
		} catch (NotARealSolarSystemException f) {
			errors++;
		}
		Assert.assertEquals(2, errors);
		
	}
	
	@Test
	public void testSystemNameLookup() {
		
	}
}
