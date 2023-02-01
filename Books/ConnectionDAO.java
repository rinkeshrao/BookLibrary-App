package Books;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDAO {
private static Connection con=null;
private ConnectionDAO() {}
static
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection
	("jdbc:oracle:thin:@localhost:1521:xe","system","Rinkesh");
	}
	catch(Exception e) {e.printStackTrace();}
	}
public static Connection getCon() {//?
	return con;
}
}
