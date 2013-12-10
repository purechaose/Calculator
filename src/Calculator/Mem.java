package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class Mem implements ActionListener {
	private JTextField result;
	private String memory;
	public void actionPerformed(ActionEvent e) {
		result = ButtonDemo.getResult();
		memory = ButtonDemo.getMemory();
		result.setText(memory);
		ButtonDemo.setResult(result);
		ButtonDemo.setAddNumber(false);
		ButtonDemo.setAddZero(false);
		ButtonDemo.setCanDot(true);
	}
}
