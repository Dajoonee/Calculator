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
	String outputVar = "";
	
	ArrayList<String> getOper = new ArrayList<String>();
	ArrayList<String> getNumber = new ArrayList<String>();
	
	int finalResult = 0;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		
		btn0.setOnAction(event->clickBtn0(event));
		btn1.setOnAction(event->clickBtn1(event));
		btn2.setOnAction(event->clickBtn2(event));
		btn3.setOnAction(event->clickBtn3(event));
		btn4.setOnAction(event->clickBtn4(event));
		btn5.setOnAction(event->clickBtn5(event));
		btn6.setOnAction(event->clickBtn6(event));
		btn7.setOnAction(event->clickBtn7(event));
		btn8.setOnAction(event->clickBtn8(event));
		btn9.setOnAction(event->clickBtn9(event));
	
	
	}
	
	// 0~9 버튼 클릭 이벤트 핸들러
	void clickBtn0(ActionEvent e) { String inputVar = btn0.getText(); saveInputVar(inputVar);}
	void clickBtn1(ActionEvent e) { String inputVar = btn1.getText(); saveInputVar(inputVar);}
	void clickBtn2(ActionEvent e) { String inputVar = btn2.getText(); saveInputVar(inputVar);}
	void clickBtn3(ActionEvent e) { String inputVar = btn3.getText(); saveInputVar(inputVar);}
	void clickBtn4(ActionEvent e) { String inputVar = btn4.getText(); saveInputVar(inputVar);}
	void clickBtn5(ActionEvent e) { String inputVar = btn5.getText(); saveInputVar(inputVar);}
	void clickBtn6(ActionEvent e) { String inputVar = btn6.getText(); saveInputVar(inputVar);}
	void clickBtn7(ActionEvent e) { String inputVar = btn7.getText(); saveInputVar(inputVar);}
	void clickBtn8(ActionEvent e) { String inputVar = btn8.getText(); saveInputVar(inputVar);}
	void clickBtn9(ActionEvent e) { String inputVar = btn9.getText(); saveInputVar(inputVar);}
	
	// 연산 버튼 클릭 이벤트 처리	
	void clickBtnPlus(ActionEvent e) { String inputVar = btnPlus.getText(); saveInputVar(inputVar);}
	void clickBtnMinus(ActionEvent e) { String inputVar = btnMinus.getText(); saveInputVar(inputVar);}
	void clickBtnx(ActionEvent e) { String inputVar = btnx.getText(); saveInputVar(inputVar);}
	void clickBtnDivide(ActionEvent e) { String inputVar = btnDivide.getText(); saveInputVar(inputVar);}
	
	void saveInputVar(String var) {
		outputVar += var;
		result.setText(outputVar);
	}
	

}
