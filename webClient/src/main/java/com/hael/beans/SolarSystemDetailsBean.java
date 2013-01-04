package com.hael.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hael.wsClient.ActivityLog;
import com.hael.wsClient.IOException_Exception;
import com.hael.wsClient.JumpCalculator;
import com.hael.wsClient.JumpCalculatorImplService;
import com.hael.wsClient.MapSolarSystemJumpLog;
import com.hael.wsClient.MapSolarSystemNpcKillLog;
import com.hael.wsClient.MapSolarSystemPcKillLog;
import com.hael.wsClient.NotARealSolarSystemException;
import com.hael.wsClient.SolarSystem;

/**
 * Managed bean for the details page.
 * 
 * @author alecross
 * 
 */
@ManagedBean
@ViewScoped
public class SolarSystemDetailsBean implements Serializable{

	private static final long serialVersionUID = 1841890546995062439L;
	private static final int DEFAULT_GRAPH_TIME = -24 ; // 24 hours
	private SolarSystem solarSystem;
	private JumpCalculatorImplService service = new JumpCalculatorImplService();
	private JumpCalculator jumpCalculator = service.getJumpCalculatorImplPort();
	private static final Logger log = LoggerFactory
			.getLogger(SolarSystemDetailsBean.class);
	

	public SolarSystemDetailsBean() {
	}

	public String getDatatipFormat() {
		return "<span style=\"display:none;\">%s</span><span>%s</span>";
	}

	/**
	 * @return the jumpModel
	 * @throws DatatypeConfigurationException 
	 * @throws NotARealSolarSystemException 
	 */
	public CartesianChartModel getActivityModel() throws DatatypeConfigurationException, NotARealSolarSystemException {
		GregorianCalendar fromCalendar = new GregorianCalendar();
		fromCalendar.add(GregorianCalendar.HOUR, DEFAULT_GRAPH_TIME);
		XMLGregorianCalendar xmlFromCalendar =  DatatypeFactory.newInstance().newXMLGregorianCalendar(fromCalendar);
		GregorianCalendar toCalendar = new GregorianCalendar();
		XMLGregorianCalendar xmlToCalendar =  DatatypeFactory.newInstance().newXMLGregorianCalendar(toCalendar);
		List<MapSolarSystemJumpLog> jumpData = jumpCalculator.getJumpsFor(solarSystem, xmlFromCalendar, xmlToCalendar); 
		List<MapSolarSystemNpcKillLog> npcKillData = jumpCalculator.getNpcKillsFor(solarSystem, xmlFromCalendar, xmlToCalendar);
		List<MapSolarSystemPcKillLog> pcKillData = jumpCalculator.getPcKillsFor(solarSystem, xmlFromCalendar, xmlToCalendar);
		
		ChartSeries jumpSeries = convertToSeries(jumpData);
		ChartSeries npcKillSeries = convertToSeries(npcKillData);
		ChartSeries pcKillSeries = convertToSeries(pcKillData);
		jumpSeries.setLabel("Jumps");
		npcKillSeries.setLabel("NPC Kills");
		pcKillSeries.setLabel("PC Kills");
		
		CartesianChartModel historyModel = new CartesianChartModel();
		historyModel.addSeries(jumpSeries);
		historyModel.addSeries(npcKillSeries);
		historyModel.addSeries(pcKillSeries);
		return historyModel;
	}

	private ChartSeries convertToSeries(List<? extends ActivityLog> activities) {
		ChartSeries result = new ChartSeries();
		for (ActivityLog activity : activities) {
			Calendar timeRetrieved = activity.getPk().getTimeRetrieved().toGregorianCalendar();
			String minutes = "" + timeRetrieved.get(Calendar.MINUTE);
			if (minutes.length() == 1) {
				minutes = "0" + minutes; 
			}
			String conciseDate = timeRetrieved.get(Calendar.HOUR_OF_DAY) + ":" + minutes;
			result.set(conciseDate, activity.getValue());
		}
		return result;
	}

	/**
	 * @return the solarSystem
	 */
	public SolarSystem getSolarSystem() {
		return solarSystem;
	}

	/**
	 * @param solarSystem the solarSystem to set
	 */
	public void setSolarSystem(SolarSystem solarSystem) {
		this.solarSystem = solarSystem;
	}
	
	/**
	 * Convenience method to set solar system by name rather than reference
	 * @param solarSystem the name of the solarSystem to set
	 * @throws IOException_Exception 
	 */
	public void setSolarSystemByName(String solarSystem) throws IOException_Exception {
		log.debug("Setting solar system to {}", solarSystem);
				
		try {
			this.solarSystem = jumpCalculator.getSystem(solarSystem);
		} catch (NotARealSolarSystemException e) {
			FacesMessage error = new FacesMessage(e.getMessage());
			error.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, error);
		}
		log.debug("solarSystem changed to {}", this.solarSystem.getName());
	}
}
