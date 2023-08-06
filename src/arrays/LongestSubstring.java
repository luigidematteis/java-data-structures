package arrays;

import java.util.HashMap;
import java.util.Map;

/*
    Given a string s, find the length of the longest substring without repeating characters.
    Example:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
*/
public class LongestSubstring {

    // The brute force approach would be to iterate through each element of the array,
    // store the current values into a map, go straight until we don't meet an element equals to
    // one of the elements already stored, and set accordingly the max substring length.
    // This would have a quadratic time complexity: O(n^2)

    // a b c d b a b c b b
    // Iterate through the array

    // Declare a map<char, index>
    // If the current chars[i] is not present in the map, we add it
    // and we store the current map size as max substring length found
    // [a] b c d b a b c b b
    // [a b] c d b a b c b b
    // [a b c] d b a b c b b
    // [a b c d] b a b c b b

    // When we found a duplicate trying to add chars[i] in the map:
    // [a b c d (b)] a b c b b
    // We store the current map size as max substring length found,
    // then we can take the index of the duplicate and remove all the element in the map
    // starting from chars[duplicateIndex] going back to the value of _left_
    // then we update the value of _left_ and add the current chars[i]

    // At this point, we will be in a situation like this:
    // <a b> [c d b] a b c b b
    // And we continue the iteration:
    // <a b> [c d b a] b c b b
    // <a b> [c d b a (b)] c b b
    // We do again as described in the previous point
    // We will be then in a situation like this:
    // <a b c d b> [a b] c b b

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int maxSubstringLength = 0;
        int left = 0;

        for (int i = 0; i < chars.length; i++) {

            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
                maxSubstringLength = Math.max(maxSubstringLength, map.size());
            } else {
                maxSubstringLength = Math.max(maxSubstringLength, map.size());
                int pointer = map.get(chars[i]);
                int tmpLeft = left;
                for (int j = pointer; j >= tmpLeft; j--) {
                    map.remove(chars[j]);
                    left++;
                }
                map.put(chars[i], i);
            }

        }

        System.out.println("Result: " + maxSubstringLength);
        return maxSubstringLength;
    }

}
