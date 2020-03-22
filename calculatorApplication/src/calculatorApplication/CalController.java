package calculatorApplication;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalController implements Initializable {
	
	@FXML Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

	@FXML Button btnPoint;
	@FXML Button btnCencle;
	@FXML Button btnDelete;
	@FXML Button btnResult;
	@FXML Button btnPlus, btnMinus, btnx, btnDivide;
	@FXML Label result;
	String showNumber="";
	String theNum ="";
	int number = 0;
	ArrayList<String> num = new ArrayList<String>();
	ArrayList <String> operator = new ArrayList<String>();
	int i = 0;
	
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				getNum1(event);
			}
			
		});
		btn2.setOnAction(event->getNum2(event));
		btnPlus.setOnAction(event->plus(event));
		btnResult.setOnAction(event->result(event));
		
	}
	
	public void getNum1(ActionEvent e) {
		String btnNumber = btn1.getText();
		printString(showNumber);
		showNumber += btnNumber;
		theNum += btnNumber;
		result.setText(showNumber);

		
	}
	public void getNum2(ActionEvent e) {
		String btnNumber = btn2.getText();
		printString(showNumber);
		showNumber += btnNumber;
		theNum += btnNumber;
		result.setText(showNumber);
		
	}
	
	public void plus(ActionEvent e) {
		showNumber += btnPlus.getText();
		result.setText(showNumber);
		printString(showNumber);
		number += (Integer.parseInt(theNum));
		operator.add("+");
		theNum ="";
	}
	
	public void result(ActionEvent e) {
		if(operator.get(operator.size()-1)=="+"){
			
			number += Integer.parseInt(theNum);
			result.setText(Integer.toString(number));
			showNumber="";
			number = 0;
			for(int i=0; i<operator.size(); i++) {
				operator.remove(i);
			}
		}
	}
	
	public void printString(String num) {
		if(num!=null) {
			System.out.print(num);
		}
	}
	
	public void calculation() {
		
	}

}
