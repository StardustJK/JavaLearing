package unit09;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//服务器

public class P13S {

	public static void main(String[] args) {
		try {
			// 线程池
			ExecutorService executor = Executors.newCachedThreadPool();

			// 指定监听窗口
			var server = new ServerSocket(6666);
			System.out.println("server started");

			// 监听并等待接受连接
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
				// 创建数据流
				var in = new DataInputStream(socket.getInputStream());
				var out = new ObjectOutputStream(socket.getOutputStream());

				var data = in.readDouble();

				// 输出提示信息
				System.out.println("received : " + data);

				Thread.sleep(3000);
				
				// 转换成string
				String s = data + "";

				// 发回客户端
				out.writeObject(s);

			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

		}
	}

}