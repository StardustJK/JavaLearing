package unit09;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.Date;


public class P14S {
	public static void main(String[] args){
		//用于发和接受datagram packet
		byte[] buf=new byte[1024];


		//接收信息的packet
		DatagramPacket rcvPkt=new DatagramPacket(buf,buf.length);
		
		//发送信息的packet
		DatagramPacket sndPkt=new DatagramPacket(buf,buf.length);
		//服务器端要端口号
		try(DatagramSocket socket=new DatagramSocket(6666);){
			System.out.println("Server started on port 6666"+new Date());

			while(true) {
				//initialize buf
				Arrays.fill(buf, (byte)0);
				//每次接收都要设置这个
				rcvPkt.setData(buf);
				//receive from client
				socket.receive(rcvPkt);

				System.out.println("Recevied packt from "+rcvPkt.getAddress().getHostAddress()
						+"port: "+rcvPkt.getPort());

				var s=new String(buf).trim();
				
				System.out.println("received:  "+s);

				//send to client
				buf =s.getBytes();

				sndPkt.setAddress(rcvPkt.getAddress());
				sndPkt.setPort(rcvPkt.getPort());
				sndPkt.setData(buf,0,buf.length);

				socket.send(sndPkt);
				System.out.println("string sent");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
