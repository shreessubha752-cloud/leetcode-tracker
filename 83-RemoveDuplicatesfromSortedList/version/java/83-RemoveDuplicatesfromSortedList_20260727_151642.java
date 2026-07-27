// Last updated: 27/07/2026, 15:16:42
1class Solution {
2    public ListNode deleteDuplicates(ListNode head) {
3        ListNode curr = head;
4        while (curr != null && curr.next != null) {
5            if (curr.val == curr.next.val) {
6                curr.next = curr.next.next; // skip duplicate
7            } else {
8                curr = curr.next; // move forward
9            }
10        }
11        return head;
12    }
13}
14