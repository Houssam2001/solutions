class Solution {
  public int longestPalindrome(String s) {
    int[] freq = new int[128]; // 128 is the number of ASCII characters
    
    // Count the frequency of each character in the string
    for (char c : s.toCharArray()) {
        freq[c]++;
    }
    
    int len = 0;
    boolean hasOddFreq = false;
    
    // Compute the length of the longest palindrome
    for (int f : freq) {
        if (f % 2 == 0) {
            len += f;
        } else {
            len += f - 1;
            hasOddFreq = true;
        }
    }
    
    // Add one to the length if there is an odd frequency character
    if (hasOddFreq) {
        len++;
    }
    
    return len;
}

}