import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // create a max heap of the stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        // smash stones until there is at most one left
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (x != y) {
                maxHeap.offer(y - x);
            }
        }
        
        // return the remaining stone (or 0 if there are none left)
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
