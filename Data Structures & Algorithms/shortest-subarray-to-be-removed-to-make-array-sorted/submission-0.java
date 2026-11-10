class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) right--;
        int answer = right;

        for (int left = 0; left < right; left++) {
            if (left > 0 && arr[left - 1] > arr[left]) break;
            // 此时的left必定还是一个还在non-decresing order中的left
            while (right < n && arr[left] > arr[right]) right++;
            answer = Math.min(answer, right - left - 1);
        }

        return answer;
    }
}
