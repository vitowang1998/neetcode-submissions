class Solution {
    public int[] smallestRange(int[][] nums) {
        int k = nums.length;

        // Each entry: {value, listIndex, elementIndex}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int currentMax = Integer.MIN_VALUE;

        // Add the first element from each list
        for (int i = 0; i < k; i++) {
            int value = nums[i][0];
            minHeap.offer(new int[]{value, i, 0});
            currentMax = Math.max(currentMax, value);
        }

        int bestLeft = minHeap.peek()[0];
        int bestRight = currentMax;

        while (true) {
            // Get the smallest selected element
            int[] smallest = minHeap.poll();

            int currentMin = smallest[0];
            int listIndex = smallest[1];
            int elementIndex = smallest[2];

            // Update the best range
            int currentWidth = currentMax - currentMin;
            int bestWidth = bestRight - bestLeft;

            if (currentWidth < bestWidth ||
                (currentWidth == bestWidth && currentMin < bestLeft)) {
                bestLeft = currentMin;
                bestRight = currentMax;
            }

            // Stop if this list has no more elements
            if (elementIndex + 1 == nums[listIndex].length) {
                break;
            }

            // Advance the list containing the minimum
            int nextIndex = elementIndex + 1;
            int nextValue = nums[listIndex][nextIndex];

            minHeap.offer(new int[]{nextValue, listIndex, nextIndex});

            currentMax = Math.max(currentMax, nextValue);
        }

        return new int[]{bestLeft, bestRight};
    }
}
