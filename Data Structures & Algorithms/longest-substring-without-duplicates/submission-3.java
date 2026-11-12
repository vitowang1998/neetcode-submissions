class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) >= l) {
                l = map.get(s.charAt(r)) + 1;
            }
            map.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
