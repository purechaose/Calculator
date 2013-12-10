package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class Dot implements ActionListener {
	private String display;
	private JTextField result;
	private boolean canDot;
	private boolean addNumber;
	private boolean addZero;
	public void actionPerformed(ActionEvent e) {
		canDot = ButtonDemo.isCanDot();
		addNumber = ButtonDemo.isAddNumber();
		addZero = ButtonDemo.isAddZero();
		result = ButtonDemo.getResult();
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
		ButtonDemo.setResult(result);
		ButtonDemo.setAddNumber(true);
		ButtonDemo.setCanDot(false);
	}
}
