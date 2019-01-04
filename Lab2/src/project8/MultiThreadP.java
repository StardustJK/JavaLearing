package project8;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadP {
	// 线程AB的锁
	Lock locka = new ReentrantLock();
	Lock lockb = new ReentrantLock();

	Condition ca = locka.newCondition();
	Condition cb = lockb.newCondition();

	static int round = 0, originRound = 0;// 轮数
	int sleepa, sleepb;// 用于输出A、B sleep的时间
	char a, b;// A,B输出的字符
	int sa = 0, sb = 0, fsa = 0, fsb = 0;// A,B每局得分记录和总得分

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (true) {
			// 输入轮数
			System.out.println("please input round(>0)");
			originRound = in.nextInt();
			round = originRound;
			if (originRound <= 0) {
				System.out.println("wrong round,please input again");
			} else {
				in.close();
				break;
			}
		}
		// 结果输出
		System.out.println("Round" + "   Thread A      " + "                ThreadB");
		System.out.println("\t" + "sleep     " + "Random    " + "Points    " + "sleep     " + "Random    " + "Points");
		System.out.println(
				"\t" + "time(ms)  " + "charater  " + "obtained  " + "time(ms)  " + "charater  " + "obtained  ");
		// 生成、启动线程
		MultiThreadP t = new MultiThreadP();
		ThreadC tc = t.new ThreadC();
		new Thread(tc).start();
		ThreadA ta = t.new ThreadA();
		ta.start();
		ThreadB tb = t.new ThreadB();
		tb.start();
	}

	// 线程A
	class ThreadA extends Thread {
		@Override
		public void run() {
			while (true) {
				if (round == 0) {// 线程结束
					break;
				}
				// 产生sleep的随机数并进行sleep
				sleepa = (int) (Math.random() * 1000);
				try {
					Thread.sleep(sleepa);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 产生字母
				locka.lock();
				a = (char) (Math.random() * 100 % 26 + 97);
				ca.signal();
				try {
					ca.await();// 等待C处理完后放出信号
					locka.unlock();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 线程B
	class ThreadB extends Thread {
		@Override
		public void run() {
			while (true) {
				// 线程结束
				if (round == 0) {
					break;
				}
				// 产生sleep参数并且sleep
				sleepb = (int) (Math.random() * 1000);
				try {
					Thread.sleep(sleepb);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 产生b
				lockb.lock();
				b = (char) (Math.random() * 100 % 26 + 97);
				cb.signal();
				try {
					cb.await();
					lockb.unlock();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 线程C
	class ThreadC implements Runnable {

		@Override
		public void run() {
			while (round > 0) {
				try {
					// 等待AB先完成一次
					locka.lock();
					lockb.lock();
					ca.await();
					cb.await();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 输出信息
				if (a > b) {
					sa = 2;
					sb = 0;
				}
				if (a == b) {
					sa = 1;
					sb = 1;
				}
				if (a < b) {
					sa = 0;
					sb = 2;
				}
				System.out.println(originRound - round + 1 + "\t" + sleepa + "\t" + "\t" + a + "\t" + sa + "\t" + sleepb
						+ "\t   " + b + "\t" + "\t" + sb);
				fsa = fsa + sa;
				fsb = fsb + sb;
				round--;
				// 释放锁
				ca.signal();
				cb.signal();
				lockb.unlock();
				locka.unlock();
			}
			// 最终得分
			if (fsa > fsb)
				System.out.println("Final result:A got " + fsa + ", is the winner");
			else if (fsa < fsb)
				System.out.println("Final result:B got " + fsb + ", is the winner");
			else
				System.out.println("Final result:end in a draw,A and B both got " + fsa);
		}

	}
}
