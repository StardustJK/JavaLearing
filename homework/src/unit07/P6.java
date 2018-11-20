package unit07;


public class P6 {
	static Print print=new Print();
	public static void main(String[] args) {
		T1 t1=new T1();
		T2 t2=new T2();
	    (new Thread(t2)).start();

	    (new Thread(t1)).start();
	}
	
	private static class Print{
		private int x=0;
		public synchronized void addition() {
			notifyAll();
			for(int i=0;i<20;i++) {
			x=x+1;
			System.out.println("t1:"+x);
			}
		}
		public synchronized void subtraction() {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			for(int i=0;i<20;i++) {
			x=x-1;
			System.out.println("t2:"+x);
			}
		}
	}
	public static class T1 implements Runnable{
		public void run() {
			System.out.println("t1 start");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			print.addition();
		}
	}
	public static class T2 implements Runnable{
		public void run() {
			System.out.println("t2 start");
			print.subtraction();
		}
	}
}
