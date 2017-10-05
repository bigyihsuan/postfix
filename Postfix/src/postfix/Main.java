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

		do {
			System.out.print("Enter a valid postfix expression: ");
			exp = input.nextLine();
			pushOnToStack(exp, stack);
			
			if (stack.size() > 1) {
				System.out.println("Error: Not enough operators");
			} else {
				System.out.println(stack.peek());
				stack.clear();
			}
			
			System.out.print("Run again? (y/n): ");
			exp = input.nextLine();
			run = (exp.charAt(0) == 'y') ? true : false;
		} while (run);

		System.out.println("done");
	}
	
	public static <E> void pushOnToStack(String exp, Stack<Integer> stack) {
		int op1, op2;		//operands
		for (int i = 0; i < exp.length(); i++) {
			//check to see if there are at least 2 elements in the stack
			boolean thing = stack.size() >= 0;
			
			switch (exp.charAt(i)) {
				case '+': {
					if (thing && hasTwoElements(stack)) {
						op2 = stack.pop();
						op1 = stack.pop();
						stack.push(op1 + op2);
						break;
					}
				}
				case '-': {
					if (thing && hasTwoElements(stack)) {
						op2 = stack.pop();
						op1 = stack.pop();
						stack.push(op1 - op2);
						break;
					}
				}
				case '*': {
					if (thing && hasTwoElements(stack)) {
						op2 = stack.pop();
						op1 = stack.pop();
						stack.push(op1 * op2);
						break;
					}
				}
				case '/': {
					if (thing && hasTwoElements(stack)) {
						op2 = stack.pop();
						op1 = stack.pop();
						if (op2 == 0) {
							System.out.println("Error: Divide by 0!");
						} else {
							stack.push(op1 / op2);
						}
						break;
					}
				}
				case '%': {
					if (thing && hasTwoElements(stack)) {
						op2 = stack.pop();
						op1 = stack.pop();
						if (op2 == 0) {
							System.out.println("Error: Divide by 0!");
						} else {
							stack.push(op1 % op2);
						}
						break;
					}
				}
				case '^': {
					if (thing && hasTwoElements(stack)) {
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
			System.out.println(stack);
		}
	}
	
	public static <E> boolean hasTwoElements(Stack<E> stack) {
		int temp1 = 0;
		int temp2 = 0;
		boolean happened = false;
		if (!stack.isEmpty()) {
			//check if the assignment is success
			happened = ((temp1 = (java.lang.Integer) stack.pop()) != 0)
					&& ((temp2 = (java.lang.Integer) stack.pop()) != 0);
			
			if (happened) { //if the 2 assignments happened
				stack.push((E) new Integer(temp2)); //reverse order b/c popped in order
				stack.push((E) new Integer(temp1));
				return true;
			}
		}
		return false;
	}
}
