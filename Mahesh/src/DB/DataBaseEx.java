package DB;

import java.sql.*;

public class DataBaseEx {
public static void main(String[] args) throws Exception {
	
Connection con = DriverManager.getConnection("jdbc:odbc:DSNMP"); 
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("Select * from M");
while(rs.next())
{
System.out.println(rs.getString(1)+"\t" + rs.getString(2)+ "\t" + rs.getString(3));
}
rs.close();
st.close();
con.close();
}
}
