package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonDemo extends JFrame {
	
	private static final long serialVersionUID = 3869552207799541994L;
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button0 = new JButton("0");
	JButton buttonDot = new JButton(".");
	JButton buttonC = new JButton("c");
	JButton buttonAdd = new JButton("+");
	JButton buttonMult = new JButton("*");
	JButton buttonDiv = new JButton("/");
	JButton buttonSub = new JButton("-");
	JButton buttonSlv = new JButton("=");
	JButton buttonMem = new JButton("m");
	JButton buttonMC = new JButton("mc");
	JButton buttonMstr = new JButton("ms");
	static JTextField result = new JTextField(20);
	static String display;
	static String memory = "0";
	static boolean addNumber;
	static boolean canDot = true;
	static boolean addZero = true;
	
	public ButtonDemo() {
		JPanel p = new JPanel();
		p.setFocusable(true);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 3));
		p1.setBackground(Color.decode("2571234"));
		p1.setFocusable(false);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(5, 1));
		p2.setBackground(Color.decode("2571234"));
		p2.setFocusable(false);

		JPanel p3 = new JPanel();
		p3.setBackground(Color.decode("2571234"));
		p3.setFocusable(false);
		
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		button4.setFocusable(false);
		button5.setFocusable(false);
		button6.setFocusable(false);
		button7.setFocusable(false);
		button8.setFocusable(false);
		button9.setFocusable(false);
		button0.setFocusable(false);
		buttonDot.setFocusable(false);
		buttonC.setFocusable(false);
		buttonDiv.setFocusable(false);
		buttonMult.setFocusable(false);
		buttonAdd.setFocusable(false);
		buttonSub.setFocusable(false);
		buttonSlv.setFocusable(false);
		buttonMstr.setFocusable(false);
		buttonMem.setFocusable(false);
		buttonMC.setFocusable(false);
		
		p1.add(buttonMstr);
		p1.add(buttonMem);
		p1.add(buttonMC);
		p1.add(button7);
		p1.add(button8);
		p1.add(button9);
		p1.add(button4);
		p1.add(button5);
		p1.add(button6);
		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p1.add(button0);
		p1.add(buttonDot);
		p1.add(buttonC);

		p2.add(buttonDiv);
		p2.add(buttonMult);
		p2.add(buttonSub);
		p2.add(buttonAdd);
		p2.add(buttonSlv);
		
        p3.setLayout(new FlowLayout());
        p3.add(result = new JTextField(20));
        result.setText("0");
        result.setHorizontalAlignment(JTextField.RIGHT);
        result.setEditable(false);

		p.setBackground(Color.decode("2571234"));
		p.add(p3, BorderLayout.PAGE_START);
		p.add(p1, BorderLayout.LINE_START);
		p.add(p2, BorderLayout.LINE_END);

		add(p);
		
		p.addKeyListener(new Key());

		button1.addActionListener(new One());
		button2.addActionListener(new Two());
		button3.addActionListener(new Three());
		button4.addActionListener(new Four());
		button5.addActionListener(new Five());
		button6.addActionListener(new Six());
		button7.addActionListener(new Seven());
		button8.addActionListener(new Eight());
		button9.addActionListener(new Nine());
		button0.addActionListener(new Zero());
		buttonDot.addActionListener(new Dot());
		buttonC.addActionListener(new Clear());
		buttonDiv.addActionListener(new Div());
		buttonMult.addActionListener(new Mult());
		buttonAdd.addActionListener(new Add());
		buttonSub.addActionListener(new Sub());
		buttonSlv.addActionListener(new Slv());
		buttonMstr.addActionListener(new Mstr());
		buttonMem.addActionListener(new Mem());
		buttonMC.addActionListener(new MC());
	}
	
	class Key implements KeyListener {
		public void keyTyped(KeyEvent e){
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
			case 'c':
				display = "0";
	            result.setText(display);
				addNumber = false;
				addZero = true;
				canDot = true;
				break;
			case '/':
			case '*':
			case '-':
			case '+':
			case '^':
			case '%':
				display = result.getText();
				if(Calculator.indexFirstOperator(display) != -1) {
					display = Double.toString(Calculator.operate(display));
				}
				result.setText(display + testChar);
				addNumber = true;
				addZero = true;
				canDot = true;
				break;
			case '=':
			case '\n':
				display = result.getText();
				if(Calculator.indexFirstOperator(display) != -1) {
					display = Double.toString(Calculator.operate(display));
				}
				result.setText(display);
				addNumber = false;
				addZero = true;
				canDot = true;
				break;
			case '\b':
				display = result.getText();
				if(display.charAt(display.length()-1) == '.')
					canDot = true;
				if(!addNumber) {
					display = "0";
					addZero = true;
					canDot = true;
				} else {
					addNumber = true;
					display = display.substring(0, display.length()-1);
				}
				result.setText(display);
				break;
			}
		}
		public void keyPressed(KeyEvent arg0) {}
		public void keyReleased(KeyEvent arg0) {}
	}
	
	class Mstr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			memory = result.getText();
			addNumber = false;
			addZero = false;
			canDot = true;
		}
	}
	
	class Mem implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			result.setText(memory);
			addNumber = false;
			addZero = false;
			canDot = true;
		}
	}
	
	class MC implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			memory = "0";
			addNumber = false;
			addZero = false;
			canDot = true;
		}
	}
	
	class One implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!addNumber)
				result.setText("");
			display = result.getText();
			result.setText(display + "1");
			addNumber = true;
			addZero = false;
		}
	}

	class Two implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!addNumber)
				result.setText("");
			display = result.getText();
			result.setText(display + "2");
			addNumber = true;
			addZero = false;
		}
	}
	
	class Three implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!addNumber)
				result.setText("");
			display = result.getText();
			result.setText(display + "3");
			addNumber = true;
			addZero = false;
		}
	}

	class Four implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!addNumber)
				result.setText("");
			display = result.getText();
			result.setText(display + "4");
			addNumber = true;
			addZero = false;
		}
	}

	class Five implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!addNumber)
				result.setText("");
			display = result.getText();
			result.setText(display + "5");
			addNumber = true;
			addZero = false;
		}
	}

	class Six implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!addNumber)
				result.setText("");
			display = result.getText();
			result.setText(display + "6");
			addNumber = true;
			addZero = false;
		}
	}

	class Seven implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!addNumber)
				result.setText("");
			display = result.getText();
			result.setText(display + "7");
			addNumber = true;
			addZero = false;
		}
	}

	class Eight implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!addNumber)
				result.setText("");
			display = result.getText();
			result.setText(display + "8");
			addNumber = true;
			addZero = false;
		}
	}

	class Nine implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!addNumber)
				result.setText("");
			display = result.getText();
			result.setText(display + "9");
			addNumber = true;
			addZero = false;
		}
	}

	class Zero implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!addNumber)
				result.setText("");
			display = result.getText();
			result.setText(display + "0");
			addNumber = true;
			addZero = false;
		}
	}

	class Dot implements ActionListener {
		public void actionPerformed(ActionEvent e) {
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
		}
	}

	class Clear implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = "0";
            result.setText(display);
			addNumber = false;
			addZero = true;
			canDot = true;
		}
	}

	class Div implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = result.getText();
			if(Calculator.indexFirstOperator(display) != -1) {
				display = Double.toString(Calculator.operate(display));
			}
			result.setText(display + "/");
			addNumber = true;
			addZero = true;
			canDot = true;
		}
	}

	class Mult implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = result.getText();
			if(Calculator.indexFirstOperator(display) != -1) {
				display = Double.toString(Calculator.operate(display));
			}
			result.setText(display + "*");
			addNumber = true;
			addZero = true;
			canDot = true;
		}
	}

	class Add implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = result.getText();
			if(Calculator.indexFirstOperator(display) != -1) {
				display = Double.toString(Calculator.operate(display));
			}
			result.setText(display + "+");
			addNumber = true;
			addZero = true;
			canDot = true;
		}
	}

	class Sub implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = result.getText();
			if(Calculator.indexFirstOperator(display) != -1) {
				display = Double.toString(Calculator.operate(display));
			}
			result.setText(display + "-");
			addNumber = true;
			addZero = true;
			canDot = true;
		}
	}
	
	class Slv implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = result.getText();
			if(Calculator.indexFirstOperator(display) != -1) {
				display = Double.toString(Calculator.operate(display));
			}
			result.setText(display);
			addNumber = false;
			addZero = true;
			canDot = true;
		}
	}
	
	public static void createAndShowGUI() {
		ButtonDemo calc = new ButtonDemo();
		calc.setBackground(Color.decode("2571234"));
		calc.setSize(330, 225);
		calc.setDefaultCloseOperation(ButtonDemo.EXIT_ON_CLOSE);
		calc.setResizable(false);
		calc.setFocusable(false);
		calc.setTitle("Calculator");
		calc.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
