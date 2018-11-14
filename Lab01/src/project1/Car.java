package project1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Car extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage primaryStage) throws Exception {
		//上方label\文字框布局
		BorderPane pane=new BorderPane();
		HBox pane1=new HBox(8);
		Label carl1=new Label("car 1");
		Label carl2=new Label("car 2");
		Label carl3=new Label("car 3");
		Label carl4=new Label("car 4");
		TextField text1=new TextField("1--10");
		text1.setPrefColumnCount(3);
		TextField text2=new TextField("0");
		text2.setPrefColumnCount(3);
		TextField text3=new TextField("0");
		text3.setPrefColumnCount(3);
		TextField text4=new TextField("0");
		text4.setPrefColumnCount(3);
		pane1.getChildren().addAll(carl1,text1,carl2,text2,carl3,text3,carl4,text4);
		pane1.setAlignment(Pos.BASELINE_CENTER);
		
		//引入四辆小车和线条
		VBox pane2=new VBox(50);
		pane2.setAlignment(Pos.BASELINE_LEFT);
		CarGroup car1=new CarGroup();
		CarGroup car2=new CarGroup();
		CarGroup car3=new CarGroup();
		CarGroup car4=new CarGroup();		
		pane2.getChildren().addAll(car1,car2,car3,car4);
		Line line1=new Line(0,70,500,70);
		line1.setStrokeWidth(3);
		line1.setStroke(Color.BLACK);
		Line line2=new Line(0,155,500,155);
		line2.setStrokeWidth(3);
		line2.setStroke(Color.BLACK);
		Line line3=new Line(0,240,500,240);
		line3.setStrokeWidth(3);
		line3.setStroke(Color.BLACK);
		Line line4=new Line(0,325,500,325);
		line4.setStrokeWidth(3);
		line4.setStroke(Color.BLACK);
		
		pane.getChildren().addAll(line1,line2,line3,line4);
		pane.setTop(pane1);
		pane.setCenter(pane2);
		
		//设置响应事件
		//题目要求 1最快，，于是只能分档了  输入为1--10之间
		text1.setOnAction((ActionEvent event)->
		{
			try {
			int n = Integer.parseInt(text1.getText());
			if(n>10||n<1) {
				text1.setText("invalid");
			}
			else
				car1.changeSpeed(n);
			}
			catch(Exception e) {
				System.out.println("输入值需为整数");
			}
		});
		text2.setOnAction((ActionEvent event)->
		{
			try {
			int n = Integer.parseInt(text2.getText());
			if(n>10||n<1) {
				text1.setText("invalid");
			}
			else
				car2.changeSpeed(n);}
			catch(Exception e) {
				System.out.println("输入值需为整数");
			}
		});		
		text3.setOnAction((ActionEvent event)->
		{
			try {
			int n = Integer.parseInt(text3.getText());
			if(n>10||n<1) {
				text1.setText("invalid");
			}
			else
				car3.changeSpeed(n);}
			catch(Exception e) {
				System.out.println("输入值需为整数");
			}
		});
		text4.setOnAction((ActionEvent event)->
		{
			try {
			int n = Integer.parseInt(text4.getText());
			if(n>10||n<1) {
				text1.setText("invalid");
			}
			else
				car4.changeSpeed(n);}
			catch(Exception e) {
				System.out.println("输入值需为整数");
			}
		});
		
		//初始化屏幕
		Scene scene=new Scene(pane,500,350);
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}


}
