/*
 * Service Endpoint Interface
 * Uses JAX-WS annotations
 * 
 */
package services;

import Domain.WeatherDataBean;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


/**
 * @author dougkrause
 * msse676 wk2
 *
 */
@WebService
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT)
public interface FieldObs {
	
    /**
     * Web service operation
     * Annotations expose methods as web svc operations
     * param1: Will receive XMLGregorianCalendar
     * 
     */
    @WebMethod public WeatherDataBean getFieldObs(Calendar gDate);

    
}
