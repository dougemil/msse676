
package Domain;

/**
 *
 * @author dougkrause
 */
public class ForecastBean {
    
    private String message = "There is a 75% chance of weather today.";

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    
    @Override
    public String toString(){
        return getMessage();
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
