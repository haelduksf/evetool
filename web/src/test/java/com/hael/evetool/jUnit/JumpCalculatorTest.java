/**
 * Test class for JumpCalculator
 */
package com.hael.evetool.jUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hael.evetool.JumpCalculatorImpl;
import com.hael.evetool.dao.NavDAO;
import com.hael.evetool.dao.NavDAOImpl;
import com.hael.evetool.domain.SolarSystem;
import com.hael.evetool.exception.NoPathExistsException;
import com.hael.evetool.exception.NotARealSolarSystemException;

/**
 * @author alecross
 * 
 */
public class JumpCalculatorTest {

	private static final Logger log = LoggerFactory.getLogger(JumpCalculatorTest.class);
	JumpCalculatorImpl tester;
	NavDAO mockDao = Mockito.mock(NavDAOImpl.class);
	SolarSystem a, b, c, d, e, x, y, z;
	
	/**
	 * Sets up a mock universe for testing.
	 * @throws IOException if db access fails
	 * @throws NotARealSolarSystemException if a bad solar system is sought
	 */
	@Before
	public void setup() throws IOException, NotARealSolarSystemException {
		tester = new JumpCalculatorImpl();
		tester.setDao(mockDao);

		a = Mockito.mock(SolarSystem.class);
		b = Mockito.mock(SolarSystem.class);
		c = Mockito.mock(SolarSystem.class);
		d = Mockito.mock(SolarSystem.class);
		e = Mockito.mock(SolarSystem.class);
		x = Mockito.mock(SolarSystem.class);
		y = Mockito.mock(SolarSystem.class);
		z = Mockito.mock(SolarSystem.class);

		Mockito.stub(a.getName()).toReturn("a");
		Mockito.stub(b.getName()).toReturn("b");
		Mockito.stub(c.getName()).toReturn("c");
		Mockito.stub(d.getName()).toReturn("d");
		Mockito.stub(e.getName()).toReturn("e");
		
		Mockito.stub(a.getSecurity()).toReturn(1f);
		Mockito.stub(b.getSecurity()).toReturn(1f);
		Mockito.stub(c.getSecurity()).toReturn(1f);
		Mockito.stub(d.getSecurity()).toReturn(1f);
		Mockito.stub(e.getSecurity()).toReturn(0f);

		Mockito.stub(a.getNeighbours()).toReturn(Arrays.asList(e, b));
		Mockito.stub(b.getNeighbours()).toReturn(Arrays.asList(a, c));
		Mockito.stub(c.getNeighbours()).toReturn(Arrays.asList(b, d));
		Mockito.stub(d.getNeighbours()).toReturn(Arrays.asList(c, e));
		Mockito.stub(e.getNeighbours()).toReturn(Arrays.asList(d, a));
		Mockito.stub(x.getNeighbours()).toReturn(new ArrayList<SolarSystem>());
		Mockito.stub(y.getNeighbours()).toReturn(Arrays.asList(z));
		Mockito.stub(z.getNeighbours()).toReturn(Arrays.asList(y));

		Mockito.stub(mockDao.getSystem("a")).toReturn(a);
		Mockito.stub(mockDao.getSystem("d")).toReturn(d);
		Mockito.stub(mockDao.getSystem("x")).toReturn(x);
		Mockito.stub(mockDao.getSystem("y")).toReturn(y);
		Mockito.stub(mockDao.getSystem("z")).toReturn(z);
	}

	/**
	 * Test method for
	 * {@link com.hael.evetool.JumpCalculatorImpl#shortestRoute(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws Exception 
	 */
	@Test
	public void testShortestRoute() throws Exception {
		

		List<SolarSystem> result = tester.shortestRoute("a", "d", -1, 1);
		Assert.assertEquals(Arrays.asList(a, e, d), result);
		result = tester.shortestRoute("a", "d", 0.5f, 1);
		Assert.assertEquals(Arrays.asList(a, b, c, d), result);
	}
	
	/**
	 * Test method for
	 * {@link com.hael.evetool.JumpCalculatorImpl#shortestRoute(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws Exception 
	 */
	@Test
	public void testZeroPath() throws Exception {
		
		List<SolarSystem> result = tester.shortestRoute("a", "a", -1, 1);
		Assert.assertTrue(result.get(0).equals(a) && result.get(result.size() - 1).equals(a));
	}

	/**
	 * Test method for
	 * {@link com.hael.evetool.JumpCalculatorImpl#shortestRoute(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws Exception 
	 */
	@Test
	public void testNoRoute() throws Exception {

		int exceptionsThrown = 0;
		try {
			tester.shortestRoute("a", "x", -1, 1);
		} catch (NoPathExistsException e) {
			log.info("NoRoute test 1 success");
			exceptionsThrown++;
		}
		try {
			tester.shortestRoute("x", "a", -1, 1);
		} catch (NoPathExistsException e1) {
			log.info("NoRoute test 2 success");
			exceptionsThrown++;
		}
		try {
			tester.shortestRoute("a", "y", -1, 1);
		} catch (NoPathExistsException e2) {
			log.info("NoRoute test 3 success");
			exceptionsThrown++;
		}
		try {
			tester.shortestRoute("z", "a", -1, 1);
		} catch (NoPathExistsException e3) {
			log.info("NoRoute test 4 success");
			exceptionsThrown++;
		}
		try {
			tester.shortestRoute("a", "c", -1, -1);
		} catch (NoPathExistsException e4) {
			log.info("NoRoute test 5 success");
			exceptionsThrown++;
		}
		Assert.assertEquals(5, exceptionsThrown);
	}
	
	

	/**
	 * Test method for
	 * {@link com.hael.evetool.JumpCalculatorImpl#systemNameLookup(java.lang.String)}
	 * .
	 * 
	 * @throws Exception 
	 */
	@Test
	public void testSystemNameLookup() throws Exception {
		List<String> list = Arrays.asList("Arraron");
		Mockito.stub(mockDao.systemNameLookup("Arr")).toReturn(list);

		List<String> result = tester.systemNameLookup("Arr");
		Assert.assertEquals(list, result);

	}

	/**
	 * Test method for
	 * {@link com.hael.evetool.JumpCalculatorImpl#getSystem(java.lang.String)}.
	 * 
	 * @throws Exception 
	 */
	@Test
	public void testGetSystem() throws Exception {

		SolarSystem result = tester.getSystem("a");
		Assert.assertEquals(a, result);
	}

}
