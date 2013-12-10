package calculator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

class Key implements KeyListener {
	private JTextField result = ButtonDemo.getResult();
	private String display = ButtonDemo.getDisplay();
	private boolean addNumber = ButtonDemo.isAddNumber();
	private boolean addZero = ButtonDemo.isAddZero();
	private boolean canDot = ButtonDemo.isCanDot();
	
	public void keyPressed(KeyEvent e) {
		char testChar = e.getKeyChar();
		switch(testChar) {
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		case '0':
			if(!addNumber)
				result.setText("");
			display = result.getText();
			result.setText(display + testChar);
			addNumber = true;
			addZero = false;
			break;
		case '/':
		case '*':
		case '-':
		case '+':
		case '^':
		case '%':
			display = result.getText();
			char lastChar = display.charAt(display.length()-1);
			if(lastChar != '/' && lastChar != '*' && lastChar != '-' && lastChar != '+' && lastChar != '^' && lastChar != '%') {
				if(Calculator.indexFirstOperator(display) != -1) {
					display = Double.toString(Calculator.operate(display));
				}
				result.setText(display + testChar);
				addNumber = true;
				addZero = true;
				canDot = true;
			}
			break;
		case '.':
			if(canDot) {
				if(!addNumber)
					result.setText("");
				if(addZero) {
					display = result.getText();
					result.setText(display + "0");
				}
				display = result.getText();
				result.setText(display + ".");
			}
			addNumber = true;
			canDot = false;
			break;
		case '\n':
		case '=':
			display = result.getText();
			if(Calculator.indexFirstOperator(display) != -1) {
				display = Double.toString(Calculator.operate(display));
			}
			result.setText(display);
			addNumber = false;
			addZero = true;
			canDot = true;
			break;
		case 'c':
		case 'C':
			display = "0";
			result.setText(display);
			addNumber = false;
			addZero = true;
			canDot = true;
			break;
		case '\b':
			display = result.getText();
			if(!addNumber || display.length() == 1) {
				display = "0";
				addNumber = false;
				addZero = true;
				canDot = true;
			} else {
				if(display.charAt(display.length()-1) == '.')
					canDot = true;
				display = display.substring(0, display.length()-1);
				addNumber = true;
			}
			result.setText(display);
			break;
		}
		ButtonDemo.setAddNumber(addNumber);
		ButtonDemo.setAddZero(addZero);
		ButtonDemo.setCanDot(canDot);
		ButtonDemo.setResult(result);
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
}
