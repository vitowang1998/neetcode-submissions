class Solution {
    public int compress(char[] chars) {
        int n = chars.length, k = 0, i = 0;

        while (i < n) {
            chars[k] = chars[i];
            k++;
            int j = i + 1;
            while (j < n && chars[i] == chars[j]) j++;

            if (j - i > 1) {
                String cnt = String.valueOf(j - i);
                for (char c: cnt.toCharArray()) {
                    chars[k] = c;
                    k++;
                }
            }
            i = j;
        }

        return k;
    }
}