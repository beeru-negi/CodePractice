package com.java.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSunstringWithoutDuplicate {
    public static void main(String[] args) {
        char[] charArray  = "sfsrte".toCharArray();
        String s="1V1W";
        Arrays.sort(charArray);
        List<Character> charList =s.chars().filter(Character::isLetterOrDigit).mapToObj(c-> (char)c).toList();
        Set<Character> charSet = new HashSet<>(charList);
        charSet.clear();
        System.out.println("Max sub stirng-" + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        //List<Character> charList = s.chars().filter(Character::isLetterOrDigit).mapToObj(c -> (char) c).toList();
        Set<Character> charSet = new HashSet<>();
        //System.out.println("Max sub stirng-" + charSet.toString() + "-" + charSet.size());
        //return charSet.size();
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (charSet.add(s.charAt(j))) {
                    count++;
                    continue;
                }
                break;
            }
            if (maxCount < count) {
                maxCount = count;
            }
            charSet.clear();
            count = 0;
        }
        return maxCount;
    }
}

