package unit08;

import java.sql.*;



public class P1 {

	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		// 驱动加载到jvm
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//connect database
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useSSL=false&serverTimezone=GMT", "root", "123456");
		
		
		//create a statement
		Statement st=conn.createStatement();
		
		/*创建table
		  st.executeUpdate("create table info(Name varchar(20),age int,marriage bool)");
		 */
		
		
		/*
		 * 第七题:
		 */
		//st.executeUpdate("insert info values(\"Kitty\",13,false)");
		
		/*
		 * 第八题
		 */
		st.executeUpdate("update info set name=\"Hello Kitty\" where name=\"Kitty\"");
		
		/*
		 * 第六题
		 */
		ResultSet rs=st.executeQuery("select * from info");
		while(rs.next())
			System.out.println(rs.getString(1)+"\t"
							  +rs.getString(2)+'\t'
							  +rs.getString(3)+'\t'
	
					);
		
		
		conn.close();
	}

}
