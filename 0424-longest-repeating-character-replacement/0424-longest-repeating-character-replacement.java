class Solution {
  public int characterReplacement(String s, int k) {
    int[] count = new int[26];
    int maxCount = 0;
    int start = 0;
    int result = 0;
    
    for (int end = 0; end < s.length(); end++) {
        int idx = s.charAt(end) - 'A';
        count[idx]++;
        maxCount = Math.max(maxCount, count[idx]);
        
        if (end - start + 1 - maxCount > k) {
            count[s.charAt(start) - 'A']--;
            start++;
        }
        
        result = Math.max(result, end - start + 1);
    }
    
    return result;
}

}