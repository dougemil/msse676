/*
 * Service implementation Bean (SIB)
 * Uses JAX-WS annotations
 * Reference the Service Endpoint Interface (SEI)
 * 
 */
package services;

import Domain.Ob;
import Domain.Obs;
import java.util.Calendar;
import javax.jws.WebService;

/**
 * 
 * @author dougkrause
 * msse676 wk2
 * 
 */


@WebService(endpointInterface = "services.RemoteObs")
public class RemoteObsImpl implements RemoteObs {

    // params: Will receive XMLGregorianCalendar
    @Override
        public Ob getObsRange(Calendar startTime, Calendar endTime) {
        // return a range of observations
        return Obs.getObsRange(startTime, endTime);
    }

    @Override
    public Ob getMostRecentOb(Calendar currentTime) {
        // return a single observation
        return Obs.getCurrentOb(currentTime);
    }
    
}
