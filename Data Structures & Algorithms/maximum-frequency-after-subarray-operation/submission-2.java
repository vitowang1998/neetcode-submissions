class Solution {
    public int maxFrequency(int[] nums, int k) {
        int cntK = 0;
        for (int num: nums) if (num == k) cntK++;
        int res = cntK;

        for (int i = 1; i <= 50; i++) {
            int cnt = 0;
            for (int num: nums) {
                if (num == i) cnt++;
                if (num == k) cnt--;
                cnt = Math.max(cnt, 0);
                res = Math.max(res, cntK + cnt);
            }
        }

        return res;
    }
}