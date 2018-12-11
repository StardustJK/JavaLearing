package unit09;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class P14C {
	public static void main(String[] args) {
		
		InetAddress server;
		DatagramPacket sndPkt;
		DatagramPacket rcvPkt;		
		try (DatagramSocket socket=new DatagramSocket()){
			
				
			System.out.println("please input a double number: ");
			Scanner scanner=new Scanner(System.in);
			double d=scanner.nextDouble();
			//½«radiusÐ´Èëbuf
			byte[] buf=Double.valueOf(d).toString().getBytes();

			server=InetAddress.getByName("localhost");
			sndPkt=new DatagramPacket(buf,buf.length);
			sndPkt.setAddress(server);
			sndPkt.setPort(6666);
			sndPkt.setData(buf);
			
			socket.send(sndPkt);
			
			buf=new byte[1024];
			rcvPkt=new DatagramPacket(buf,buf.length);
			rcvPkt.setData(buf);
			socket.receive(rcvPkt);
			
			String s=new String(buf).trim();
			System.out.println("string receive :"+s);
			scanner.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
