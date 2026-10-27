class Solution {
    private int calcDaysToLoad(int[] weights, int c) {
        int days = 1;
        int availableLoad = c;
        for (int weight: weights) {
            if (weight <= availableLoad) {
                availableLoad -= weight;
            } else {
                days++;
                availableLoad = c - weight;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        int res = r;
        while (l <= r) {
            int c = l + (r - l) / 2;
            if (calcDaysToLoad(weights, c) <= days) {
                res = Math.min(res, c);
                r = c - 1;
            } else {
                l = c + 1;
            }
        }

        return res;
    }
}