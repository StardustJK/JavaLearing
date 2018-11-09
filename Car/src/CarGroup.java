import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class CarGroup extends Group{
	private Timeline animation;
	
	public CarGroup() {
		//画小车的长方形和两个圆
		Rectangle r1=new Rectangle(0,0,50,25);
		r1.setFill(Color.MEDIUMPURPLE);
		getChildren().add(r1);
		Circle c1=new Circle(10,30,5);
		Circle c2=new Circle(40,30,5);
		c1.setFill(Color.BLACK);
		c2.setFill(Color.BLACK);
		getChildren().addAll(c1,c2);
		
		//设置时间线
		animation=new Timeline(
			new KeyFrame(Duration.millis(50),e->moveCar()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
			
	}
	//触发开始
	public void play() {
		animation.play();
	}

	//改变运动速度
	public void changeSpeed(int n) {
		animation.setRate((10-n)/2);
	}
	
	//实现动画效果，同时设置边界情况
	protected void moveCar() {
		
		if(getTranslateX()<500)
		setTranslateX(getTranslateX()+5.0);
		
		else
			setTranslateX(0);
	}
}
