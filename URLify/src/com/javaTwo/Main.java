package com.javaTwo;

public class Main {

    public static void main(String[] args) {
        System.out.println(URLify("Mr John Smith      ", 13));
    }

    /*
    Write a method to replace all spaces in a string with %20. You may assume that the string has sufficient
    space at the end to hold the additional characters, and that you are given the "true" length of the
    string.
     */
    public static String URLify(String str, int length) {
        int spaces = 0;
        for (int i = length - 1; i >= 0; i--) {
            char current = str.charAt(i);
            if (current == ' ' && str.charAt(i-1) != ' ' &&
                    str.charAt(i+1) != ' ') spaces++;
        }

        char[] chars = new char[length + spaces*2];
        int count = chars.length;
        for (int i = length - 1; i >= 0; i--) {
            char current = str.charAt(i);
            if (current == ' ' && str.charAt(i-1) == ' ' ||
                    current == ' ' && str.charAt(i+1) == ' ') continue;
            else if (current != ' ') chars[--count] = current;
            else {
                chars[--count] = '0';
                chars[--count] = '2';
                chars[--count] = '%';
            }
        }
        String ret = new String(chars);
        return ret;
    }
}
