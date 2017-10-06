package postfix;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//declare and init classes and vars
		Scanner input = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();

		String exp = ""; //expression
		boolean run;
		int ops;	//number of operators in expression
		int num;	//number of numbers in expression

		do {
			System.out.print("Enter a valid postfix expression: ");
			exp = input.nextLine();
			ops = 0;
			num = 0;
			
			for (int i = 0; i < exp.length(); i++) {
				if (Character.isDigit(exp.charAt(i))) {
					num++;
				} else {
					switch (exp.charAt(i)) {
						case '+':
							ops++; break;
						case '-':
							ops++; break;
						case '*':
							ops++; break;
						case '/':
							ops++; break;
						case '%':
							ops++; break;
						case '^':
							ops++; break;
						default:
							break;
					}
				}
			}
			
			//length of 1, just print
			//length of 2+, AND not enough/too many ops, give error
			//length of 2+, AND enough ops, process
			if (exp.length() == 1 && Character.isDigit(exp.charAt(0))) {
				System.out.println(exp);
			} else if (num - 1 != ops){
				System.out.println("Error: Invalid expression/operator count");
			} else {
				proccessString(exp, stack);
				System.out.println(stack.peek());
				stack.clear();
			}

			System.out.print("Run again? (y to continue, anything else to exit): ");
			exp = input.nextLine();
			if (!exp.equals("") && exp.charAt(0) == 'y') {
				run = true; 
			} else {
				run = false;
			}
		} while (run);

		System.out.println("done");
	}

	public static <E> void proccessString(String exp, Stack<Integer> stack) {
		int op1, op2;		//operands
		for (int i = 0; i < exp.length(); i++) {
			//check to see if there are at least 2 elements in the stack
			boolean hasTwoElements = stack.size() >= 2;
			
				switch (exp.charAt(i)) {
					case '+': {
						if (hasTwoElements) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 + op2);
							break;
						}
					}
					case '-': {
						if (hasTwoElements) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 - op2);
							break;
						}
					}
					case '*': {
						if (hasTwoElements) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push(op1 * op2);
							break;
						}
					}
					case '/': {
						if (hasTwoElements) {
							op2 = stack.pop();
							op1 = stack.pop();
							if (op2 == 0) {
								System.out.println("Error: Divide by 0!");
								return;
							} else {
								stack.push(op1 / op2);
								break;
							}
						}
					}
					case '%': {
						if (hasTwoElements) {
							op2 = stack.pop();
							op1 = stack.pop();
							if (op2 == 0) {
								System.out.println("Error: Divide by 0!");
								return;
							} else {
								stack.push(op1 % op2);
								break;
							}
						}
					}
					case '^': {
						if (hasTwoElements) {
							op2 = stack.pop();
							op1 = stack.pop();
							stack.push((int)Math.pow(op1, op2));
							break;
						}
					}
					default: {
						stack.push(exp.charAt(i) - 48);
						break;
					}
			}
			//debug
			System.out.println(stack);
		}
	}
}
