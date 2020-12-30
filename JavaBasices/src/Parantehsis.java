package src;

import java.util.Stack;

public class Parantehsis {
	
	public static void main( String[] s)
	{
		String str = "())(()";
		System.out.print(solution(str));
		
	}
	static int solution(String S) {
        // write your code in Java SE 8
        if(S.length() == 0)
        return 1;
        char[] par = S.toCharArray();
        Stack<Character> st = new Stack<Character>();
        //st.push(par[0]);
        char temp;
        char topChar;
        for(int i=0; i < par.length ; i ++)
        {
        	topChar='-';
            temp = par[i];
            if(!st.isEmpty())
            {
            	topChar = st.peek();
            }
            
            if( (topChar == '(' && temp == ')') || (topChar == '[' && temp == ']') || (topChar =='{' && temp == '}') )
            {
                st.pop();
            } else
            {
                st.push(temp);
            }
        }
        
        if(st.isEmpty())
         return 1;
         else
         return 0;
    }

}
