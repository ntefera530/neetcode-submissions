class HashTable {

    int size;
    int capacity;
    Node[] table;

    public HashTable(int capacity) {
        this.table = new Node[capacity];
        this.size = 0;
        this.capacity = capacity;

        for(int i = 0; i < capacity; i++){
            this.table[i] = new Node(-1, -1);
        }

    }

    public void insert(int key, int value) {



        int modKey = key % capacity;

        Node cur = table[modKey].next;
        while(cur != null){
            if(cur.key == key){
                cur.val = value;
                return;
            }
            cur = cur.next;
        }

        Node newNode = new Node(key,value);
        Node dummy = table[modKey];

        newNode.next = dummy.next;
        dummy.next = newNode;

        size++;        
        
        double load = (double) size / (double) capacity;
        if(load >= 0.5){
            resize();
        }
    }

    public int get(int key) {
        int modKey = key % capacity;
        
        Node cur = table[modKey].next;
        while(cur != null){
            if(cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        }

        return -1;
    }

    public boolean remove(int key) {
        int modKey = key % capacity;
        
        Node prev = table[modKey];
        Node cur = prev.next;

        while(cur != null){
            if(cur.key == key){
                prev.next = cur.next;
                size--;
                return true;
            }

            prev = cur;
            cur = cur.next;
        }

        return false;

    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resize() {
        Node[] buffer = table;
        this.capacity = capacity * 2;
        this.size = 0;

        this.table = new Node[capacity];

        for(int i = 0; i < capacity; i++){
            table[i] = new Node(-1, -1);
        }
        for(Node head : buffer){
            Node cur = head.next;
            while(cur != null){
                insert(cur.key, cur.val);
                cur = cur.next;
            }
        }
    }
}


class Node {
    int key;
    int val;
    Node next;

    public Node(){
        this.key = -1;
        this.val = -1;
        this.next = null;
    }

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
    }
}
