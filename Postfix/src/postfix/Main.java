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
		int opCount;		//num of operands. max 2
		boolean hasTwoElements = false;
		int temp1, temp2;
		
		while (input.hasNextLine()) {
			exp = input.nextLine();
			for (int i = 0; i < exp.length(); i++) {
				//check to see if there are at least 2 elements in the stack
				opCount = 0;
				if (!stack.isEmpty()) {
					//check if the assignment is success
					if ((Integer)(temp1 = stack.pop()) != null && (Integer)(temp1 = stack.pop()) != null) {
						hasTwoElements = true;
					}
				}
				System.out.println(stack);
				switch (exp.charAt(i)) {
					case '+': {
						if (stack.size() > 0 && hasTwoElements) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 + op2);
							break;
						}
					}
					case '-': {
						if (stack.size() > 0 && hasTwoElements) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 - op2);
							break;
						}
					}
					case '*': {
						if (stack.size() > 0 && hasTwoElements) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 * op2);
							break;
						}
					}
					case '/': {
						if (stack.size() > 0 && hasTwoElements) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 / op2);
							break;
						}
					}
					case '%': {
						if (stack.size() > 0 && hasTwoElements) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 % op2);
							break;
						}
					}
					case '^': {
						if (stack.size() > 0 && hasTwoElements) {
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
		
	}

}
