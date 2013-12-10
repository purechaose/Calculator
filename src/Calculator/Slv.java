package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

class Slv implements ActionListener {
	private String display;
	private JTextField result;
	public void actionPerformed(ActionEvent e) {
		result = ButtonDemo.getResult();
		display = result.getText();
		if(Calculator.indexFirstOperator(display) != -1) {
			display = Double.toString(Calculator.operate(display));
		}
		result.setText(display);
		ButtonDemo.setResult(result);
		ButtonDemo.setAddNumber(false);
		ButtonDemo.setAddZero(true);
		ButtonDemo.setCanDot(true);
	}
}