class Solution {
   public List<String> letterCasePermutation(String s) {
    List<String> result = new ArrayList<>();
    letterCasePermutationHelper(s.toCharArray(), 0, result);
    return result;
}

private void letterCasePermutationHelper(char[] chars, int idx, List<String> result) {
    if (idx == chars.length) {
        result.add(new String(chars));
        return;
    }

    char c = chars[idx];
    if (Character.isLetter(c)) {
        chars[idx] = Character.toLowerCase(c);
        letterCasePermutationHelper(chars, idx+1, result);
        chars[idx] = Character.toUpperCase(c);
        letterCasePermutationHelper(chars, idx+1, result);
    } else {
        letterCasePermutationHelper(chars, idx+1, result);
    }
}

}