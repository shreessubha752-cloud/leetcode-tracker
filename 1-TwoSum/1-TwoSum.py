# Last updated: 09/07/2026, 10:09:56
class Solution:
    def twoSum(self, nums, target):
        seen = {}  # Dictionary to store number and its index
        for i, num in enumerate(nums):
            complement = target - num
            if complement in seen:
                return [seen[complement], i]
            seen[num] = i

# Example usage
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    nums1 = [2, 7, 11, 15]
    target1 = 9
    print(solution.twoSum(nums1, target1))  # Output: [0, 1]

    # Test case 2
    nums2 = [3, 2, 4]
    target2 = 6
    print(solution.twoSum(nums2, target2))  # Output: [1, 2]

    # Test case 3
    nums3 = [3, 3]
    target3 = 6
    print(solution.twoSum(nums3, target3))  # Output: [0, 1]