class Solution {
    public int[] smallestRange(int[][] nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // number, list index, element index

        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i][0], i, 0});
            currentMax = Math.max(currentMax, nums[i][0]);
        }

        int bestMin = minHeap.peek()[0];
        int bestMax = currentMax;
        int currentMin = bestMin;

        while (true) {
            int[] currentSmallest =  minHeap.poll();
            currentMin = currentSmallest[0];
            int listIndex = currentSmallest[1];
            int elementIndex = currentSmallest[2];

            if (currentMax - currentMin < bestMax - bestMin || (currentMax - currentMin == bestMax - bestMin && currentMin < bestMin)) {
                bestMin = currentMin;
                bestMax = currentMax;
            }

            if (elementIndex == nums[listIndex].length - 1) {
                break;
            } else {
                int nextNumber = nums[listIndex][elementIndex + 1];
                currentMax = Math.max(currentMax, nextNumber);
                minHeap.offer(new int[]{nextNumber, listIndex, elementIndex + 1});
            }     
        }

        return new int[]{bestMin, bestMax};
    }
}
