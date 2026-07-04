package com.strings.jalana;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        // Store frequency of characters in T
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;

        int required = map.size(); // Number of unique characters
        int formed = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char current = s.charAt(right);

            // If current character is required
            if (map.containsKey(current)) {

                map.put(current, map.get(current) - 1);

                // Character requirement fulfilled
                if (map.get(current) == 0) {
                    formed++;
                }
            }

            // Try shrinking the window
            while (left <= right && formed == required) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {

                    map.put(leftChar, map.get(leftChar) + 1);

                    // Window is no longer valid
                    if (map.get(leftChar) > 0) {
                        formed--;
                    }
                }

                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}