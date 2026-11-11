class Solution {
    public int maxFrequency(int[] nums, int k) {
        // 在大array里每个数字都是[1, 50], 要在大array里找一个连续的小array
        // 使得, 小array里每个数 + 一个我们选的数x, 使得大array里k的数量c最多, 找这个数量c
        int countK = 0;
        for (int num: nums) if (num == k) countK++;
        int res = countK;

        for (int num = 1; num <= 50; num++) {
            for (int i = 0; i < nums.length; i++) {
                int count = 0;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == num) count++;
                    if (nums[j] == k) count--;
                    res = Math.max(res, countK + count);
                }
            }
        }

        return res;
    }
}