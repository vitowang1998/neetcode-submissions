class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        def orderNumsAndReturnInList(a: num, b: num) -> List[int]:
            if (a < b):
                return [a, b]
            else:
                return [b, a]
        # dict stores [num, index of num]
        my_dict = {}
        for i, num in enumerate(nums):
            if my_dict.get(target - num) is not None:
                return orderNumsAndReturnInList(i, my_dict[target - num])
            else:
                my_dict[num] = i
