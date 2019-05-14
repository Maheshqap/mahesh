
//import java.sql.SQLException;
import java.sql.*;

public class Sqldb {

	public static void main(String[] args) throws Exception {
		Connection con=DriverManager.getConnection("jdbc:odbc:DSN1");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select* from Example");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		rs.close();
		st.close();
		con.close();
		

	}

}
