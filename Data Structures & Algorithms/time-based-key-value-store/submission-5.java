class TimeMap {
    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

    private Map<String, List<Pair<Integer, String>>> data;

    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        data.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String res = "";
        if (data.containsKey(key)) {
            List<Pair<Integer, String>> timestampAndValues = data.get(key);
            int l = 0, r = timestampAndValues.size() - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (timestampAndValues.get(mid).getKey() <= timestamp) {
                    res = timestampAndValues.get(mid).getValue();
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return res;
    }
}
