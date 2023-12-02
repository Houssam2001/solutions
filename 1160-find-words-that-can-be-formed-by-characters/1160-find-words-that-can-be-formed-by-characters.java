class Solution {
    public int countCharacters(String[] words, String chars) {
          int totalLength = 0;

        Map<Character, Integer> charsCount = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charsCount.put(c, charsCount.getOrDefault(c, 0) + 1);
        }

        for (String word : words) {
            Map<Character, Integer> wordCount = new HashMap<>();

            for (char c : word.toCharArray()) {
                wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
            }

            boolean canFormWord = true;
            for (Map.Entry<Character, Integer> entry : wordCount.entrySet()) {
                char c = entry.getKey();
                int count = entry.getValue();
                if (count > charsCount.getOrDefault(c, 0)) {
                    canFormWord = false;
                    break;
                }
            }

            if (canFormWord) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }
}