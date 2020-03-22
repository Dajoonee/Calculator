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
	
	// 0~9 ��ư Ŭ�� �̺�Ʈ �ڵ鷯
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
	
	// ���� ��ư Ŭ�� �̺�Ʈ ó��	
	void clickBtnPlus(ActionEvent e) { String inputVar = btnPlus.getText(); if(!outputVal.equals("")&&!(outputVal==null)) operDuplicationCheck(inputVar);}
	void clickBtnMinus(ActionEvent e) { String inputVar = btnMinus.getText(); if(!outputVal.equals("")&&!(outputVal==null)) operDuplicationCheck(inputVar);}
	void clickBtnMultiple(ActionEvent e) { String inputVar = btnx.getText(); if(!outputVal.equals("")&&!(outputVal==null)) operDuplicationCheck(inputVar);}
	void clickBtnDivide(ActionEvent e) { String inputVar = btnDivide.getText(); if(!outputVal.equals("")&&!(outputVal==null)) operDuplicationCheck(inputVar);}

	//�Է°� ����
	void saveInputVal(String val) {
		outputVal += val;
		result.setText(outputVal);
	}
	
	//����� ��ư Ŭ�� �̺�Ʈ ó��
	//����� ��ư Ŭ�� �̺�Ʈ ó��
	void clickBtnDelete(ActionEvent e) {
		if(outputVal != null && !outputVal.equals("")) {
			outputVal = outputVal.substring(0,outputVal.length()-1);
			result.setText(outputVal);
		}else {
			result.setText("0");
		}
	}
	
	//��� ��ư Ŭ�� �̺�Ʈ ó��
	//��� ��ư Ŭ�� �̺�Ʈ ó��
	void clickBtnCencle(ActionEvent e) {
		outputVal = "";
		result.setText("0");
	}
	
	// ����� ��� ��ư �̺�Ʈ ó��
	//����� ��ư Ŭ�� �̺�Ʈ ó��
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
		//�������� �Ǽ����� �˻�
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
	
	//���� �Ľ�
	//���� �Ľ�
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
	
	//������ �Ľ�
	//������ �Ľ�
	void sortOperator(String operVal) {
		getOper.add(operVal);

	}
	
	//������ �ߺ� �Է� üũ
	//������ �ߺ� �˻�
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
	
	//(��� ��� ��)�迭 �ʱ�ȭ �����ִ� �޼ҵ�
	//getNumber & getOper �ʱ�ȭ
	void initializationAll() {
		getOper.clear();
		getNumber.clear();
		outputVal = "";
		
	}
}
