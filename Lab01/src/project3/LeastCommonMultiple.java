
package project3;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class LeastCommonMultiple {

	public static void main(String[] args) throws IOException {
		//从控制台得到两个数
		int n1=0,n2=0;
		System.out.println("请输入两个数");
		LeastCommonMultiple l=new LeastCommonMultiple();
		Scanner sc=new Scanner(System.in);
		
		try {
		n1=sc.nextInt();
		n2=sc.nextInt();
		sc.close();
		}
		catch(Exception e) {
			System.out.println("请输入整数");
			return;
		}
		//有效时进行运算
		if(n1>0&&n2>0)
		{
			//获得含有质因子及出现次数的table
			int[][] a=l.getPrimeFactors(n1);
			int[][] b=l.getPrimeFactors(n2);
			int result=1;
			for(int i=0,j=0;;) {
				
				//其中一个完了的情况
				if(i==a.length||a[i][0]==0) {
					while((j<b.length)&&(b[j][0]!=0)) {
						result=(int) (result*Math.pow(b[j][0],b[j][1]));
						j++;
					}
					break;
				}
				//其中一个完了的情况
				if(j==b.length||b[j][0]==0) {
					while((i<a.length)&&(a[i][0]!=0)){
						result=(int) (result*Math.pow(a[i][0],a[i][1]));
						i++;
					}
					break;
				}
				//质因数相同时的处理方法
				if(a[i][0]==b[j][0]) {
			
					if(a[i][1]>=b[j][1]) {
						result=(int) (result*Math.pow(a[i][0],a[i][1]));
					}
					else {
					result=(int) (result*Math.pow(b[j][0],b[j][1]));
					}
					i++;
					j++;
					continue;
				}
				//质因数不相同的处理方法
				if(a[i][0]<b[j][0]) {
					result=(int)(result*Math.pow(a[i][0], a[i][1]));
					if(i==a.length)
						break;
					i++;
					continue;
				}
				if(a[i][0]>b[j][0]) {
					result=(int)(result*Math.pow(b[j][0], b[j][1]));
					if(i==b.length)
						break;
					j++;
					continue;
				}
				
		
		}
		System.out.println("它们的最小公倍数是："+result);
		}
		else {
			System.out.println("输入值必须大于0");
		}
	}
	
	public int[][] getPrimeFactors(int n) {
		if(n==1) {   //对于特例1的table
			int[][] table= {{1,1}};
			return table;
		}
		else {
			int j=0;
		Vector<Integer> v=new Vector<Integer>();
		for(int i=2;;) {
			if(n==1) {//循环结束的条件
				j=v.size();
				break;
			}
			else {//寻找质因子，满足条件的，放入vector
				if(n%i==0) {
					n=n/i;
					v.add(i);
					continue;
				}
				else {
					i++;
					continue;
				}
			}
		}	
		//将vector里面的数放入table,并且标注每个数字出现的次数
		int[][] table=new int[j][2];
		table[0][0]=v.get(0);
		table[0][1]=1;
		for(int i=1,k=0;i<j;i++) {
			if(v.get(i)==table[k][0]) {//已存在的次数+1
				table[k][1]++;
			}
			else {               //首次出现，次数=1
				table[k+1][0]=v.get(i);
				table[k+1][1]++;
				k++;
			}
		}
		return table;
		}
	}

}
