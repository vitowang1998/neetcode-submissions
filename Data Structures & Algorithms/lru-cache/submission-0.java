private class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = right;
        this.right.prev = left;
    }

    public void insert(Node node) {
        Node previousLatest = this.right.prev;
        previousLatest.next = node;
        node.prev = previousLatest;
        node.next = this.right;
        this.right.prev = node;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node oldNode = cache.get(key);
            remove(oldNode);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        cache.put(key, newNode);
        if (cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
