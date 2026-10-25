class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def numHoursToEatBananas(piles: List[int], k: int) -> int:
            hours = 0
            for p in piles:
                hours += math.ceil(float(p) / k)
            return hours

        l = 1
        r = max(piles)
        res = r

        while l <= r:
            k = (l + r) // 2
            if (numHoursToEatBananas(piles, k) > h):
                l = k + 1
            else:
                r = k - 1
                res = k
        
        return res

        