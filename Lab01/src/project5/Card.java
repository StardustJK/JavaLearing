package project5;
import java.util.Random;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Card extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	Image[]images=new Image[52];
	ImageView imv1=new ImageView();
	ImageView imv2=new ImageView();
	ImageView imv3=new ImageView();
	ImageView imv4=new ImageView();
	ScriptEngineManager manager=new ScriptEngineManager();
	ScriptEngine engine=manager.getEngineByName("javascript");
	Object e=24;
	String s;
	char[]o= {'+','-','*','/'};//operation	
	int []numbers=new int[4];
	@Override
	public void start(Stage primaryStage) throws Exception {
		//创建图像对象
		String[] imageUrls= {
			"file:card/1.png",
			"file:card/2.png",
			"file:card/3.png",
			"file:card/4.png",
			"file:card/5.png",
			"file:card/6.png",
			"file:card/7.png",
			"file:card/8.png",
			"file:card/9.png",
			"file:card/10.png",
			"file:card/11.png",
			"file:card/12.png",
			"file:card/13.png",
			"file:card/14.png",
			"file:card/15.png",
			"file:card/16.png",
			"file:card/17.png",
			"file:card/18.png",
			"file:card/19.png",
			"file:card/20.png",
			"file:card/21.png",
			"file:card/22.png",
			"file:card/23.png",
			"file:card/24.png",
			"file:card/25.png",
			"file:card/26.png",
			"file:card/27.png",
			"file:card/28.png",
			"file:card/29.png",
			"file:card/30.png",
			"file:card/31.png",
			"file:card/32.png",
			"file:card/33.png",
			"file:card/34.png",
			"file:card/35.png",
			"file:card/36.png",
			"file:card/37.png",
			"file:card/38.png",
			"file:card/39.png",
			"file:card/40.png",
			"file:card/41.png",
			"file:card/42.png",
			"file:card/43.png",
			"file:card/44.png",
			"file:card/45.png",
			"file:card/46.png",
			"file:card/47.png",
			"file:card/48.png",
			"file:card/49.png",
			"file:card/50.png",
			"file:card/51.png",
			"file:card/52.png"
		};
		

		for(int i=0;i<52;i++) {
			images[i]=new Image(imageUrls[i]);
		}

		//设置布局；设置按钮；设置响应事件
		BorderPane pane=new BorderPane();
		
		
		Button findbtn=new Button("Find a Solution");
		TextField findtext=new TextField();
		Button refresh=new Button("Refresh");
		Label enter=new Label("Enter an expression");
		TextField input=new TextField();
		Button verify=new Button("Verify");
		//更新图片
		refresh.setOnAction((ActionEvent event)->
		{
			findtext.setText("");
			imvChange();
		});
		//检测对错
		verify.setOnAction((ActionEvent event)->
		{ 
			try {
				Boolean a=verify(input.getText());
				if(a==true) {
					
					findtext.setText("you are right");
				}
				else {
					findtext.setText("you are wrong");
				}
			} catch (ScriptException e) {

				e.printStackTrace();
			}
		});
		//显示答案
		findbtn.setOnAction((ActionEvent evet)-> {
			try {
				String s=solution(numbers);
				findtext.setText(s);
			} catch (ScriptException e) {

				e.printStackTrace();
			}

		});
		
		HBox box1=new HBox(5);
		box1.getChildren().addAll(findbtn,findtext,refresh);
		box1.setAlignment(Pos.CENTER);
		pane.setTop(box1);

	
		HBox box2=new HBox(5);
		imvChange();
		box2.getChildren().addAll(imv1,imv2,imv3,imv4);
		box2.setAlignment(Pos.CENTER);
		pane.setCenter(box2);
		
		HBox box3=new HBox(5);
		box3.getChildren().addAll(enter,input,verify);
		box3.setAlignment(Pos.CENTER);
		pane.setBottom(box3);
		
		pane.setPadding(new Insets(10,10,10,10));
		
		
		
		Scene scene=new Scene(pane,400,300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	//改变图片
	public void imvChange() {
		Random random=new Random();
		int[] i=new int[4];
		i[0]=random.nextInt(52);
		i[1]=random.nextInt(52);
		i[2]=random.nextInt(52);
		i[3]=random.nextInt(52);
		while(i[0]==i[1]) {
			i[0]=random.nextInt(52);
		}
		while(i[0]==i[2]||i[1]==i[2]) {
			i[2]=random.nextInt(52);
		}
		while(i[0]==i[3]||i[1]==i[3]||i[2]==i[3]) {
			i[3]=random.nextInt(52);
		}
		imv1.setImage(images[i[0]]);
		imv2.setImage(images[i[1]]);
		imv3.setImage(images[i[2]]);
		imv4.setImage(images[i[3]]);
		for(int j=0;j<4;j++) {
			numbers[j]=(i[j]+1)%13;
			if(numbers[j]==0) {
				numbers[j]=13;
			}
		}
	}
	//获得答案
	public String solution(int a[]) throws ScriptException {
		//数字摆放位置：
		String result = null;
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(j==i)
					continue;
				else {
					for(int m=0;m<4;m++) {
						if(m==i||m==j)
							continue;
						else {
							for(int n=0;n<4;n++) {
								if(n==i||n==j||n==m)
									continue;
								else {
									result=compute(numbers[i],numbers[j],numbers[m],numbers[n]);
									if(result=="0") {
										continue;
									}
									else {
										return result;
									}
								}
							}
						}
					}
				}
			}
		}
		

			return "no answer!";

		
	}
	//计算是否是24
	public String compute(double num1,double num2,double num3,double num4) {
		int[]a=new int[4];
		a[0]=(int)num1;
		a[1]=(int)num2;
		a[2]=(int)num3;
		a[3]=(int)num4;
		for(int i=0;i<4;i++) {
			double r_12=calculate(num1,num2,o[i]);
			double r_23=calculate(num2,num3,o[i]);
			double r_34=calculate(num3,num4,o[i]);
			for(int j=0;j<4;j++) {
				double r_12_12=calculate(r_12,num3,o[j]);
				double r_12_23=calculate(num3,num4,o[j]);
				double r_23_12=calculate(num1,r_23,o[j]);
				double r_23_23=calculate(r_23,num4,o[j]);
				double r_34_23=calculate(num2,r_34,o[j]);
				for(int k=0;k<4;k++) {
					//五种情况
					if(calculate(r_12_12,num4,o[k])==24) {
						return "("+"("+a[0]+o[i]+a[1]+')'+o[j]+a[2]+")"+o[k]+a[3];
					}
					if(calculate(r_12,r_12_23,o[k])==24) {
						return "("+a[0]+o[i]+a[1]+')'+o[k]+'('+a[2]+o[j]+a[3]+')';
					}
					if(calculate(r_23_12,num4,o[k])==24) {
						return "("+a[0]+o[j]+'('+a[1]+o[i]+a[2]+')'+')'+o[k]+a[3];
					}
					if(calculate(num1,r_23_23,o[k])==24) {
						return ""+a[0]+o[k]+"("+'('+a[1]+o[i]+a[2]+')'+o[j]+a[3]+')';
					}
					if(calculate(num1,r_34_23,o[k])==24) {
						return ""+a[0]+o[k]+"("+a[1]+o[j]+'('+a[2]+o[i]+a[3]+')'+')';
					}
					
				}
			}
		}
		return "0";
		
		
	}
	//数字运算
	public double calculate(double a,double b,char oper) {
		if(oper=='+')
			return a+b;
		if(oper=='-')
			return a-b;
		if(oper=='*')
			return a*b;
		if(oper=='/')
			return a/b;
		else
			return -1;
	}
	//计算字符串
	public Boolean verify(String s) throws ScriptException {
		try {
		if(e==engine.eval(s)) {
			return true;
		}
		else return false;
		}
		catch(ScriptException e) {
			System.out.println("请输入正确表达式");
			return false;
		}
	}
}
