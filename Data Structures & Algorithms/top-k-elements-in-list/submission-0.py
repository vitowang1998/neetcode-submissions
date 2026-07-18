class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequency = defaultdict(int) # (num -> frequency of num)
        for num in nums:
            frequency[num] += 1
        updated = sorted(frequency.items(), key=lambda item: item[1], reverse=True)
        print(updated)
        res = []
        for i in range(k):
            res.append(updated[i][0])
        return res