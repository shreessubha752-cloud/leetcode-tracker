// Last updated: 20/07/2026, 10:13:27
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        // Step 1: Find length and tail
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // Step 2: Normalize k
        k = k % length;
        if (k == 0) return head;
        
        // Step 3: Make it circular
        tail.next = head;
        
        // Step 4: Find new tail (length - k steps from head)
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        
        // Step 5: Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}
