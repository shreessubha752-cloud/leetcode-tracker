// Last updated: 27/07/2026, 14:59:26
1class Solution {
2    public void sortColors(int[] nums) {
3        int low = 0, mid = 0, high = nums.length - 1;
4        
5        while (mid <= high) {
6            if (nums[mid] == 0) {
7                // Swap nums[low] and nums[mid]
8                int temp = nums[low];
9                nums[low] = nums[mid];
10                nums[mid] = temp;
11                low++;
12                mid++;
13            } else if (nums[mid] == 1) {
14                mid++;
15            } else { // nums[mid] == 2
16                // Swap nums[mid] and nums[high]
17                int temp = nums[mid];
18                nums[mid] = nums[high];
19                nums[high] = temp;
20                high--;
21            }
22        }
23    }
24}
25