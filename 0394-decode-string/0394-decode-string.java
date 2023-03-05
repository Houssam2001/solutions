class Solution {
   public String decodeString(String s) {
    Stack<Integer> countStack = new Stack<>();
    Stack<StringBuilder> stringStack = new Stack<>();
    StringBuilder currentString = new StringBuilder();
    int count = 0;
    
    for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) {
            count = count * 10 + (c - '0');
        } else if (c == '[') {
            countStack.push(count);
            stringStack.push(currentString);
            currentString = new StringBuilder();
            count = 0;
        } else if (c == ']') {
            StringBuilder previousString = stringStack.pop();
            int repeatCount = countStack.pop();
            for (int i = 0; i < repeatCount; i++) {
                previousString.append(currentString);
            }
            currentString = previousString;
        } else {
            currentString.append(c);
        }
    }
    
    return currentString.toString();
}

}