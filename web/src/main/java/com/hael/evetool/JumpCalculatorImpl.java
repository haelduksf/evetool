package com.hael.evetool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hael.evetool.dao.NavDAO;
import com.hael.evetool.domain.MapSolarSystemJumpLog;
import com.hael.evetool.domain.MapSolarSystemNpcKillLog;
import com.hael.evetool.domain.MapSolarSystemPcKillLog;
import com.hael.evetool.domain.SolarSystem;
import com.hael.evetool.exception.NoPathExistsException;
import com.hael.evetool.exception.NotARealSolarSystemException;
import com.hael.evetool.exception.NotEnoughArgumentsException;

/**
 * Implements JumpCalculator as a web service.
 */
@Component(value="JumpCalculator")
@WebService(endpointInterface = "com.hael.evetool.JumpCalculator")
public class JumpCalculatorImpl implements JumpCalculator {

	private static final Logger log = LoggerFactory.getLogger(JumpCalculatorImpl.class);
	@Autowired
	private NavDAO navDAO;
	
	@Override
	public List<SolarSystem> shortestRoute(String from, String to, float minSecurity, float maxSecurity)
			throws NotARealSolarSystemException, NotEnoughArgumentsException,
			IOException, NoPathExistsException {

		log.debug("shortestRoute called");

		// setup
		List<SolarSystem> path = new ArrayList<SolarSystem>();
		boolean met = false;
		SolarSystem middle = null;

		Map<SolarSystem, DefaultMutableTreeNode> fromVisited = new HashMap<SolarSystem, DefaultMutableTreeNode>();
		Map<SolarSystem, DefaultMutableTreeNode> toVisited = new HashMap<SolarSystem, DefaultMutableTreeNode>();

		SolarSystem fromSS = navDAO.getSystem(from);
		SolarSystem toSS = navDAO.getSystem(to);
		DefaultMutableTreeNode toRoot = new DefaultMutableTreeNode(toSS);
		DefaultMutableTreeNode fromRoot = new DefaultMutableTreeNode(fromSS);
		DefaultTreeModel fromTree = new DefaultTreeModel(fromRoot);
		DefaultTreeModel toTree = new DefaultTreeModel(toRoot);
		List<SolarSystem> fromOuterLayer = new ArrayList<SolarSystem>();
		List<SolarSystem> toOuterLayer = new ArrayList<SolarSystem>();

		fromVisited.put(fromSS, fromRoot);
		fromOuterLayer.add(fromSS);
		toVisited.put(toSS, toRoot);
		toOuterLayer.add(toSS);

		// loop over search step until success
		while (!met) {
			if (fromOuterLayer.size() == 0 || toOuterLayer.size() == 0) {
				throw new NoPathExistsException();
			}
			if (fromOuterLayer.size() > toOuterLayer.size()) {
				List<SolarSystem> newOuterLayer = runStep(toVisited,
						toOuterLayer, minSecurity, maxSecurity);
				for (SolarSystem s : newOuterLayer) {
					if (fromOuterLayer.contains(s)) {
						met = true;
						middle = s;
					}
				}
				toOuterLayer = newOuterLayer;
			} else {
				List<SolarSystem> newOuterLayer = runStep(fromVisited,
						fromOuterLayer, minSecurity, maxSecurity);
				for (SolarSystem s : newOuterLayer) {
					if (toOuterLayer.contains(s)) {
						met = true;
						middle = s;
					}
				}
				fromOuterLayer = newOuterLayer;
			}
		}
		
		// format solution
		TreeNode[] toPath = toTree.getPathToRoot(toVisited.get(middle));
		TreeNode[] fromPath = fromTree.getPathToRoot(fromVisited.get(middle));

		int index = 0;
		for (TreeNode t : fromPath) {
			path.add((SolarSystem) ((DefaultMutableTreeNode) t)
					.getUserObject());
			index++;
		}

		for (TreeNode t : toPath) {
			path.add(index, (SolarSystem) ((DefaultMutableTreeNode) t)
					.getUserObject());

		}

		path.remove(index);

		return path;
	}

	private List<SolarSystem> runStep(
			Map<SolarSystem, DefaultMutableTreeNode> visited,
			List<SolarSystem> outerLayer, float minSecurity, float maxSecurity) throws NoPathExistsException {

		// get new systems
		List<SolarSystem> newLayer = new ArrayList<SolarSystem>();
		for (SolarSystem s : outerLayer) {
			if (s == null) {
				throw new NoPathExistsException();
			}
			for (SolarSystem t : s.getNeighbours()) {
				if (!visited.containsKey(t)) {
					DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(
							t);
					DefaultMutableTreeNode parent = visited.get(s);
					parent.add(newNode);
					if (t.getSecurity() <= maxSecurity && t.getSecurity() >= minSecurity) {
						newLayer.add(t);
					}
					
					visited.put(t, newNode);
				}
			}
		}
		return newLayer;

	}

	@Override
	public List<String> systemNameLookup(String string) throws IOException {
		return navDAO.systemNameLookup(string);
	}

	@Override
	public SolarSystem getSystem(String name) throws IOException, NotARealSolarSystemException {
		return navDAO.getSystem(name);
	}
	
	/**
	 * Sets the NavDAO. 
	 * @param navDAO the DAO to set
	 */
	public void setDao(NavDAO navDAO) {
		this.navDAO = navDAO;
	}

	@Override
	public List<MapSolarSystemJumpLog> getJumpsFor(SolarSystem solarSystem, Date from,
			Date to) throws NotARealSolarSystemException {
		return navDAO.getJumpsFor(solarSystem, from, to);
	}

	@Override
	public List<MapSolarSystemNpcKillLog> getNpcKillsFor(SolarSystem solarSystem, Date from,
			Date to) throws NotARealSolarSystemException {
		return navDAO.getNpcKillsFor(solarSystem, from, to);
	}

	@Override
	public List<MapSolarSystemPcKillLog> getPcKillsFor(SolarSystem solarSystem,
			Date from, Date to) throws NotARealSolarSystemException {
		return navDAO.getPcKillsFor(solarSystem, from, to);
	}

}
