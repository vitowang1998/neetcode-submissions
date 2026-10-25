class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int btm = matrix.length - 1;
        int m = matrix.length;
        int n = matrix[0].length;

        int row = top;
        while (top <= btm) {
            row = top + (btm - top) / 2;
            if (target > matrix[row][n - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                btm = row - 1;
            } else {
                break;
            }
        }
        if (top > btm) return false;

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l);
            if (target > matrix[row][mid]) {
                l = mid + 1;
            } else if (target < matrix[row][mid]) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
