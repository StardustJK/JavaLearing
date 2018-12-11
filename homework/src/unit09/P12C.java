package unit09;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * 使用WebView编写一个建议浏览器
 * 
  +--------------------------------------------+
  |          +------------------------------+  |
  |  Address | http://www.bupt.edu.cn       |  |
  |          +------------------------------+  |
  | +---------------------------------------+  |
  | |                                       |  |
  | |            WebView                    |  |
  | |                                       |  |
  | +---------------------------------------+  |
  +--------------------------------------------+
 */

public class P12C extends Application {

  @Override
  public void start(Stage primaryStage) {
    // a Label, a Textfield in a HBox
	  Label la=new Label("Adddress");
	  var tf=new TextField();
	  var ip=new Label("IP");
	  var iptf=new TextField();
    // HBox and a WebView in BorderPane
	  var hb=new HBox(10);
	  hb.getChildren().addAll(la,tf,ip,iptf);
	  var wv=new WebView();
	  
	  BorderPane bp=new BorderPane();
	  bp.setTop(hb);
	  bp.setBottom(wv);
	  
    // TextBox: setOnAction (EventHandler<ActionEvent> e)
    // new URL from TextBox's text
	  tf.setOnAction(e->{
		  InetAddress address=null;
		try {
			address=InetAddress.getByName((tf.getText()));
			iptf.setText(address.getHostAddress());

			wv.getEngine().load("http://"+address.getHostName());
		} catch (UnknownHostException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		 
	  });
    
    // new Scene; Stage: setScene, setTitle, show;
	  var scene=new Scene(bp,800,500);
	  primaryStage.setScene(scene);
	  primaryStage.setTitle("web browser");
	  primaryStage.show();
  }
  public static void main(String[] args) {    
    Application.launch(args);
  }

}