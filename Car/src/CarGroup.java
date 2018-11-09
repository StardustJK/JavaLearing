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
		//��С���ĳ����κ�����Բ
		Rectangle r1=new Rectangle(0,0,50,25);
		r1.setFill(Color.MEDIUMPURPLE);
		getChildren().add(r1);
		Circle c1=new Circle(10,30,5);
		Circle c2=new Circle(40,30,5);
		c1.setFill(Color.BLACK);
		c2.setFill(Color.BLACK);
		getChildren().addAll(c1,c2);
		
		//����ʱ����
		animation=new Timeline(
			new KeyFrame(Duration.millis(50),e->moveCar()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
			
	}
	//������ʼ
	public void play() {
		animation.play();
	}

	//�ı��˶��ٶ�
	public void changeSpeed(int n) {
		animation.setRate((10-n)/2);
	}
	
	//ʵ�ֶ���Ч����ͬʱ���ñ߽����
	protected void moveCar() {
		
		if(getTranslateX()<500)
		setTranslateX(getTranslateX()+5.0);
		
		else
			setTranslateX(0);
	}
}
