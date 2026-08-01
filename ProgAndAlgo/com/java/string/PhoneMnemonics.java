package com.java.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Algo Expert- Phone number menemonics( possible string representation of phone number) */
public class PhoneMnemonics {

	public static void main(String[] str) {
		String phoneNumber = "1234";
		ArrayList<String> possibleMList = new PhoneMnemonics().phoneNumberMnemonics(phoneNumber);
		possibleMList.forEach(a->System.out.println(a));

	}
	public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
	    // Write your code here.
        ArrayList<String> mList = new ArrayList<>();
			phoneNumberMnemonics(phoneNumber, "", 0, mList);
			return mList;
	  }
		
		private void phoneNumberMnemonics(String phoneNumber, String menmStr, int index, ArrayList<String> mList) {
				if (index >= phoneNumber.length()) {
						return ;
				}
            List<Character> vList = getValuesForDigit(phoneNumber.charAt(index));
				for(Character c : vList)
				{
					 phoneNumberMnemonics(phoneNumber, menmStr+c, index+1, mList);			
					if(index == phoneNumber.length() -1)
					{
						//System.out.println(menmStr+s);
							mList.add(menmStr+c);
					}
				}
			
		}

    private List<Character> getValuesForDigit(char digit) {
        switch (digit) {
            case '0':
                return Arrays.asList('0');
            case '1':
                return Arrays.asList('1');
            case '2':
                return Arrays.asList('a', 'b', 'c');
            case '3':
                return Arrays.asList('d', 'e', 'f');
            case '4':
                return Arrays.asList('g', 'h', 'i');
            case '5':
                return Arrays.asList('j', 'k', 'l');
            case '6':
                return Arrays.asList('m', 'n', 'o');
            case '7':
                return Arrays.asList('p', 'q', 'r', 's');
            case '8':
                return Arrays.asList('t', 'u', 'v');
            case '9':
                return Arrays.asList('w', 'x', 'y', 'z');
            default:
                throw new IllegalArgumentException("Unsupported digit: " + digit);
        }
		}
}
