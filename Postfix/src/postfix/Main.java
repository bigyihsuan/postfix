package postfix;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//declare and init classes and vars
		Scanner input = new Scanner(new File("numbers.txt"));
		Stack<Integer> stack = new Stack<Integer>();
		
		String exp = "";	//expression
		int op1, op2;		//operands
		int temp1, temp2;
		
		while (input.hasNextLine()) {
			exp = input.nextLine();
			for (int i = 0; i < exp.length(); i++) {
				//check to see if there are at least 2 elements in the stack
				System.out.println(stack);
				switch (exp.charAt(i)) {
					case '+': {
						if (stack.size() > 0 && hasTwoElements(stack)) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 + op2);
							break;
						}
					}
					case '-': {
						if (stack.size() > 0 && hasTwoElements(stack)) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 - op2);
							break;
						}
					}
					case '*': {
						if (stack.size() > 0 && hasTwoElements(stack)) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 * op2);
							break;
						}
					}
					case '/': {
						if (stack.size() > 0 && hasTwoElements(stack)) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 / op2);
							break;
						}
					}
					case '%': {
						if (stack.size() > 0 && hasTwoElements(stack)) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 % op2);
							break;
						}
					}
					case '^': {
						if (stack.size() > 0 && hasTwoElements(stack)) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 ^ op2);
							break;
						}
					}
					default: {
						stack.push(exp.charAt(i) - 48);
						break;
					}
				}
			}
		}
	public static <Integer> boolean hasTwoElements(Stack<Integer> stack) {
		int opCount = 0;
		Integer temp1 = new Integer(0);
		Integer temp2 = new Integer(0);
		boolean happened = false;
		if (!stack.isEmpty()) {
			//check if the assignment is success
			happened = ((temp1 = (java.lang.Integer) stack.pop()) != 0)
					&& ((temp2 = (java.lang.Integer) stack.pop()) != 0);
			
			if (happened) {
				stack.push(temp1);
				stack.push(temp2);
			}
		}
		return false;
	}
}
