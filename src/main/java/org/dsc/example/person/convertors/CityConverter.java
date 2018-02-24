/**
 * 
 */
package org.dsc.example.person.convertors;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.dsc.example.person.AddressManager;
import org.dsc.example.person.model.City;

/**
 * @author dan.stoica
 *
 */
@FacesConverter("cityConverter")
public class CityConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				AddressManager service = (AddressManager) fc.getExternalContext().getApplicationMap().get("addressService");
				City city = service.findCityByName(value.substring(0, value.indexOf('(')-1));
				return city;
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid city."));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null && object instanceof City) {
			AddressManager service = (AddressManager) fc.getExternalContext().getApplicationMap().get("addressService");
			service.addCity(((City) object).getName(), (City) object);
			return String.valueOf(((City) object).getCityId());
		} else {
			return null;
		}
	}

}
