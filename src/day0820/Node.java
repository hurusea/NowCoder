package day0820;

/**
 * @hurusea
 * @create2020-08-20 15:02
 */
public class Node<K, V> {
    public K key;

    public V value;

    public Node<K, V> next;

    public Node(K key, V value, Node<K, V> next) {
        super();
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}
