public class MyHashMap<K, V> {
    private final int capacity;
    private final Node<K, V>[] buckets;

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node[capacity];
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> node = buckets[index];

        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = buckets[index];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }

        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> node = buckets[index];
        Node<K, V> prev = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            buckets[i] = null;
        }
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < capacity; i++) {
            Node<K, V> node = buckets[i];
            while (node != null) {
                count++;
                node = node.next;
            }
        }
        return count;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
