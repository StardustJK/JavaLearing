package unit08;

import java.sql.*;



public class Demo {

	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		// Çý¶¯¼ÓÔØµ½jvm
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//connect database
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/javabook?useSSL=false&serverTimezone=GMT", "scott", "tiger");
		
		//create a statement
		Statement st=conn.createStatement();
		
		ResultSet rs=st.executeQuery("select *from Course");
		// st.executeUpdate("update Course set numOfCredits=10 where numOfCredits=5");
		
		while(rs.next())
			System.out.println(rs.getString(1)+"\t"
							  +rs.getString(2)+'\t'
							  +rs.getString(3)+'\t'
							  +rs.getString(4)+'\t'
							  +rs.getString(5)+'\t'
							
					);
		conn.close();
	}

}
