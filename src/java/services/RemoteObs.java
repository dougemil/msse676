/*
 * Service Endpoint Interface
 * Uses JAX-WS annotations
 * 
 */
package services;

import Domain.Ob;
import Domain.Obs;
import java.util.Calendar;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author dougkrause
 * msse676 wk2
 * 
 */
@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface RemoteObs {
    
    // Annotations expose methods as web svc operations
    // params: Will receive XMLGregorianCalendar
   @WebMethod public Ob getObsRange(Calendar startTime, Calendar endTime);
   @WebMethod public Ob getMostRecentOb(Calendar currentTime);
    
}
