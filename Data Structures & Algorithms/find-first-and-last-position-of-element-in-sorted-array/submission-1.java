class Solution {
    private int binarySearch(int[] nums, int target, boolean searchLeft) {
        int l = 0, r = nums.length - 1;
        int boundry = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                if (searchLeft) {
                    boundry = m;
                    r = m - 1;
                } else {
                    boundry = m;
                    l = m + 1;
                }
            }
        }
        return boundry;
    }

    public int[] searchRange(int[] nums, int target) {
        int leftBoundry = binarySearch(nums, target, true);
        int rightBoundry = binarySearch(nums, target, false);

        return new int[] {leftBoundry, rightBoundry};
    }
}