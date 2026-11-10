class Solution {
    // get # of pairs that nums[i] + nums[j] <= upper
    private long countPairs(int[] nums, long upper) {
        long count = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if ((long) nums[left] + nums[right] <= upper) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        // overflow
        Arrays.sort(nums);
        
        return countPairs(nums, upper) - countPairs(nums, lower - 1);
    }
}

