# Last updated: 09/07/2026, 10:09:26
class Solution:
    def threeSumClosest(self, nums, target):
        nums.sort()
        closest = float('inf')
        n = len(nums)

        for i in range(n - 2):
            left, right = i + 1, n - 1

            while left < right:
                current_sum = nums[i] + nums[left] + nums[right]

                # Update closest if this sum is nearer to target
                if abs(current_sum - target) < abs(closest - target):
                    closest = current_sum

                # Move pointers based on comparison
                if current_sum < target:
                    left += 1
                elif current_sum > target:
                    right -= 1
                else:
                    return current_sum  # Exact match

        return closest