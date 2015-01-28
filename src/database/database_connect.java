package database;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class database_connect{
	
	Connection conn = null;
	Properties connectionProps = new Properties();
    connectionProps.put("user", "dprince");
    connectionProps.put("password", this.password);
    
    public void databaseConnect(){
    	
    	conn = DriverManager.getConnection(
                "jdbc:" + this.dbms + "://" +
                this.serverName +
                ":" + this.portNumber + "/",
                connectionProps);
    }
}