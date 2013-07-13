
package Domain;

import java.util.Calendar;

/**
 *
 * @author dougkrause
 */
public class Obs {
    
    // Used to store a collection of weather observations
    
    public static Ob getObsRange(Calendar startTime, Calendar endTime){
        Ob ob = new Ob();
        System.out.print("Range of wx observations");
        return ob;
    }

    public static Ob getCurrentOb(Calendar currentTime) {
        // Server output verifies call to service
        System.out.print("Current wx observation");
        return null;
    }
    
}
