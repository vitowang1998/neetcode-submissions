class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int l = 0, total = 0, res = 0;

        for (int r = 0; r < fruits.length; r++) {
            count.put(fruits[r], count.getOrDefault(fruits[r], 0) + 1);
            total++;

            while (count.size() > 2) {
                int leftFruitType = fruits[l];
                count.put(leftFruitType, count.get(leftFruitType) - 1);
                total--;

                if (count.get(leftFruitType) == 0) {
                    count.remove(leftFruitType);
                }
                l++;
            }

            res = Math.max(total, res);
        }

        return res;
    }
}