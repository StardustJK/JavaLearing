package unit09;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//������

public class P13S {

	public static void main(String[] args) {
		try {
			// �̳߳�
			ExecutorService executor = Executors.newCachedThreadPool();

			// ָ����������
			var server = new ServerSocket(6666);
			System.out.println("server started");

			// �������ȴ���������
			while (true) {
				Socket socket = server.accept();
				System.out
						.println("Thread for :" + socket.getInetAddress().getHostName() + "port: " + socket.getPort());
				executor.execute(new ServerThread(socket));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	static class ServerThread implements Runnable {

		Socket socket;

		public ServerThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				// ����������
				var in = new DataInputStream(socket.getInputStream());
				var out = new ObjectOutputStream(socket.getOutputStream());

				var data = in.readDouble();

				// �����ʾ��Ϣ
				System.out.println("received : " + data);

				Thread.sleep(3000);
				
				// ת����string
				String s = data + "";

				// ���ؿͻ���
				out.writeObject(s);

			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}

		}
	}

}