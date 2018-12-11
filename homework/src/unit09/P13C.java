package unit09;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


//客户端


public class P13C {

	public static void main(String[] args) {
		try {
			//连接到服务器
			Socket socket =new Socket("127.0.0.1",6666);
			
			//创建数据流
			var out =new DataOutputStream(socket.getOutputStream());
			var in=new ObjectInputStream(socket.getInputStream());
			//输入
			System.out.println("please input a double data");
			var scanner = new Scanner(System.in);
			var data = scanner.nextDouble();

			// 将r发送给服务器
			out.writeDouble(data);
			System.out.println("sent r : " + data);

			//从服务器接收
			Object s=in.readObject();
			System.out.println("string object is:"+s);
			
			scanner.close();
			socket.close();
		}
		catch(IOException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}

	}

}