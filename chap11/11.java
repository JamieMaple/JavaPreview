package entry;

import util.Stack;

class Main {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		String[] str = "+U+n+c---+e+r+t---+a-+i-+n+y---+-+r+u--+l+e+s---".split("");
		
		for (int i = 0; i < str.length - 1; i++) {
			if (str[i].equals("+")) {
				stack.push(str[i + 1]);
			} else if (str[i].equals("-")) {
				if (str[i+1].equals("-")) {
					System.out.println("Pop: " + stack.pop());
				}
			}
		}
		
		System.out.println(stack);
	}
}
