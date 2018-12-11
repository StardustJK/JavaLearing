package unit09;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.Date;


public class P14S {
	public static void main(String[] args){
		//���ڷ��ͽ���datagram packet
		byte[] buf=new byte[1024];


		//������Ϣ��packet
		DatagramPacket rcvPkt=new DatagramPacket(buf,buf.length);
		
		//������Ϣ��packet
		DatagramPacket sndPkt=new DatagramPacket(buf,buf.length);
		//��������Ҫ�˿ں�
		try(DatagramSocket socket=new DatagramSocket(6666);){
			System.out.println("Server started on port 6666"+new Date());

			while(true) {
				//initialize buf
				Arrays.fill(buf, (byte)0);
				//ÿ�ν��ն�Ҫ�������
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
