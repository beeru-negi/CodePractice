package com.java.array;

public class BalancedBracketString {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("({[]})");
        System.out.println("Is balanced: " + isBalanced1(s));
    }

    public static boolean isBalanced(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isBalanced1(StringBuffer s) {
        s= new StringBuffer("[()[()]]");
        int i=0;
        int count=0;
        int j=0;

        while(i < s.length()) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                count ++;
                j=i;
                i=i+1;
            } else if (c == ')') {
                if( s.charAt(j) == '(') {
                    count --;
                    s.setCharAt(i,'*');
                    s.setCharAt(j,'*');
                    i=i+1;
                    while(j >=0 && s.charAt(j) == '*') {
                        j= j - 1;
                    }

                }
            } else if (c == '}') {
                if (s.charAt(j) == '{') {
                    count--;
                    s.setCharAt(i,'*');
                    s.setCharAt(j,'*');
                    i=i+1;
                    while (j >= 0 && s.charAt(j) == '*') {
                        j = j - 1;
                    }

                }
            } else if (c == ']') {
                if (s.charAt(j) == '[') {
                    count--;
                    s.setCharAt(i,'*');
                    s.setCharAt(j,'*');
                    i=i+1;
                    while (j >= 0 && s.charAt(j) == '*') {
                        j = j - 1;
                    }

                }
            } else {
                return false;
            }
        }
        return count == 0;
    }
}
