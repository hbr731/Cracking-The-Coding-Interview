package com.javaTwo;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Set<Character> charSet = new HashSet<>();
        System.out.println(isUnique("test", charSet));
        charSet = new HashSet<>();
        System.out.println(isUnique("teaspon", charSet));

        System.out.println();

        System.out.println(isUnique("test"));
        System.out.println(isUnique("teaspon"));
    }


    // Implement an algorithm to determine if a string has all unique characters.
    public static boolean isUnique(String s, Set<Character> charset) {
        if (s.length() > 128) return false; // 128 characters in ASCII
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            Character current = charArray[i];
            if (charset.contains(current)) return false;
            else charset.add(current);
        }

        return true;
    }


    // What if you cannot use additional data structures?
    public static boolean isUnique(String s) {
        if (s.length() > 128) return false;

        // we dont need to check the last element
        for (int i = 0; i < s.length() - 1; i++){
            String current = "";
            current += s.charAt(i);
//            System.out.println(current);
            if (s.substring(i + 1).contains(current))
                return false;
        }
        return true;
    }
}
