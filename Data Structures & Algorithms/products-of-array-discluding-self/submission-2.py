class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [0] * n
        prefix = [1] * n # prefix[i] = the product of all before nums[i]
        postfix = [1] * n # postfix[i] = the product of all after nums[i]
        for i in range(1, n):
            prefix[i] = prefix[i - 1] * nums[i - 1]
        for i in range(n - 2, -1, -1):
            postfix[i] = postfix[i + 1] * nums[i + 1]
        for i in range(n):
            res[i] = prefix[i] * postfix[i]
        return res