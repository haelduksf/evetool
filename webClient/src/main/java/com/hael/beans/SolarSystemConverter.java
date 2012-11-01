package com.hael.beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.hael.wsClient.IOException_Exception;
import com.hael.wsClient.JumpCalculator;
import com.hael.wsClient.JumpCalculatorImplService;
import com.hael.wsClient.NotARealSolarSystemException;

/**
 * Converts SolarSystems to Strings and vice versa.
 * @author alecross
 *
 */
@FacesConverter(value = "solarSystemConverter")
public class SolarSystemConverter implements Converter {

	private JumpCalculatorImplService service = new JumpCalculatorImplService();
	private JumpCalculator jumpCalculator = service.getJumpCalculatorImplPort();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2){
			try {
				return jumpCalculator.getSystem(arg2);
			} catch (IOException_Exception | NotARealSolarSystemException e) {
				throw new ConverterException(e);
			} 
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return arg2.toString();
	}

}
