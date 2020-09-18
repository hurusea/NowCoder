package month08.day0820;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;

    Node(K key, V value, Node<K, V> next) {
        super();
        this.key = key;
        this.value = value;
        this.next = next;
    }

    K getKey() {
        return this.key;
    }

    V getValue() {
        return this.value;
    }

    V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}

public class SelfMap<K, V> {
    //链表的数组
    Node<K, V>[] table = null;
    //存储数据个数
    int size;
    //负载因子
    private static float DEFAULT_LOAD_FACTOR = 0.75f;
    //初始大小
    private static int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    public V put(K key, V value) {
        if (table == null) {
            table = new Node[DEFAULT_INITIAL_CAPACITY];
        }
        //判断是否需要扩容
        if (size > (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY)) {
            resize();
        }
        //拿到下标的位置
        int index = getIndex(key, DEFAULT_INITIAL_CAPACITY);
        Node<K, V> node = table[index];
        //如果该位置没有，就新建对象存入
        if (node == null) {
            node = new Node<K, V>(key, value, null);
            size++;
        } else {
            //如果已经存在，则拿到链表中的每一个数据判断key是否相同
            Node<K, V> newNode = node;
            while (newNode != null) {
                if (newNode.getKey().equals(key) || newNode.getKey() == key) {
                    //key相同则覆盖
                    return newNode.setValue(value);
                } else {
                    if (newNode.next == null) {
                        //链表中没有当前key则加入
                        node = new Node<K, V>(key, value, node);
                        //计数加一
                        size++;
                    }
                }
                newNode = newNode.next;
            }
        }
        table[index] = node;
        return null;
    }

    public V get(K k) {
        Node<K, V> node = getNode(table[getIndex(k, DEFAULT_INITIAL_CAPACITY)], k);
        return node == null ? null : node.value;
    }

    private Node<K, V> getNode(Node<K, V> node, K k) {
        while (node != null) {
            if (node.getKey().equals(k)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private Node<K, V> remove(K key) {
        int hash = (key == null) ? 0 : hash(key);
        int i = getIndex(key, table.length);
        Node<K, V> prev = table[i]; //当前判断节点的上一个节点
        Node<K, V> e = prev; //当前判断节点
        while (e != null) {
            Node<K, V> next = e.next; //当前判断节点的下一个节点
            Object k;
            if (hash(e.key) == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k)))) { //找到key对应的节点
                size--;
                if (prev == e)
                    table[i] = next;
                else
                    prev.next = next;
                return e;
            }
            prev = e;
            e = next;
        }
        return e;
    }

    public int size() {
        return size;
    }

    private int getIndex(K key, int length) {
        return hash(key) & (length - 1);
    }

    private int hash(K key) {
        int h = 0;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >> 16);
    }

    private void resize() {
        //新建链式数组，大小为原来的两倍
        Node<K, V>[] newTable = new Node[DEFAULT_INITIAL_CAPACITY << 1];
        //遍历原来数值的每一个链表
        for (int i = 0; i < table.length; i++) {
            Node<K, V> oldNode = table[i];
            //那个链表中的每个Node
            while (oldNode != null) {
                table[i] = null;
                //拿到key
                K oldK = oldNode.key;
                //重新计算下标
                int index = getIndex(oldK, newTable.length);
                //因为需要遍历，要到oldNode的下一个Node
                Node<K, V> oldNext = oldNode.next;
                //如果newTable的index位置已有有链表了，就放在oldNode的下一个
                oldNode.next = newTable[index];
                //将数据再存到newTable的index位置
                newTable[index] = oldNode;
                //再指向下一个Node，一直循环，知道没有下一个节点为null时停止
                oldNode = oldNext;
            }
        }
        table = newTable;
        DEFAULT_INITIAL_CAPACITY = newTable.length;
    }

    public static void main(String[] args) {
        SelfMap<String, String> map = new SelfMap<>();
        map.put("name", "hello");
        System.out.println(map.get("name"));
        map.remove("name");
        if (map.get("name") == null) {
            System.out.println("删除成功");
        }

    }
}