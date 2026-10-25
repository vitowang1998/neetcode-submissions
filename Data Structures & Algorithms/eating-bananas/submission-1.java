class Solution {
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num: nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private long numHoursToEatBananas(int[] piles, int k) {
        long hours = 0;
        for (int bananas: piles) {
            hours += Math.ceilDiv(bananas, k);
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = getMax(piles);
        int k = r;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (numHoursToEatBananas(piles, m) > h) {
                l = m + 1;
            } else {
                r = m - 1;
                k = Math.min(k, m);
            }
        }

        return k;
    }
}
