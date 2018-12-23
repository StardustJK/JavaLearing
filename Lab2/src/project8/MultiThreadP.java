package project8;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadP {
	Lock locka = new ReentrantLock();
	Lock lockb = new ReentrantLock();

	Condition ca = locka.newCondition();
	Condition cb = lockb.newCondition();

	static int round = 0, originRound = 0;
	int sleepa, sleepb;// �������A��B sleep��ʱ��
	char a, b;// A,B������ַ�
	int sa = 0, sb = 0, fsa = 0, fsb = 0;// A,B�÷ּ�¼

	public static void main(String[] args) {
		System.out.println("please input round");
		Scanner in = new Scanner(System.in);
		originRound = in.nextInt();
		round = originRound;
		in.close();
		System.out.println("Round" + "   Thread A      " + "                ThreadB");
		System.out.println("\t" + "sleep     " + "Random    " + "Points    " + "sleep     " + "Random    " + "Points");
		System.out.println(
				"\t" + "time(ms)  " + "charater  " + "obtained  " + "time(ms)  " + "charater  " + "obtained  ");
		MultiThreadP t = new MultiThreadP();
		ThreadC tc = t.new ThreadC();
		new Thread(tc).start();
		ThreadA ta = t.new ThreadA();
		ta.start();
		ThreadB tb = t.new ThreadB();
		tb.start();
	}

	class ThreadA extends Thread {
		@Override
		public void run() {
			while (true) {
				locka.lock();
				if (round == 0) {// �߳̽���
					break;
				}
				// ����sleep�������������sleep
				sleepa = (int) (Math.random() * 1000);
				try {
					locka.unlock();
					Thread.sleep(sleepa);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// ������ĸ
				locka.lock();
				a = (char) (Math.random() * 100 % 26 + 97);
				ca.signal();
				try {
					ca.await();
					locka.unlock();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class ThreadB extends Thread {
		@Override
		public void run() {
			while (true) {
				lockb.lock();
				// �߳̽���
				if (round == 0) {
					break;
				}
				// ����sleep��������sleep
				sleepb = (int) (Math.random() * 1000);
				try {
					lockb.unlock();
					Thread.sleep(sleepb);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// ����b
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

	class ThreadC implements Runnable {

		@Override
		public void run() {
			while (round > 0) {
				try {
					// �ȴ�AB�����һ��
					locka.lock();
					lockb.lock();
					ca.await();
					cb.await();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// �����Ϣ
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
				ca.signal();
				cb.signal();
				lockb.unlock();
				locka.unlock();
			}
			if (fsa > fsb)
				System.out.println("Final result:A got " + fsa + ", is the winner");
			else if (fsa < fsb)
				System.out.println("Final result:B got " + fsb + ", is the winner");
			else
				System.out.println("Final result:end in a draw,A and B both got " + fsa);
		}

	}
}
