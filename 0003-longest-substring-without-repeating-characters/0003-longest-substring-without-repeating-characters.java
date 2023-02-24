class Solution {
   public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int left = 0;
    int maxLen = 0;
    Set<Character> charSet = new HashSet<>();
    for (int right = 0; right < n; right++) {
        while (charSet.contains(s.charAt(right))) {
            charSet.remove(s.charAt(left));
            left++;
        }
        charSet.add(s.charAt(right));
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}

}