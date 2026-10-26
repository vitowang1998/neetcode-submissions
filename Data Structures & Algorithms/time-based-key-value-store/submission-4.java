class TimeMap {
    private Map<String, TreeMap<Integer, String>> data;

    public TimeMap() {
        data = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        data.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if (data.containsKey(key)) {
            Map.Entry<Integer, String> entry = data.get(key).floorEntry(timestamp);
            if (entry != null) res = entry.getValue();
        }
        return res;
    }
}
