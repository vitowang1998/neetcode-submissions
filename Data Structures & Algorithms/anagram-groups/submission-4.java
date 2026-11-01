class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        
        for (String s: strs) {
            char[] currentString = s.toCharArray();
            Arrays.sort(currentString);

            String sortedS = new String(currentString);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }

        return new ArrayList<>(res.values());
    }
}
