class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # dict stores [num, index of num]
        my_dict = {}
        for i, num in enumerate(nums):
            if my_dict.get(target - num) is not None:
                return [my_dict[target - num], i]
            else:
                my_dict[num] = i
