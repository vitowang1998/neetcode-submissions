class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) right--;
        int ans = right;

        for (int left = 0; left < right; left++) {
            if (left > 0 && arr[left - 1] > arr[left]) break;
            // left是non-decresing order中的一部分
            while (right < n && arr[left] > arr[right]) right++;
            ans = Math.min(ans, right - left - 1);
        }

        return ans;
    }
}
