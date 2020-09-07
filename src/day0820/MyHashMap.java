package day0820;

import java.util.ArrayList;
import java.util.List;

/**
 * @hurusea
 * @create2020-09-07 10:46
 */
public class MyHashMap<K, V> {
    //内部的属性
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;//默认大小
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int capacity;
    private float load_factor = 0.75f;
    private int entryUseSize;//已经使用的entry的数量
    private Entry<K, V>[] table = null;//entry类型的数组

    //构造函数
    private MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    private MyHashMap(int initial_capacity, float load_factor) {
        this.capacity = initial_capacity;
        this.load_factor = load_factor;
        table = new Entry[this.capacity];
    }

    class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        Entry(K k, V v, Entry<K, V> next) {
            this.key = k;
            this.value = v;
            this.next = next;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }
    }

    public V put(K key, V value) {
        V oldNum = null;//需要返回的旧的数

        if (entryUseSize >= capacity * load_factor)//需要扩容
            resize(2 * capacity);//扩容以及rehash
        int index = hash(key) & (capacity - 1);//利用hash函数再散列一次
        //如果是空直接放进去
        if (table[index] == null) {
            table[index] = new Entry<>(key, value, null);
            ++entryUseSize;
        } else {//需要遍历链表
            Entry<K, V> entry = table[index];
            Entry<K, V> e = entry;
            while (e != null) {
                if (e.getKey() == key || key.equals(e.getKey())) {
                    oldNum = e.value;
                    e.value = value;
                    return oldNum;
                }
                e = e.next;
            }
            //如果没有，使用头插法
            table[index] = new Entry<K, V>(key, value, entry);
            ++entryUseSize;
        }
        return oldNum;
    }

    public V get(K key) {
        int index = hash(key) & (capacity - 1);
        if (table[index] == null)
            return null;
        else {
            Entry<K, V> entry = table[index];
            do {
                if (key == entry.getKey() || key.equals(entry.getKey()))
                    return entry.getValue();
                entry = entry.next;
            } while (entry != null);
        }
        return null;
    }

    //根据hashcode来计算散列值
    private int hash(K key) {
        int h = 0;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >> 16);
    }

    //重新划分数组大小，然后把原来的里面的元素都放入新数组,参数newSize表示新的容量
    private void resize(int newSize) {
        Entry<K, V>[] newTable = new Entry[newSize];
        capacity = newSize;
        entryUseSize = 0;
        rehash(newTable);
    }

    //把原来的数全放到新的输入数组里面
    private void rehash(Entry<K, V>[] newTable) {
        List<Entry<K, V>> list = new ArrayList<Entry<K, V>>();
        for (Entry<K, V> entry : table)//遍历数组里面的每个元素
        {
            if (entry != null) {
                do {//遍历链表里面的每个元素
                    list.add(entry);
                    entry = entry.next;

                } while (entry != null);
            }
        }
        if (newTable.length > 0) {
            table = newTable;//指向新的数组
        }
        for (Entry<K, V> entry : list) {
            //调用put函数，把刚才放入list里面的数据放到新的table里
            put(entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, String> hash = new MyHashMap<String, String>();
        for (int i = 0; i < 100; i++) {
            hash.put("test" + i, "hello" + i);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(hash.get("test" + i));
        }
    }
}
