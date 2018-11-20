package unit07;

public class P3 {

	public static void main(String[] args) {
		Thread1 t1=new Thread1();
		Thread2 t2=new Thread2();
		t1.start();
		new Thread(t2).start();

	}

}
class Thread1 extends Thread{
	@Override
	public void run() {
		for(int i='a';i<='z';i++) {
			System.out.println((char)i);
		}
	}
}
class Thread2 implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=26;i++) {
			System.out.println(i);
		}
		
	}
	
}