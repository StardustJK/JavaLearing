package project9;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

	public static void main(String[] args) {
		try {
			char a, b;// A,B对应字符
			int sleepa, sleepb;// A，B对应sleep时间
			int sa, sb;// 单局得分
			int fsa = 0, fsb = 0;// 最终得分
			int round = 0;
			String outa = null, outb = null;// 用于输出剪刀石头布
			System.out.println("\t" + "KidA" + "\t\t\t\t" + "KidB");
			System.out.println("Round" + "\t" + "sleep" + "\t" + "selection" + "\t" + "score" + "\t" + "sleep" + "\t"
					+ "selection" + "\t" + "score");

			// TCP：ThreadA的监听窗口， 监听并等待接受连接
			ServerSocket servera = new ServerSocket(8888);
			Socket tcpsocket = servera.accept();
			// 接收A的数据流
			var inA = new DataInputStream(tcpsocket.getInputStream());

			// UDP，用于接收B
			byte[] buf = new byte[1024];
			DatagramPacket rcvPkt = new DatagramPacket(buf, buf.length);
			DatagramSocket udpsocket = new DatagramSocket(8000);

			while (true) {
				a = inA.readChar();// 读入A的字符
				if (a == '0')// 结束条件
					break;
				sleepa = inA.readInt();// 读入A的sleeptime

				// 接收B的字符
				Arrays.fill(buf, (byte) 0);
				rcvPkt.setData(buf);
				udpsocket.receive(rcvPkt);
				b = new String(buf).trim().charAt(0);

				// 接收B的sleeptime
				Arrays.fill(buf, (byte) 0);
				rcvPkt.setData(buf);
				udpsocket.receive(rcvPkt);
				sleepb = Integer.parseInt(new String(buf).trim());

				// 进行判断
				if ((a == 'a' && b == 'b') || (a == 'b' && b == 'c') || (a == 'c' && b == 'a')) {
					sa = 2;
					sb = 0;
					fsa = fsa + sa;
				} else if ((b == 'a' && a == 'b') || (b == 'b' && a == 'c') || (b == 'c' && a == 'a')) {
					sb = 2;
					sa = 0;
					fsb = fsb + sb;
				} else {
					sa = 1;
					sb = 1;
					fsa = fsa + 1;
					fsb = fsb + 1;
				}

				// 进行输出
				if (a == 'a')
					outa = "rock";
				if (a == 'b')
					outa = "scissors";
				if (a == 'c')
					outa = "paper";
				if (b == 'a')
					outb = "rock";
				if (b == 'b')
					outb = "scissors";
				if (b == 'c')
					outb = "paper";
				round++;
				System.out.println(round + "\t" + sleepa + "\t" + outa + "    \t" + sa + "\t" + sleepb + "\t" + outb
						+ "    \t" + sb);

			}
			// 最终输出
			if (fsa > fsb) {
				System.out.println("Kid A got " + fsa + ",win");
			} else if (fsa < fsb) {
				System.out.println("Kid B got " + fsb + ",win");
			} else {
				System.out.println("Kid A and Kid B end in a draw ,both got " + fsa);
			}
			udpsocket.close();
			tcpsocket.close();
			servera.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
