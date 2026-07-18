class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # dict stores [num, index of num]
        my_dict = {}
        for i, num in enumerate(nums):
            target_index = my_dict.get(target - num)
            if target_index is not None:
                return [target_index, i]
            else:
                my_dict[num] = i