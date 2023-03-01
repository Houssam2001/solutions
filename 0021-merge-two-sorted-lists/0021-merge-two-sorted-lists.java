

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy head node for the merged list
        ListNode dummyHead = new ListNode(0);
        
        // Create a pointer to keep track of the current node of the merged list
        ListNode current = dummyHead;
        
        // Traverse both lists until one becomes empty
        while (list1 != null && list2 != null) {
            // Compare the values of the current nodes of the two lists
            if (list1.val < list2.val) {
                // Add the smaller node to the merged list
                current.next = list1;
                // Move the pointer of the first list to the next node
                list1 = list1.next;
            } else {
                // Add the smaller node to the merged list
                current.next = list2;
                // Move the pointer of the second list to the next node
                list2 = list2.next;
            }
            // Move the pointer of the merged list to the next node
            current = current.next;
        }
        
        // Append the remaining nodes of the non-empty list to the end of the merged list
        current.next = (list1 != null) ? list1 : list2;
        
        // Return the head of the merged list
        return dummyHead.next;
    }
}

