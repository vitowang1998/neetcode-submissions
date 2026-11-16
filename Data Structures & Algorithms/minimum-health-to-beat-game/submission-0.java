class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long totalDmg = 0;
        long maxDmg = 0;
        for (int attack: damage) {
            totalDmg += attack;
            maxDmg = Math.max(attack, maxDmg);
        }
        if (maxDmg <= armor) {
            totalDmg -= maxDmg;
        } else {
            totalDmg -= armor;
        }

        return totalDmg + 1;
    }
}
