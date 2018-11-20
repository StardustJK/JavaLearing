package unit07;

public class P5 {

	public static void main(String[] args) {
		P5 d=new P5();
		T1 t1=d.new T1();
		T2 t2=d.new T2();
		t1.start();
		t2.start();
	}

	private int x=0;
	synchronized private void addition() {
		for(int i=0;i<20;i++) {
			x=x+1;
			System.out.println(x);
		} 
	}
	synchronized private void subtraction() {
		for(int i=0;i<20;i++) {
			x=x-1;
			System.out.println(x);
		}
	}
	
	class T1 extends Thread{
		@Override
		public void run() {
			addition();
		}
	}
	class T2 extends Thread{
		@Override
		public void run() {
			subtraction();
		}
	}
}
