
package project3;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class LeastCommonMultiple {

	public static void main(String[] args) throws IOException {
		//�ӿ���̨�õ�������
		int n1=0,n2=0;
		System.out.println("������������");
		LeastCommonMultiple l=new LeastCommonMultiple();
		Scanner sc=new Scanner(System.in);
		
		try {
		n1=sc.nextInt();
		n2=sc.nextInt();
		sc.close();
		}
		catch(Exception e) {
			System.out.println("����������");
			return;
		}
		//��Чʱ��������
		if(n1>0&&n2>0)
		{
			//��ú��������Ӽ����ִ�����table
			int[][] a=l.getPrimeFactors(n1);
			int[][] b=l.getPrimeFactors(n2);
			int result=1;
			for(int i=0,j=0;;) {
				
				//����һ�����˵����
				if(i==a.length||a[i][0]==0) {
					while((j<b.length)&&(b[j][0]!=0)) {
						result=(int) (result*Math.pow(b[j][0],b[j][1]));
						j++;
					}
					break;
				}
				//����һ�����˵����
				if(j==b.length||b[j][0]==0) {
					while((i<a.length)&&(a[i][0]!=0)){
						result=(int) (result*Math.pow(a[i][0],a[i][1]));
						i++;
					}
					break;
				}
				//��������ͬʱ�Ĵ�����
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
				//����������ͬ�Ĵ�����
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
		System.out.println("���ǵ���С�������ǣ�"+result);
		}
		else {
			System.out.println("����ֵ�������0");
		}
	}
	
	public int[][] getPrimeFactors(int n) {
		if(n==1) {   //��������1��table
			int[][] table= {{1,1}};
			return table;
		}
		else {
			int j=0;
		Vector<Integer> v=new Vector<Integer>();
		for(int i=2;;) {
			if(n==1) {//ѭ������������
				j=v.size();
				break;
			}
			else {//Ѱ�������ӣ����������ģ�����vector
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
		//��vector�����������table,���ұ�עÿ�����ֳ��ֵĴ���
		int[][] table=new int[j][2];
		table[0][0]=v.get(0);
		table[0][1]=1;
		for(int i=1,k=0;i<j;i++) {
			if(v.get(i)==table[k][0]) {//�Ѵ��ڵĴ���+1
				table[k][1]++;
			}
			else {               //�״γ��֣�����=1
				table[k+1][0]=v.get(i);
				table[k+1][1]++;
				k++;
			}
		}
		return table;
		}
	}

}
