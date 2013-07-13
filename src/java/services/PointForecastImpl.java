/*
 * Service implementation Bean (SIB)
 * Uses JAX-WS annotations
 * Reference the Service Endpoint Interface (SEI)
 * 
 */
package services;

import Domain.ForecastBean;
import java.util.Calendar;
import javax.jws.WebService;

/**
 * 
 * @author dougkrause
 * msse676 wk2
 * 
 */
@WebService(endpointInterface = "services.PointForecast")
public class PointForecastImpl implements PointForecast {

    
    @Override
    // param1: Will receive XMLGregorianCalendar
    public ForecastBean getPointForecast(int lat, int lon, Calendar endForecast) {
        
        ForecastBean forecast = new ForecastBean();
        forecast.setMessage("check.");
        
        return forecast;
    }
    
}
