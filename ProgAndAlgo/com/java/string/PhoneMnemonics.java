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
			ArrayList<String> mList = new ArrayList<String>();
			phoneNumberMnemonics(phoneNumber, "", 0, mList);
			return mList;
	  }
		
		private void phoneNumberMnemonics(String phoneNumber, String menmStr, int index, ArrayList<String> mList) {
				if (index >= phoneNumber.length()) {
						return ;
				}
				List<Character> vList = getValuesForDigit(Character.toString(phoneNumber.charAt(index)));
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
		
		private List<Character> getValuesForDigit(String pDigit) {
			List<Character>[] mValArray = new List[10];
			mValArray[0] = new ArrayList<Character>(Arrays.asList('0'));
			mValArray[1] = new ArrayList<Character>(Arrays.asList('1'));
			mValArray[2] = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
			mValArray[3] = new ArrayList<Character>(Arrays.asList('d', 'e', 'f'));
			mValArray[4] = new ArrayList<Character>(Arrays.asList('g', 'h', 'i'));
			mValArray[5] = new ArrayList<Character>(Arrays.asList('j', 'k', 'l'));
			mValArray[6] = new ArrayList<Character>(Arrays.asList('m', 'n', 'o'));
			mValArray[7] = new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's'));
			mValArray[8] = new ArrayList<Character>(Arrays.asList('t', 'u', 'v'));
			mValArray[9] = new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z'));

			return mValArray[Integer.valueOf(pDigit)];
		}
}
