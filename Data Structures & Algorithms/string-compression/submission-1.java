class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0, n = chars.length;

        while (i < n) {
            sb.append(chars[i]);
            int j = i + 1;
            while (j < n && chars[j] == chars[i]) j++;

            if (j - i > 1) sb.append(String.valueOf(j - i));
            i = j;
        }
        
        for (i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}