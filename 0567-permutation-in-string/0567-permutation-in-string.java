class Solution {
    public boolean checkInclusion(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    if (n > m) {
        return false;
    }
    int[] s1Freq = new int[26];
    int[] s2Freq = new int[26];
    for (int i = 0; i < n; i++) {
        s1Freq[s1.charAt(i) - 'a']++;
        s2Freq[s2.charAt(i) - 'a']++;
    }
    for (int i = 0; i < m - n; i++) {
        if (Arrays.equals(s1Freq, s2Freq)) {
            return true;
        }
        s2Freq[s2.charAt(i) - 'a']--;
        s2Freq[s2.charAt(i + n) - 'a']++;
    }
    return Arrays.equals(s1Freq, s2Freq);
    }
}