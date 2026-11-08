class Solution {
    public int compress(char[] chars) {
        int i = 0, k = 0, n = chars.length;

        while (i < n) {
            chars[k] = chars[i];
            k++;

            int j = i + 1;
            while (j < n && chars[j] == chars[i]) j++;

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