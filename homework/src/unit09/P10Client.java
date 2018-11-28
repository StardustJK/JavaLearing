package unit09;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


//客户端


public class P10Client {

	public static void main(String[] args) {
		try {
			//连接到服务器
			Socket socket =new Socket("127.0.0.1",6666);
			
			//创建数据流
			var out =new DataOutputStream(socket.getOutputStream());
			var in=new DataInputStream(socket.getInputStream());
			//输入
			System.out.println("please input a double data");
			var scanner = new Scanner(System.in);
			var data = scanner.nextDouble();

			// 将r发送给服务器
			out.writeDouble(data);
			System.out.println("sent r : " + data);

			//从服务器接收
			String s=in.readLine();
			System.out.println("string is:"+s);
			
			socket.close();
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}

	}

}
