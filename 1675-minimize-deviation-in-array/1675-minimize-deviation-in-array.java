import java.util.PriorityQueue;

class Solution {
   public int minimumDeviation(int[] nums) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int num : nums) {
        if (num % 2 == 1) {
            set.add(num * 2);
        } else {
            set.add(num);
        }
    }
    int minDeviation = Integer.MAX_VALUE;
    while (true) {
        int max = set.last();
        int min = set.first();
        minDeviation = Math.min(minDeviation, max - min);
        if (max % 2 == 1) {
            break;
        }
        set.remove(max);
        set.add(max / 2);
    }
    return minDeviation;
}

}
