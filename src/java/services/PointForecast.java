/*
 * Service Endpoint Interface
 * Uses JAX-WS annotations
 * 
 */
package services;

import Domain.ForecastBean;
import java.util.Calendar;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author dougkrause
 * msse676 wk2
 * 
 */
@WebService
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT)
public interface PointForecast {
    
    // Annotations expose methods as web svc operations
    // param3: Will receive XMLGregorianCalendar
    @WebMethod public ForecastBean getPointForecast(int lat, int lon, Calendar endForecast);
    
}
