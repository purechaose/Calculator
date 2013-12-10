package calculator;

import javax.swing.*;
import java.awt.*;

public class ButtonDemo extends JFrame {
	
	private static final long serialVersionUID = 3869552207799541994L;
	private JButton button7 = new JButton("7");
	private JButton button8 = new JButton("8");
	private JButton button9 = new JButton("9");
	private JButton button4 = new JButton("4");
	private JButton button5 = new JButton("5");
	private JButton button6 = new JButton("6");
	private JButton button1 = new JButton("1");
	private JButton button2 = new JButton("2");
	private JButton button3 = new JButton("3");
	private JButton button0 = new JButton("0");
	private JButton buttonDot = new JButton(".");
	private JButton buttonC = new JButton("c");
	private JButton buttonAdd = new JButton("+");
	private JButton buttonMult = new JButton("*");
	private JButton buttonDiv = new JButton("/");
	private JButton buttonSub = new JButton("-");
	private JButton buttonSlv = new JButton("=");
	private JButton buttonMem = new JButton("m");
	private JButton buttonMC = new JButton("mc");
	private JButton buttonMstr = new JButton("ms");
	private static JTextField result = new JTextField(20);
	private static String display;
	private static String memory = "0";
	private static boolean addNumber;
	private static boolean canDot = true;
	private static boolean addZero = true;
	
	public ButtonDemo() {
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 3));
		p1.setBackground(Color.decode("2571234"));

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(5, 1));
		p2.setBackground(Color.decode("2571234"));

		JPanel p3 = new JPanel();
		p3.setBackground(Color.decode("2571234"));
		
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
		p1.setFocusable(false);

		p2.add(buttonDiv);
		p2.add(buttonMult);
		p2.add(buttonSub);
		p2.add(buttonAdd);
		p2.add(buttonSlv);
		p2.setFocusable(false);
		
		p3.setLayout(new FlowLayout());
		p3.add(result = new JTextField(20));
		p3.setFocusable(false);
		result.setText("0");
		result.setHorizontalAlignment(JTextField.RIGHT);
		result.setEditable(false);

		JPanel p = new JPanel();
		p.setBackground(Color.decode("2571234"));
		p.add(p3, BorderLayout.PAGE_START);
		p.add(p1, BorderLayout.LINE_START);
		p.add(p2, BorderLayout.LINE_END);
		p.setFocusable(true);

		add(p);
		
		p.addKeyListener(new Key());
		
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
	
	public static JTextField getResult() {
		return result;
	}

	public static void setResult(JTextField r) {
		result = r;
	}

	public static String getDisplay() {
		return display;
	}

	public static void setDisplay(String s) {
		display = s;
	}

	public static String getMemory() {
		return memory;
	}

	public static void setMemory(String s) {
		memory = s;
	}

	public static boolean isAddNumber() {
		return addNumber;
	}

	public static void setAddNumber(boolean b) {
		addNumber = b;
	}

	public static boolean isCanDot() {
		return canDot;
	}

	public static void setCanDot(boolean b) {
		canDot = b;
	}

	public static boolean isAddZero() {
		return addZero;
	}

	public static void setAddZero(boolean b) {
		addZero = b;
	}

	public static void createAndShowGUI() {
		ButtonDemo calc = new ButtonDemo();
		calc.setBackground(Color.decode("2571234"));
		calc.setSize(325, 225);
		calc.setDefaultCloseOperation(ButtonDemo.EXIT_ON_CLOSE);
		calc.setResizable(false);
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
