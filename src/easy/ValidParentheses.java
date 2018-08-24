package easy;
import java.util.*;
public class ValidParentheses {
//	solution 
	public static boolean match(char a, char b) {
		if((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}')) {
			return true;
		}
		return false;
	}
	//使用栈匹配字符进出
	public static boolean isValid(String s) {
		if(s.length() % 2 != 0) {
			return false;
		}
		if(s.length() == 0) {
			return true;
		}
		char[] stack = new char[s.length()];
		stack[0] = s.charAt(0);
		//循环判断
		int i = 1;
		int j = 1;
		while(i < s.length() && j < s.length()) {
			if(i == 0) {
				stack[0] = s.charAt(j);
				i++;
				j++;
				continue;
			}
			if(match(stack[i - 1], s.charAt(j))) {
				i--;
				j++;
			}
			else {
				stack[i] = s.charAt(j);
				i++;
				j++;
			}
		}
		if(i == 0) {
			return true;
		}
		else {
			return false;
		}
	}
//	突然想到使用charAt，可以不读取到数组？
//	solution
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty() || c == '(' || c == '[' || c == '{') stack.push(c);
            else if (c == ')' && stack.peek() == '(' || c == ']' && stack.peek() == '[' || c == '}' && stack.peek() == '{') stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
	
//    JiuZhang solution1
    public boolean isValidParentheses1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
        if ("({[".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
               if (!stack.isEmpty() && is_valid(stack.peek(), c)) {
                   stack.pop();
               } else {
                   return false;
               }
           }
       }
       return stack.isEmpty();
    }

    private boolean is_valid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
            || (c1 == '[' && c2 == ']');
    }
//    JiuZhang solution2
    public boolean isValidParentheses2(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    
    public static void main(String[] args) {
		String s1 = "()";
		String s2 = "()[]{}";
		String s3 = "{[()]}";
		String s4 = "{]}";
		String s5 = "{[))";
		System.out.println(isValid(s1));
		System.out.println(isValid(s2));
		System.out.println(isValid(s3));
		System.out.println(isValid(s4));
		System.out.println(isValid(s5));
		System.out.println(isValid(""));

	}
}
