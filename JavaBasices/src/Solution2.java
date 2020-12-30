package src;

public class Solution2 {

	public static void main(String[] args) {
		System.out.println(new Solution2().solution1(7867,1953678678));
		
		
		
	}
	public int solution1(int A, int B){
		/*String a =Integer.toString(A);
		String b = Integer.toString(B);
		return a.indexOf(b);*/
		String aString = A + "";
		String bString = B + "";

		return bString.indexOf(aString);
	}
	
	public int solution(int A, int B){
		int result = -1;
		int len = Integer.toString(B).length();
		int[] numBarray = new int[len]; 		
		for (int index = 0; index < len; index++) {
			numBarray[index] = B % 10;
			B /= 10;
		}
		int len2 = Integer.toString(A).length();
		int[] numAarray = new int[len2];
		for (int index = 0; index < len2; index++) {
			numAarray[index] = A % 10;
			A /= 10;
		}
		
		boolean found = false;
		int i;
		for (i = 0 ; i < len-len2; i++) {
			
			for (int j = 0; j < len2; j++){
				if(numBarray[i+j]==numAarray[j]){
					found = true;
				}else{
					found = false;
					break;
				}
			}
			if(found == true){
				//result = i;
				result = len-len2-i;
				//break;
			}
			
		}
		
		return result;
	}
}

