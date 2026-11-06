class Solution {
    private boolean isAlphaNumerical(char c) {
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (!isAlphaNumerical(s.charAt(left)) && left < right) left++;
            while (!isAlphaNumerical(s.charAt(right)) && left < right) right--;

            if (Character.toLowerCase(s.charAt(left)) != (Character.toLowerCase(s.charAt(right))))return false;

            left++;
            right--;
        }

        return true;
    }
}
