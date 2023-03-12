
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.offer(new int[]{lists[i].val, i});
                lists[i] = lists[i].next;
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!heap.isEmpty()) {
            int[] currNode = heap.poll();
            curr.next = new ListNode(currNode[0]);
            curr = curr.next;
            int idx = currNode[1];
            if (lists[idx] != null) {
                heap.offer(new int[]{lists[idx].val, idx});
                lists[idx] = lists[idx].next;
            }
        }
        
        return dummy.next;
    }
}