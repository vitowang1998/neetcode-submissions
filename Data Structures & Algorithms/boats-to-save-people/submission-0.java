class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0, right = people.length - 1;
        int boatCount = 0;

        while (left <= right) {
            int remain = limit - people[right];
            right--;
            boatCount++;

            if (left <= right && remain >= people[left]) {
                left++;
            }
        }

        return boatCount;
    }
}