/**
 * 
 */
package taxTable;

public class TaxTable {

	public static void main(String[] args) {
		TaxTable output=new TaxTable();
		//½á¹ûÅÅ°æ
		System.out.println("taxable Income"+"   "+"Single"+"   "+"Married Joint"
							+"   "+"Married Separate"+"   "+"Head of a House");
		for(int i=0;i<20;i++) {
			float income=50000+i*50;
			System.out.printf("%-17.0f",income);
			output.Single(income);
			output.MarriedJoint(income);
			output.MarriedSeparate(income);
			output.HeadHouse(income);
			System.out.println();
		}
	}
	public void Single(float income) {
		if(income<=0) {
			System.out.printf("%-9.1f",0);
		}
		if((income>0)&&(income<=7300)) {
			System.out.printf("%-9.1f",income*0.1);
		}
		if((income>7300)&&(income<=29700)) {
			System.out.printf("%-9.1f",(income-7300)*0.15+730);
		}
		if((income>29700)&&(income<=71950)) {
			System.out.printf("%-9.1f",(income-29700)*0.25+4090);
		}
		if((income>71950)&&(income<=150150)) {
			System.out.printf("%-9.1f",(income-71950)*0.28+14652.5);
		}
		if((income>150150)&&(income<=326450)) {
			System.out.printf("%-9.1f",(income-150150)*0.33+36548.5);
		}
		if(income>326450) {
			System.out.printf("%-9.1f",(income-326450)*0.35+94727.5);
		}
	}
	public void MarriedJoint(float income) {
		if(income<=0) {
			System.out.printf("%-16.1f",0);
		}
		if((income>0)&&(income<=14600)) {
			System.out.printf("%-16.1f",income*0.1);
		}
		if((income>14600)&&(income<=59400)) {
			System.out.printf("%-16.1f",(income-14600)*0.15+1460);
		}
		if((income>59400)&&(income<=119950)) {
			System.out.printf("%-16.1f",(income-59400)*0.15+8180);
		}
		if((income>119950)&&(income<=182800)) {
			System.out.printf("%-16.1f",(income-119950)*0.28+23317.5);
		}
		if((income>182800)&&(income<=326450)) {
			System.out.printf("%-16.1f",(income-182800)*0.33+40915.5);
		}
		if(income>326450) {
			System.out.printf("%-16.1f",(income-326450)*0.35+88320);
		}
	}
	public void MarriedSeparate(float income) {
		if(income<=0) {
			System.out.print(0);
		}
		if((income>0)&&(income<=7300)) {
			System.out.printf("%-19.1f",income*0.1);
		}
		if((income>7300)&&(income<=29700)) {
			System.out.printf("%-19.1f",(income-7300)*0.15+730);
		}
		if((income>29700)&&(income<=59975)) {
			System.out.printf("%-19.1f",(income-29700)*0.25+4090);
		}
		if((income>59975)&&(income<=91400)) {
			System.out.printf("%-19.1f",(income-59975)*0.28+11658.75);
		}
		if((income>91400)&&(income<=163225)) {
			System.out.printf("%-19.1f",(income-91400)*0.33+20457.75);
		}
		if(income>163225) {
			System.out.printf("%-19.1f",(income-163225)*0.35+44160);
		}

	}
	public void HeadHouse(float income) {
		if(income<=0) {
			System.out.printf("%-15.1f",0);
		}
		if((income>0)&&(income<=10450)) {
			System.out.printf("%-15.1f",income*0.1);
		}
		if((income>10450)&&(income<=39800)) {
			System.out.printf("%-15.1f",(income-10450)*0.15+1045);
		}
		if((income>39800)&&(income<=102800)) {
			System.out.printf("%-15.1f",(income-39800)*0.25+5446.5);
		}
		if((income>102800)&&(income<=166450)) {
			System.out.printf("%-15.1f",(income-102800)*0.28+21197.5);
		}
		if((income>166450)&&(income<=326450)) {
			System.out.printf("%-15.1f",(income-166450)*0.33+39019.5);
		}
		if(income>326450) {
			System.out.printf("%-15.1f",(income-326450)*0.35+91819.5);
		}
	}

}
