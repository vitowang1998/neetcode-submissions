class Solution {
    private long numHoursToEatBananas(int[] piles, int k) {
        long hours = 0;
        for (int bananas: piles)
            hours += Math.ceilDiv(bananas, k);
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int k = l + (r - l) / 2;
            if (numHoursToEatBananas(piles, k) > h) {
                l = k + 1;
            } else {
                res = Math.min(k, res);
                r = k - 1;
            }
        }

        return res;
    }
}
