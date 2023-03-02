class Solution {
   public int compress(char[] chars) {
    if (chars == null || chars.length == 0) {
        return 0;
    }

    int n = chars.length;
    int count = 1;
    int writeIdx = 0;

    for (int i = 1; i <= n; i++) {
        if (i < n && chars[i] == chars[i-1]) {
            count++;
        } else {
            chars[writeIdx++] = chars[i-1];
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[writeIdx++] = c;
                }
            }
            count = 1;
        }
    }

    return writeIdx;
}

}