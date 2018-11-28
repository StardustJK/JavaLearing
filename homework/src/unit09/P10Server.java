package unit09;

import java.io.*;
import java.net.*;

//服务器

public class P10Server {

	public static void main(String[] args) {
		try {
			//指定监听窗口
			var server=new ServerSocket(6666);
			System.out.println("listening on port 6666");
			
			//监听并等待接受连接
			Socket socket=server.accept();			
			System.out.println("client coonnected");
			
			//创建数据流
			var in=new DataInputStream(socket.getInputStream());
			var out=new DataOutputStream(socket.getOutputStream());
			var data=in.readDouble();
						
			//输出提示信息
			System.out.println("received : "+data);
			
			//转换成string
			var s=data+"";
			
			//发回客户端
			out.writeChars(s);
			
			socket.close();
			System.out.println("server closed");
					
		}
		catch(IOException e) {
		e.printStackTrace();	
		}

	}

}
