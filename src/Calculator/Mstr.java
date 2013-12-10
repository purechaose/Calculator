package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class Mstr implements ActionListener {
	private String memory;
	private JTextField result;
	public void actionPerformed(ActionEvent e) {
		result = ButtonDemo.getResult();
		memory = result.getText();
		ButtonDemo.setMemory(memory);
		ButtonDemo.setAddNumber(false);
		ButtonDemo.setAddZero(false);
		ButtonDemo.setCanDot(true);
	}
}
