package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;

public class WeatherDataBean {


	/**
	 * MSSE 674 - Douglas Krause
	 * Annotations for Spring/Hibernate validation
	 * 
	 */
	
	// Needs observer field that gets set from login/customer object
	
	@NotEmpty(message="Date is required")
	// Better validation might be acheived by catching exception thrown for unparsable date
	@Pattern(regexp="[2][0][0-2]\\d/[0-1]\\d/[0-3]\\d", message="Invalid Date Format")
	private String dateString;
	private Date sqlDate;
	// add javaDate field to facilitate validation?
	private String time;
	
	@NotEmpty(message="Location is required")
	private String location;
	
	private String sky;
	
	@Size(min=0, max=360, message="Must be 0-360")
	private String windDirection;
	private String windSpeed;
	private String gustSpreadMin;
	private String gustSpreadMax;
	
	private String summitTemp;
	private String summitElevation;
	private String baseTemp;
	private String baseElevation;
	
	private String comments;
	

	// Default Constructor
	public WeatherDataBean() {}
	
	public WeatherDataBean(String date, String time, String location,
			String sky, String windDirection, String windSpeed,
			String gustSpreadMin, String gustSpreadMax, String summitTemp,
			String summitElevation, String baseTemp, String baseElevation,
			String comments) {
		super();
		this.dateString = date;
		this.sqlDate = parseDateStringToSqlDate(date);
		this.time = time;
		this.location = location;
		this.sky = sky;
		this.windDirection = windDirection;
		this.windSpeed = windSpeed;
		this.gustSpreadMin = gustSpreadMin;
		this.gustSpreadMax = gustSpreadMax;
		this.summitTemp = summitTemp;
		this.summitElevation = summitElevation;
		this.baseTemp = baseTemp;
		this.baseElevation = baseElevation;
		this.comments = comments;
		
	}
	
	// Accepts a date string and returns a MySql Date object
	public Date parseDateStringToSqlDate(String dateString){
		
		try {
			// Validates format of dateString and converts to Date object
			SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
			simple.setLenient(false);
			java.util.Date javaDate = simple.parse(dateString);
			
			// Converts java.util.Date object to java.sql.Date object
			long dateMilliseconds = javaDate.getTime();
			java.sql.Date sqlDate = new java.sql.Date(dateMilliseconds);
			
			return sqlDate;
			
		} catch (ParseException e) {
			System.out.println("Error in parseDateString");
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String parseSqlDateToString(Date sqlDate){
		
		return sqlDate.toString();
	}

	// Getters and Setters
	public String getDateString() {
		return dateString;
	}


	public void setDateString(String date) {
		this.dateString = date;
		this.sqlDate = parseDateStringToSqlDate(date);
	}


	public Date getSqlDate() {
		return sqlDate;
	}

	public void setSqlDate(Date sqlDate) {
		this.sqlDate = sqlDate;
	}

	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getSky() {
		return sky;
	}


	public void setSky(String sky) {
		this.sky = sky;
	}


	public String getWindDirection() {
		return windDirection;
	}


	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}


	public String getWindSpeed() {
		return windSpeed;
	}


	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}


	public String getGustSpreadMin() {
		return gustSpreadMin;
	}


	public void setGustSpreadMin(String gustSpreadMin) {
		this.gustSpreadMin = gustSpreadMin;
	}


	public String getGustSpreadMax() {
		return gustSpreadMax;
	}


	public void setGustSpreadMax(String gustSpreadMax) {
		this.gustSpreadMax = gustSpreadMax;
	}


	public String getSummitTemp() {
		return summitTemp;
	}


	public void setSummitTemp(String summitTemp) {
		this.summitTemp = summitTemp;
	}


	public String getSummitElevation() {
		return summitElevation;
	}


	public void setSummitElevation(String summitElevation) {
		this.summitElevation = summitElevation;
	}


	public String getBaseTemp() {
		return baseTemp;
	}


	public void setBaseTemp(String baseTemp) {
		this.baseTemp = baseTemp;
	}


	public String getBaseElevation() {
		return baseElevation;
	}


	public void setBaseElevation(String baseElevation) {
		this.baseElevation = baseElevation;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "WeatherDataBean [dateString=" + dateString + ", time=" + time
				+ ", location=" + location + ", sky=" + sky
				+ ", windDirection=" + windDirection + ", windSpeed="
				+ windSpeed + ", gustSpreadMin=" + gustSpreadMin
				+ ", gustSpreadMax=" + gustSpreadMax + ", summitTemp="
				+ summitTemp + ", summitElevation=" + summitElevation
				+ ", baseTemp=" + baseTemp + ", baseElevation=" + baseElevation
				+ ", comments=" + comments + "]";
	}
	
}
