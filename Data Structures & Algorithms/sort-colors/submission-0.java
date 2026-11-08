class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for (int num: nums) count[num]++;
        
        for (int i = 0; i < count[0]; i++) nums[i] = 0;
        for (int i = count[0]; i < count[0] + count[1]; i++) nums[i] = 1;
        for (int i = count[0] + count[1]; i < count[0] + count[1] + count[2]; i++) nums[i] = 2;
    }
}