package connectionManager;

import java.sql.*;

public class ConnectionManager {

	//create connection object
	Connection con =null;
	
	public Connection establishConnection()throws ClassNotFoundException,SQLException
	{
		//load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		//Establish Connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hari","root","root");
		return con;
	
	}
	public void closeConnection() throws SQLException
	{
		con.close();
	}
	
}
