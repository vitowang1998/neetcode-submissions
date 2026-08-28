class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        longest = 0

        # all put into set
        numSet = set(nums)
        # for each item in set
        for n in nums:
            # check if it's the start of a sequence
            if (n - 1) not in numSet:
                currentLength = 0
                while (n + currentLength) in numSet:
                # while(item += 1) in set
                    currentLength += 1
                    longest = max(currentLength, longest)
                    # currentLength += 1
                    # longest = max(currentLength, longest)
        
        return longest