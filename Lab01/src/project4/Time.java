package project4;

public class Time {


	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Time time1=new Time();
		System.out.println(time1.toString());
		Time time2=new Time(555550000);
		System.out.println(time2.toString());
	
	}
	private int hour;
	private int minute;
	private int second;
	Time(){
		int time=(int)(System.currentTimeMillis()/1000);
		second=time%60;
		minute=(time/60)%60;
		hour=(time/60/60)%24;
	}
	Time(int time){
		this();
		if(time<0) {
			System.out.println("请输入正数");
		}
		time=time/1000;
		second=(time%60);
		minute=(time/60)%60;
		hour=(time/60/60)%24;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public String toString() {
		return "hour:"+hour+"   minute:"+minute+"   second:"+second;
	}

}
