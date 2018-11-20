package unit07;

public class P4 {

	public static void main(String[] args) {
		Thread31 t1=new Thread31();
		Thread32 t2=new Thread32(t1);
		t1.start();
		t2.start();
	}

}
class Thread31 extends Thread{
	@Override
	public void run() {
		for(int i='a';i<='z';i++) {
			System.out.println((char)i);
			if(i=='o') {
				yield();
			}
		}
	}
}
class Thread32 extends Thread{
	Thread31 t1=null;
	Thread32(Thread31 t1){
		this.t1=t1;
	}
	@Override
	public void run() {

		for(int i=1;i<=26;i++) {
			System.out.println(i);
			if(i==20) {
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		
	}
	
}