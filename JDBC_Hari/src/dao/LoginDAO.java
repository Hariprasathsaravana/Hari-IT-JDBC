package dao;

import java.sql.*;

import connectionManager.ConnectionManager;
import model.Login;
public class LoginDAO {
 
	public boolean validate( Login  login)throws ClassNotFoundException,SQLException
	{
		String username =login.getUsername();
		String password =login.getpassword();
		ConnectionManager conn =new ConnectionManager();
		Connection con =conn.establishConnection();
		//create a statement object to excute a querry
		Statement st=con.createStatement();
		
		//excute the statement obj and return the query result set
		ResultSet rs=st.executeQuery("select * from login ");
		
		while (rs.next())
		{
			if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
			{
				//close the connection 
				conn.closeConnection();
				return true;
				
			}
		}
		conn.closeConnection();
		return false;
		
	}
}
