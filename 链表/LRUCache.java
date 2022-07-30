package ����;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * �����������յ����ݽṹ����ƺ�ʵ��һ��  LRU (�������ʹ��) ������� ��
 * ʵ�� ����.LRUCache �ࣺ
 *
 * ����.LRUCache(int capacity) ����������Ϊ���� capacity ��ʼ�� LRU ����
 * int get(int key) ����ؼ��� key �����ڻ����У��򷵻عؼ��ֵ�ֵ�����򷵻� -1 ��
 * void put(int key, int value) ����ؼ����Ѿ����ڣ�����������ֵ������ؼ��ֲ����ڣ��������顸�ؼ���-ֵ���������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣
 *  */




class LRUCache{

    /**
     * ֱ��ʹ��java�Դ����ݽṹLinkedHashMap
     * */

    static class LRUCache_1 extends LinkedHashMap <Integer,Integer> {
        private final int capacity;

        public LRUCache_1(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }


    /**
     * LinkedHashMap����ʵ�� ˫������+HashMap
     * ��˫�������ʵ���У�ʹ��һ��αͷ����dummy head����αβ����dummy tail����ǽ��ޣ�
     * ��������ӽڵ��ɾ���ڵ��ʱ��Ͳ���Ҫ������ڵĽڵ��Ƿ���ڡ�
     * */

    public class LRUCache_2{
        class DLinkedNode{
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            public DLinkedNode(){}
            public DLinkedNode(int key,int value ){
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer,DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head,tail;

        public LRUCache_2(int capacity){
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key){
            DLinkedNode node = cache.get(key);
            if(node == null){
                return -1;
            }

            // ��� key ���ڣ���ͨ����ϣ��λ�����Ƶ�ͷ��
            moveToHead(node);
            return node.value;
        }

        public void put(int key,int value){
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // ��� key �����ڣ�����һ���µĽڵ�
                DLinkedNode newNode = new DLinkedNode(key, value);
                // ��ӽ���ϣ��
                cache.put(key, newNode);
                // �����˫�������ͷ��
                addToHead(newNode);
                ++size;
                if (size > capacity) {
                    // �������������ɾ��˫�������β���ڵ�
                    DLinkedNode tail = removeTail();
                    // ɾ����ϣ���ж�Ӧ����
                    cache.remove(tail.key);
                    --size;
                }
            }
            else {
                // ��� key ���ڣ���ͨ����ϣ��λ�����޸� value�����Ƶ�ͷ��
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(DLinkedNode node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }

}

