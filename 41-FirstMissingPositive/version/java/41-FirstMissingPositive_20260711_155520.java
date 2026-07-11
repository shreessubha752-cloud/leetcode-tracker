// Last updated: 11/07/2026, 15:55:20
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n = nums.length;
4
5        for (int i = 0; i < n; i++) {
6            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
7                int temp = nums[i];
8                nums[i] = nums[temp - 1];
9                nums[temp - 1] = temp;
10            }
11        }
12
13        for (int i = 0; i < n; i++) {
14            if (nums[i] != i + 1) {
15                return i + 1;
16            }
17        }
18
19        return n + 1;
20    }
21}
22