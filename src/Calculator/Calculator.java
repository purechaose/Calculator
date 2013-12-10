/*
 * This program takes in a string (at most 2 numbers and an operator), and if it is a valid mathematical expression,
 * it would print out the value it gets.
 */

package Calculator;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanString = new Scanner(System.in);
		System.out.println("Enter your expression.");
		String expression = scanString.nextLine();
		operate(expression);
	}
	
	/* a short way to find index values for String input */
	
	public static int index(String input) {
		//System.out.println("ran index");
		int output = input.length()-1;
		//System.out.println("index returned " + output);
		return output;
	}
	
	/* checks if the String input has the char charTest */
	
	public static boolean hasChar(String input, char charTest) {
		//System.out.println("ran hasChar");
		for(int i=0; i<=index(input); i++) {
			if(input.charAt(i) == charTest) {
				//System.out.println("hasChar returned true");
				return true;
			}
		}
		//System.out.println("hasChar returned false");
		return false;
	}
	
	/* find the first operator in String input*/
	
	public static int firstOperator(String input) {
		//System.out.println("ran firstOperator");
		int index = index(input);
		for(int i=0; i<=index; i++) {
			switch(input.charAt(i)) {
			case '%':
				//System.out.println("firstOperator returned " + 0);
				return 0;
			case '*':
				//System.out.println("firstOperator returned " + 1);
				return 1;
			case '-':
				//System.out.println("firstOperator returned " + 2);
				return 2;
			case '+':
				//System.out.println("firstOperator returned " + 3);
				return 3;
			case '/':
				//System.out.println("firstOperator returned " + 4);
				return 4;
			case '^':
				//System.out.println("firstOperator returned " + 5);
				return 5;
			}
		}
		//System.out.println("firstOperator returned " + -1);
		return -1;
	}
	
	/* finds the index of the first operator, and returns it */
	
	public static int indexFirstOperator(String input) {
		//System.out.println("ran indexFirstOperator");
		int index = index(input);
		for(int i=0; i<=index; i++) {
			switch(input.charAt(i)) {
			case '%':
			case '*':
			case '-':
			case '+':
			case '/':
			case '^':
				//System.out.println("indexFirstOperator returned " + i);
				return i;
			}	
		}
		//System.out.println("indexFirstOperator returned " + -1);
		return -1;
	}
	
	public static double numIn(String input, int startPoint) {
		//System.out.println("ran numIn(String, int)");
		String toOutput;
		double output;
		toOutput = input.substring(startPoint);
		output = Double.parseDouble(toOutput);
		//System.out.println("numIn(String, int) returned " + output);
		return output;
	}
	
	public static double numIn(String input, int startPoint, int endPoint) {

		//System.out.println("ran numIn(String, int, int)");
		String toOutput;
		double output;
		toOutput = input.substring(startPoint, endPoint);
		output = Double.parseDouble(toOutput);
		//System.out.println("numIn(String, int, int) returned " + output);
		return output;
	}
	
	/* this will use the operator on the numbers */
	
	public static double operate(String input) {

		//System.out.println("ran operate");
		double result = 0;
		int indexFirstOperator = indexFirstOperator(input);
		int firstOperator = firstOperator(input);
		if(indexFirstOperator != -1) {
			switch(firstOperator) {
			case 0:
				result = numIn(input, 0, indexFirstOperator) % numIn(input, indexFirstOperator+1);
				break;
			case 1:
				result = numIn(input, 0, indexFirstOperator) * numIn(input, indexFirstOperator+1);
				break;
			case 2:
				result = numIn(input, 0, indexFirstOperator) - numIn(input, indexFirstOperator+1);
				break;
			case 3:
				result = numIn(input, 0, indexFirstOperator) + numIn(input, indexFirstOperator+1);
				break;
			case 4:
				result = numIn(input, 0, indexFirstOperator) / numIn(input, indexFirstOperator+1);
				break;
			case 5:
				result = Math.pow(numIn(input, 0, indexFirstOperator), numIn(input, indexFirstOperator+1));
				break;
			}//end switch
		}else {
			result = Double.parseDouble(input);
		}//end if
		return result;
		//System.out.println(result);
	}
}
