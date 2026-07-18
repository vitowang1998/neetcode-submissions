class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        for s in strs:
            res += s
            res += "好"
        return res

    def decode(self, s: str) -> List[str]:
        res = []
        cur = ""
        for c in s:
            if (c != "好"):
                cur += c
            else:
                res.append(cur)
                cur = ""
        return res