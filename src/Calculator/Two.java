package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class Two implements ActionListener {
	private boolean addNumber;
	private JTextField result;
	private String display;
	public void actionPerformed(ActionEvent e) {
		result = ButtonDemo.getResult();
		addNumber = ButtonDemo.isAddNumber();
		if(!addNumber)
			result.setText("");
		display = result.getText();
		result.setText(display + "2");
		ButtonDemo.setResult(result);
		ButtonDemo.setAddNumber(true);
		ButtonDemo.setAddZero(false);
	}
}
