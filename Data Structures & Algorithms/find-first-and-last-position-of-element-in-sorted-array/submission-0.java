class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        int targetIndex = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                targetIndex = m;
                break;
            }
        }

        if (targetIndex == -1) {
            return new int[] {-1, -1};
        } else {
            int leftSearch = targetIndex, rightSearch = targetIndex;
            while (nums[leftSearch] == target) {
                if (leftSearch - 1 >= 0 && nums[leftSearch - 1] == target) leftSearch--;
                else break;
            }
            while (nums[rightSearch] == target) {
                if (rightSearch + 1 <= nums.length - 1 && nums[rightSearch + 1] == target) rightSearch++;
                else break;
            }
            return new int[] {leftSearch, rightSearch};
        }
    }
}