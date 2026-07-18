// Last updated: 18/07/2026, 09:22:06
1class Solution {
2    public ListNode rotateRight(ListNode head, int k) {
3        if (head == null || head.next == null || k == 0) return head;
4        
5        // Step 1: Find length and tail
6        int length = 1;
7        ListNode tail = head;
8        while (tail.next != null) {
9            tail = tail.next;
10            length++;
11        }
12        
13        // Step 2: Normalize k
14        k = k % length;
15        if (k == 0) return head;
16        
17        // Step 3: Make it circular
18        tail.next = head;
19        
20        // Step 4: Find new tail (length - k steps from head)
21        int stepsToNewTail = length - k;
22        ListNode newTail = head;
23        for (int i = 1; i < stepsToNewTail; i++) {
24            newTail = newTail.next;
25        }
26        
27        // Step 5: Break the circle
28        ListNode newHead = newTail.next;
29        newTail.next = null;
30        
31        return newHead;
32    }
33}
34