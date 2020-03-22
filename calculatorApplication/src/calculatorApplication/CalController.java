package calculatorApplication;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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
	
	String outputVal = "";	
	ArrayList<String> getOper = new ArrayList<String>();
	ArrayList<String> getNumber = new ArrayList<String>();
		
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
		btnPoint.setOnAction(event->clickBtnPoint(event));
		
		btnPlus.setOnAction(event->clickBtnPlus(event));
		btnx.setOnAction(event->clickBtnMultiple(event));
		btnDivide.setOnAction(event->clickBtnDivide(event));
		btnMinus.setOnAction(event->clickBtnMinus(event));
		
		btnCencle.setOnAction(event->clickBtnCencle(event));
		btnDelete.setOnAction(event->clickBtnDelete(event));
		btnResult.setOnAction(event->clickBtnEquals(event));
	
	}
	
	// 0~9 버튼 클릭 이벤트 핸들러
	void clickBtn0(ActionEvent e) { String inputVal = btn0.getText(); saveInputVal(inputVal);}
	void clickBtn1(ActionEvent e) { String inputVal = btn1.getText(); saveInputVal(inputVal);}
	void clickBtn2(ActionEvent e) { String inputVal = btn2.getText(); saveInputVal(inputVal);}
	void clickBtn3(ActionEvent e) { String inputVal = btn3.getText(); saveInputVal(inputVal);}
	void clickBtn4(ActionEvent e) { String inputVal = btn4.getText(); saveInputVal(inputVal);}
	void clickBtn5(ActionEvent e) { String inputVal = btn5.getText(); saveInputVal(inputVal);}
	void clickBtn6(ActionEvent e) { String inputVal = btn6.getText(); saveInputVal(inputVal);}
	void clickBtn7(ActionEvent e) { String inputVal = btn7.getText(); saveInputVal(inputVal);}
	void clickBtn8(ActionEvent e) { String inputVal = btn8.getText(); saveInputVal(inputVal);}
	void clickBtn9(ActionEvent e) { String inputVal = btn9.getText(); saveInputVal(inputVal);}
	void clickBtnPoint(ActionEvent e) { String inputVal = btnPoint.getText(); saveInputVal(inputVal);}
	
	// 연산 버튼 클릭 이벤트 처리	
	void clickBtnPlus(ActionEvent e) { String inputVar = btnPlus.getText(); if(!outputVal.equals("")&&!(outputVal==null)) operDuplicationCheck(inputVar);}
	void clickBtnMinus(ActionEvent e) { String inputVar = btnMinus.getText(); if(!outputVal.equals("")&&!(outputVal==null)) operDuplicationCheck(inputVar);}
	void clickBtnMultiple(ActionEvent e) { String inputVar = btnx.getText(); if(!outputVal.equals("")&&!(outputVal==null)) operDuplicationCheck(inputVar);}
	void clickBtnDivide(ActionEvent e) { String inputVar = btnDivide.getText(); if(!outputVal.equals("")&&!(outputVal==null)) operDuplicationCheck(inputVar);}

	//입력값 저장
	void saveInputVal(String val) {
		outputVal += val;
		result.setText(outputVal);
	}
	
	//지우기 버튼 클릭 이벤트 처리
	//지우기 버튼 클릭 이벤트 처리
	void clickBtnDelete(ActionEvent e) {
		if(outputVal != null && !outputVal.equals("")) {
			outputVal = outputVal.substring(0,outputVal.length()-1);
			result.setText(outputVal);
		}else {
			result.setText("0");
		}
	}
	
	//취소 버튼 클릭 이벤트 처리
	//취소 버튼 클릭 이벤트 처리
	void clickBtnCencle(ActionEvent e) {
		outputVal = "";
		result.setText("0");
	}
	
	// 결과값 출력 버튼 이벤트 처리
	//결과값 버튼 클릭 이벤트 처리
	void clickBtnEquals(ActionEvent e) {
		if(!outputVal.equals("")&&!(outputVal==null)) {
		getNumber.add(sortNumber());
		
		double num = 0;
		double result = Double.parseDouble(getNumber.get(0));
		int operIndex = 0;

		for(int i=0; i<getNumber.size(); i++) {
			if(i!=0) {			
				num = Double.parseDouble(getNumber.get(i));
				if(getOper.get(operIndex).equals("+")) {
					result += num;
					operIndex++;
				}else if(getOper.get(operIndex).equals("-")) {
					result -= num;
					operIndex++;
				}else if(getOper.get(operIndex).equals("/")) {
					result /= num;
					operIndex++;
				}else {
					result *= num;
					operIndex++;
				}		
			}			
		}
		//정수인지 실수인지 검사
		int a =(int)result;
		double b = result - a;;

		if(b<0.1) 
			outputVal = Integer.toString((int)result);
		else 
			outputVal = Double.toString(result);
	
		this.result.setText(outputVal);		
		initializationAll();	
		}
	}
	
	//숫자 파싱
	//숫자 파싱
	String sortNumber() {
		char number;
		String numStr ="";
		String oper;

		for(int i=0; i<outputVal.length(); i++) {
			number = outputVal.charAt(i);
			if((number>=48&&number<=57)||number=='.') {
				numStr += number;
			}else {
				getNumber.add(numStr);
				oper = String.valueOf(number);
				sortOperator(oper);
				numStr = "";
			}
		}
		return numStr;
	}
	
	//연산자 파싱
	//연산자 파싱
	void sortOperator(String operVal) {
		getOper.add(operVal);

	}
	
	//연산자 중복 입력 체크
	//연산자 중복 검사
	void operDuplicationCheck(String value) {
		char getEnd;
		getEnd = outputVal.charAt(outputVal.length()-1);
		if(!(getEnd>=48)||!(getEnd<=57)) {
			outputVal = outputVal.substring(0, outputVal.length()-1);
			outputVal += value;
			result.setText(outputVal);
		}else {
			saveInputVal(value);
		}
	}
	
	//(결과 출력 후)배열 초기화 시켜주는 메소드
	//getNumber & getOper 초기화
	void initializationAll() {
		getOper.clear();
		getNumber.clear();
		outputVal = "";
		
	}
}
