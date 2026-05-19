class Deque {

    Node front;
    Node back;
    int size;

    public Deque() {
        front = new Node(-1);
        back = new Node(-1);

        back.prev = front;
        front.next = back;
        
        size = 0;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void append(int value) {
        Node tail = new Node(value);
        tail.prev = back.prev;
        tail.next = back;

        tail.prev.next = tail;

        back.prev = tail;

        size++;
    }

    public void appendleft(int value) {
        Node head = new Node(value);
        head.prev = front;
        head.next = front.next;

        front.next = head;

        head.next.prev = head;

        size++;
    }

    public int pop() {
        if(size == 0){
            return -1;
        }

        int out = back.prev.val;

        Node one = back.prev.prev;
        one.next = back;

        back.prev = one;

        size--;

        return out;
    }

    public int popleft() {
        if(size == 0){
            return -1;
        }

        int out = front.next.val;

        Node one = front.next.next;
        one.prev = front;

        front.next = one;
        size--;
        return out;
    }
}

class Node {
    int val;
    Node next;
    Node prev;

    public Node(){
        this.val = -1;
        this.next = null;
        this.prev = null;
    }

    public Node(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
