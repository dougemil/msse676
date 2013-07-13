package services;

/*
 * Service implementation Bean (SIB)
 * Uses JAX-WS annotations
 * Reference the Service Endpoint Interface (SEI)
 * Depends on local DB access
 * 
 * @author dougkrause
 * msse676 wk2
 */

import Domain.WeatherDataBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// This Class refactored from msse674
@WebService(endpointInterface = "services.FieldObs")
public class FieldObsImpl implements FieldObs {
	
    Connection conn = null;
    DataSource ds = null;
    PreparedStatement ps = null;
    String sql;
    
    public FieldObsImpl(){};

    // param1: Will receive XMLGregorianCalendar
    @Override
    public WeatherDataBean getFieldObs(Calendar gDate) {
        
        java.sql.Date sqlDate = new java.sql.Date(gDate.getTimeInMillis());
        
        WeatherDataBean wxBean;
        ResultSet rs;
        getConnection();


        sql = "select * from wxdata where date = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setDate(1, sqlDate);
            rs = ps.executeQuery();

            // Checks for results in ResultSet
            if(rs.next()){
                SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
                simple.setLenient(false);
                String dateString = simple.format(sqlDate);

                wxBean = new WeatherDataBean(dateString, "na", rs.getString("location"),
                                                rs.getString("sky"), rs.getString("windDirection"), 
                                                rs.getString("windSpeed"), rs.getString("gustSpreadMin"), 
                                                rs.getString("gustSpreadMax"), rs.getString("summitTemp"), 
                                                rs.getString("summitElevation"), rs.getString("baseTemp"), 
                                                rs.getString("baseElevation"), rs.getString("comments"));
                return wxBean;
            }
            else{
                    return null;
            }
        } catch (SQLException e) {
                System.out.println("Unable to find sql record from WxSvcJDBCImpl");
                e.printStackTrace();
        }finally{
            try {
                    conn.close();
            } catch (SQLException e) {
                    System.out.println("Unable to close connection in WxSvcJDBCImpl");
                    e.printStackTrace();
                    return null;
            }
        }
        return null;
    }
    
    private void getConnection(){

        try{
                Context initCtx = new InitialContext();

    /*
     *  Requires server, etc. configuration for Glassfish/MySql/JDBC
     *  http://dev.mysql.com/doc/refman/5.1/en/connector-j-usagenotes-glassfish-config.html
     */
                Context envCtx = (Context)initCtx.lookup("java:comp/env");
                ds = (DataSource)envCtx.lookup("jdbc/MySQLDataSource");

        }catch (NamingException e) {
                System.out.println("Thrown from CustomerSvcJDBCImpl"); 
                e.printStackTrace();
        }

        try{
                // Get DB connection
                conn = ds.getConnection();

        }catch (SQLException e) {
                System.out.println("Thrown from WxSvcJDBCImpl. No connection");
                e.printStackTrace();
        }

    }

    
}
