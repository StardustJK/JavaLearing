package unit09;

import java.io.*;
import java.net.*;

//������

public class P10Server {

	public static void main(String[] args) {
		try {
			//ָ����������
			var server=new ServerSocket(6666);
			System.out.println("listening on port 6666");
			
			//�������ȴ���������
			Socket socket=server.accept();			
			System.out.println("client coonnected");
			
			//����������
			var in=new DataInputStream(socket.getInputStream());
			var out=new DataOutputStream(socket.getOutputStream());
			var data=in.readDouble();
						
			//�����ʾ��Ϣ
			System.out.println("received : "+data);
			
			//ת����string
			var s=data+"";
			
			//���ؿͻ���
			out.writeChars(s);
			
			socket.close();
			System.out.println("server closed");
					
		}
		catch(IOException e) {
		e.printStackTrace();	
		}

	}

}
