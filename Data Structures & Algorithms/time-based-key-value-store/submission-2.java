class TimeMap {
    private Map<String, Map<Integer, String>> data;

    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        data.computeIfAbsent(key, k -> new HashMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        String res = "";
        Map<Integer, String> valueAndTimestamp = data.get(key);
        int curMaxTimestamp = -1;
        if (data.containsKey(key)) {
            for (Map.Entry<Integer, String> entry : valueAndTimestamp.entrySet()) {
                int curTimestamp = entry.getKey();
                if (curMaxTimestamp < curTimestamp && curTimestamp <= timestamp) {
                    res = entry.getValue();
                    curMaxTimestamp = curTimestamp;
                }
            }
        }
        return res;
    }
}
