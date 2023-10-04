//        20. Valid Parentheses | Easy
//        Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//        An input string is valid if:
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Every close bracket has a corresponding open bracket of the same type.
//        Example 1:
//        Input: s = "()"
//        Output: true

import java.util.Stack;

public class ValidParentheses {

        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for(char c: s.toCharArray()){
                if( c == '(' || c == '{' || c == '[') stack.push(c);
                else {
                    if( c == ')')
                        if(stack.isEmpty() || stack.pop() != '(') return false;

                    if( c == ']')
                        if(stack.isEmpty() || stack.pop() != '[') return false;

                    if( c == '}')
                        if(stack.isEmpty() || stack.pop() != '{') return false;

                }

            }
            return stack.isEmpty();
        }

		public static void main(String args[]) {
		  System.out.println(isValid("({[]})"));
		}
}

