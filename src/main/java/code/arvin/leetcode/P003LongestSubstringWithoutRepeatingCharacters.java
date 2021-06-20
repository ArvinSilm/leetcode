package code.arvin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">Longest Substring Without Repeating Characters</a>
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class P003LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String subStr = "";
        int maxLength = 1, lIndex = 0, rIndex;
        for (int i = 0; i < s.length(); i++) {
            rIndex = i;
            String chr = String.valueOf(s.charAt(i));
            if (!subStr.contains(chr)) {
                subStr = subStr.concat(chr);
                maxLength = Math.max(subStr.length(), maxLength);
                continue;
            }
            lIndex = lIndex + subStr.indexOf(chr) + 1;
            subStr = s.substring(lIndex, rIndex + 1);
        }
        return maxLength;
    }
}
