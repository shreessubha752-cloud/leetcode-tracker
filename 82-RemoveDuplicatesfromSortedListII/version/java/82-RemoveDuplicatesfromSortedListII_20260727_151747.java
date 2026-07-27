// Last updated: 27/07/2026, 15:17:47
1class Solution {
2    public ListNode deleteDuplicates(ListNode head) {
3        if (head == null) return null;
4
5        ListNode dummy = new ListNode(0);
6        dummy.next = head;
7        ListNode prev = dummy;
8
9        while (head != null) {
10            if (head.next != null && head.val == head.next.val) {
11                // Skip all nodes with this duplicate value
12                while (head.next != null && head.val == head.next.val) {
13                    head = head.next;
14                }
15                prev.next = head.next; // remove duplicates
16            } else {
17                prev = prev.next; // move prev forward
18            }
19            head = head.next; // move head forward
20        }
21
22        return dummy.next;
23    }
24}
25