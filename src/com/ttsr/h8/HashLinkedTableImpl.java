package com.ttsr.h8;

public class HashLinkedTableImpl<K, V> implements HashTable<K,V>{

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;
        Item<K,V> next;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Item<K,V>[] data;
    private int size;

    public HashLinkedTableImpl(int initialCapacity) {
        data = new Item[initialCapacity];
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        Item<K,V> head = data[index];
        Item<K,V> item = new Item<>(key,value);
        if (head != null) {
            while (head != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                    size++;
                    return true;
                }
                head = head.next;
            }
            head = data[index];
            item.next = head;
        }
        data[index] = item;
        size++;
        return true;
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        Item<K,V> head = data[index];
        while (head!=null){
            if(head.key.equals(key)){
                return head.getValue();
            }
            head = head.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        Item<K,V> head = data[index];
        if (head == null) {
            return null;
        }
        if(head.key.equals(key))
            {
                V value = head.value;
                head=head.next;
                data[index] = head;
                size--;
                return value;
            }
        else {
            Item<K,V> previous = new Item<>(null,null);
            while (head != null){
                if(head.key.equals(key)){
                    previous.next = head.next;
                    size--;
                    return head.value;
                }
                previous = head;
                head = head.next;
            }
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            Item<K,V> head = data[i];
            System.out.print(i+" ");
            while (head!=null){
                System.out.printf("->[%s]",head);
                head = head.next;
            }
            System.out.println();
        }
        System.out.println("----------");
    }




}
