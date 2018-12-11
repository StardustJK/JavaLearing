package unit09;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


//�ͻ���


public class P13C {

	public static void main(String[] args) {
		try {
			//���ӵ�������
			Socket socket =new Socket("127.0.0.1",6666);
			
			//����������
			var out =new DataOutputStream(socket.getOutputStream());
			var in=new ObjectInputStream(socket.getInputStream());
			//����
			System.out.println("please input a double data");
			var scanner = new Scanner(System.in);
			var data = scanner.nextDouble();

			// ��r���͸�������
			out.writeDouble(data);
			System.out.println("sent r : " + data);

			//�ӷ���������
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