class Solution {
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public void sortColors(int[] nums) {
    int i = 0, left = 0, right = nums.length - 1;
    while (i <= right) {
      if (nums[i] == 0) {
        swap(nums, i, left);
        left++;
        i++;
      } else if (nums[i] == 1) {
        i++;
      } else {
        swap(nums, i, right);
        right--;
      }
    }
  }
}