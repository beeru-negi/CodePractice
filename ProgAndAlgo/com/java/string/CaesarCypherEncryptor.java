package com.java.string;
/** Shift each character given string to given positions
 * ex:"xyx' key=2   => "zab"
 *  **/
public class CaesarCypherEncryptor {
	 public static String caesarCypherEncryptor(String str, int key) {
		    // Write your code here.
				char[] shiftStr = str.toCharArray();
				key = key % ('z' - 'a' +1);
				for(int i =0; i < shiftStr.length; i++)
				{
					//key = key % ('z' - 'a');
					if(shiftStr[i] + key > 'z')
					{
						
						shiftStr[i] = (char)('a' + key - ('z' - shiftStr[i]) -1);
					} else {
						shiftStr[i] = (char)(shiftStr[i] + key);
					}
				}
		    return String.valueOf(shiftStr);
		  }
}
