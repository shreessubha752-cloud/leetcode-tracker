// Last updated: 27/07/2026, 15:07:17
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        int i = 0;
4        for (int num : nums) {
5            if (i < 2 || num > nums[i - 2]) {
6                nums[i] = num;
7                i++;
8            }
9        }
10        return i;
11    }
12}
13