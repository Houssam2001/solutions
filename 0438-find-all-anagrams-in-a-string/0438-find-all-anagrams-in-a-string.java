class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        int[] freqP = new int[26]; // frequency map of characters in p
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }
        int left = 0, right = 0;
        int[] freqWindow = new int[26]; // frequency map of characters in current window
        while (right < s.length()) {
            freqWindow[s.charAt(right) - 'a']++;
            if (right - left + 1 == p.length()) {
                if (Arrays.equals(freqWindow, freqP)) {
                    result.add(left);
                }
                freqWindow[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return result;
    }
}
