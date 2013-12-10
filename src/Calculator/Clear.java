package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class Clear implements ActionListener {
	private String display;
	private JTextField result = ButtonDemo.getResult();
	public void actionPerformed(ActionEvent e) {
		display = "0";
		result.setText(display);
		ButtonDemo.setResult(result);
		ButtonDemo.setAddNumber(false);
		ButtonDemo.setAddZero(true);
		ButtonDemo.setCanDot(true);
	}
}
