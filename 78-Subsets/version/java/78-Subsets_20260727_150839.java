// Last updated: 27/07/2026, 15:08:39
1class Solution {
2    public boolean search(int[] nums, int target) {
3        int low = 0, high = nums.length - 1;
4        
5        while (low <= high) {
6            int mid = low + (high - low) / 2;
7            
8            if (nums[mid] == target) return true;
9            
10            // Handle duplicates
11            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
12                low++;
13                high--;
14            } 
15            else if (nums[low] <= nums[mid]) { // Left half sorted
16                if (nums[low] <= target && target < nums[mid]) {
17                    high = mid - 1;
18                } else {
19                    low = mid + 1;
20                }
21            } 
22            else { // Right half sorted
23                if (nums[mid] < target && target <= nums[high]) {
24                    low = mid + 1;
25                } else {
26                    high = mid - 1;
27                }
28            }
29        }
30        
31        return false;
32    }
33}
34