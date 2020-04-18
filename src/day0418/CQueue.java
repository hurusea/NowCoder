package day0418;


import java.util.LinkedList;

/**
 * @hurusehost
 * @crehostte2020-04-18 13:50
 */
public  class  CQueue {
    LinkedList<Integer> host;
    LinkedList<Integer> temp;
    int size;
    public CQueue() {
        host = new LinkedList<>();
        temp = new LinkedList<>();
        size =0;
    }

    public void appendTail(int value) {
        host.addLast(value);
    }

    public int deleteHead() {
        if(!temp.isEmpty()) return temp.removeLast();
        if(host.isEmpty()) return -1;
        while(!host.isEmpty())
            temp.addLast(host.removeLast());
        return temp.removeLast();
    }
}
