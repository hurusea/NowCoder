package day0820;

/**
 * @hurusea
 * @create2020-08-20 15:02
 */
public interface BXCMap<K, V> {
    public V put(K k, V v);

    public V get(K k);

    public int size();
}
