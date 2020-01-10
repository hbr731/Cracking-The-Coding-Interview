package com.javaTwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isPermutation("abcd", "dbae")); // false
        System.out.println(isPermutation("abcd", "dbac")); // true
        System.out.println(isPermutation("abcd", "dbaef")); // false
        System.out.println(isPermutation("abcd", "aabc")); // false

        System.out.println();

        Map<Character, Integer> charsMap = new HashMap<>();
        System.out.println(isPermutation("abcd", "dbac", charsMap)); // true
        charsMap = new HashMap<>();
        System.out.println(isPermutation("abcd", "dbae", charsMap)); // false
        charsMap = new HashMap<>();
        System.out.println(isPermutation("abcd", "aabc", charsMap)); // false

        System.out.println();

        System.out.println(checkPermutation("abcd", "dbae")); // false
        System.out.println(checkPermutation("abcd", "dbac")); // true
        System.out.println(checkPermutation("abcd", "dbaef")); // false
        System.out.println(checkPermutation("abcd", "aabc")); // false
    }

    /*
    Given two strings, write a method to decide if one is a permutation of the other
    */

    // with mutating the string but no extra space in memory, O(n)
    public static boolean isPermutation(String s1, String s2) {
        // if their not of equal size, they cant be permutations of each other.
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            int idx;
            if (i < s1.length() - 1) idx = s2.indexOf(s1.substring(i, i+1));
            else idx = s2.indexOf(s1.substring(s1.length() - 1));
//            System.out.println(idx);

            if (s2.contains(s1.substring(i, i+1))) {
//                s1 = s1.substring(0, i) + s1.substring(i + 1);
                s2 = s2.substring(0, idx) + s2.substring(idx + 1);
            }
            else return false;
        }

        return true;
    }

    // without mutating the string but using a data structure, O(n)
    public static boolean isPermutation(String s1, String s2,
                                        Map<Character, Integer> charsMap) {
        // if their not of equal size, they cant be permutations of each other.
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++){
            char current = s1.charAt(i);
            Integer val = charsMap.get(current);

            if (val == null) charsMap.put(current, 1);
            else charsMap.put(current, charsMap.get(current) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char current = s2.charAt(i);
            Integer val = charsMap.get(current);

            // not permutations if the current char isnt in the map
            if (val == null) return false;

            if (val > 0) charsMap.put(current, charsMap.get(current) - 1);
            else return false; // one too many of the current char in string 2.
        }

        return true;
    }

    // sorting the strings, O(nLogn)
    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) return false;
        }

        return true;
    }
}
