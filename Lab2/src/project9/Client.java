package project9;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client{
	
	 static int rounda=0;
	 static int roundb=0;

	public static void main(String[] args) {
		System.out.println("please input round");
		Scanner in=new Scanner(System.in);
		rounda=in.nextInt();
		roundb=rounda;
		Client client=new Client();
		ThreadA ta=client.new ThreadA();
		ta.start();
		ThreadB tb=client.new ThreadB();
		tb.start();

	}
	class ThreadA extends Thread{
		@Override
		public void run() {
			try {
				Socket socket=new Socket("127.0.0.1",8888);
				
				var out=new DataOutputStream(socket.getOutputStream());
				 char a;
				 int sleepa;
				while(rounda>0) {
					a=(char)(Math.random()*100%3+97);
					out.writeChar(a);
					sleepa=(int)(Math.random()*1000);
					out.writeInt(sleepa);
					Thread.sleep(sleepa);
					rounda--;
					
				}
				out.writeChar('0');
				socket.close();
			}catch(IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	class ThreadB extends Thread{
		@Override
		public void run() {
			InetAddress server;
			DatagramPacket sndPkt;
			try {
				DatagramSocket socket=new DatagramSocket();
				server=InetAddress.getByName("localhost");
			char b;
			int sleepb;
			while(roundb>0) {
				b=(char)(Math.random()*100%3+97);
				byte[] buf=Character.valueOf(b).toString().getBytes();
				
					
					sndPkt=new DatagramPacket(buf, buf.length);
					sndPkt.setAddress(server);
					sndPkt.setPort(8000);
					sndPkt.setData(buf);
					socket.send(sndPkt);
					sleepb=(int)(Math.random()*1000);
					buf=Integer.valueOf(sleepb).toString().getBytes();
					sndPkt.setData(buf);
					socket.send(sndPkt);
					Thread.sleep(sleepb);
					roundb--;	
			}
			socket.close();
			} catch (IOException | InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
	
		}
	}
	
	
}
