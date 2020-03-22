package calculatorApplication;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class CalController implements Initializable {
	
	@FXML Button btn0,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	@FXML Button btn;
	@FXML Button btnPoint;
	@FXML Button btnCencle;
	@FXML Button btnDelete;
	@FXML Button btnResult;
	@FXML Button btnPlus, btnMinus, btnx, btnDivide;
	
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				inputNum(event);
			}
		});
		
		
	}
	
	public void inputNum(ActionEvent e) {
		String btnNumber = btn.getText();
		printString(btnNumber);
		
	}
	
	public void printString(String num) {
		if(num!=null) {
			System.out.println(num);
		}
	}

}
