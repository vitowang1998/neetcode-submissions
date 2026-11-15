class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0, idx = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length;
            int l = i, r = i;
            while (0 <= l && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    idx = l;
                }
                l--;
                r++;
            }

            // even length;
            l = i;
            r = i + 1;
            while (0 <= l && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    idx = l;
                }
                l--;
                r++;
            }
        }

        return s.substring(idx, idx + maxLen);
    }
}
