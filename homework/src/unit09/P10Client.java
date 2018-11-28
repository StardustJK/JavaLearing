package unit09;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


//�ͻ���


public class P10Client {

	public static void main(String[] args) {
		try {
			//���ӵ�������
			Socket socket =new Socket("127.0.0.1",6666);
			
			//����������
			var out =new DataOutputStream(socket.getOutputStream());
			var in=new DataInputStream(socket.getInputStream());
			//����
			System.out.println("please input a double data");
			var scanner = new Scanner(System.in);
			var data = scanner.nextDouble();

			// ��r���͸�������
			out.writeDouble(data);
			System.out.println("sent r : " + data);

			//�ӷ���������
			String s=in.readLine();
			System.out.println("string is:"+s);
			
			socket.close();
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}

	}

}
