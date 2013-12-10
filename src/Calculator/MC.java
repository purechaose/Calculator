package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MC implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		ButtonDemo.setMemory("0");
		ButtonDemo.setAddNumber(false);
		ButtonDemo.setAddZero(false);
		ButtonDemo.setCanDot(true);
	}
}
