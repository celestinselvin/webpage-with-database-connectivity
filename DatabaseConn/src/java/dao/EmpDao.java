
package dao;
import java.util.*;
import java.sql.*;
import model.Emp;


public class EmpDao {
    public static Connection getConnection() {
		Connection con= null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-TP9QDE1;databaseName=celes","sa","celestin10");
		}catch(Exception e) {System.out.println(e);}
		return con;
		}
	public static int save(Emp e) {
		int status=0;
		try {
			Connection con= EmpDao.getConnection();
			PreparedStatement ps =con.prepareStatement("insert into Emptable(name,email,password,address) values (?,?,?,?)");
		ps.setString(1, e.getName());
		ps.setString(2, e.getEmail());
		ps.setString(3, e.getPassword());
                ps.setString(2, e.getAddress());
		
		
		status = ps.executeUpdate();
		
		con.close();
		}catch(Exception ex) {
                    ex.printStackTrace();
                }
		return status;
	}
	
	

}
