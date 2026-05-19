class LinkedList {

    Node dummy;
    int size;

    public LinkedList() {
        dummy = new Node();
        this.size = 0;
    }

    public int get(int index) {
        if(index + 1 > size){
            return -1;
        }

        Node cur = dummy.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }

        return cur.val;
    }

    public void insertHead(int val) {
        Node head = new Node(val);
        head.next = dummy.next;
        dummy.next = head;
        size++;
    }

    public void insertTail(int val) {
        Node prev = dummy;
        Node cur = dummy.next;

        while(cur != null){
            prev = cur;
            cur = cur.next;
        }

        Node tail = new Node(val);
        prev.next = tail;
        size++;
    }

    public boolean remove(int index) {
        if(index + 1 > size){
            return false;
        }
        Node prev = dummy;
        Node cur = dummy.next;

        for(int i = 0; i < index; i++){
            prev = cur;
            cur = cur.next;
        }

        prev.next = cur.next;
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> out = new ArrayList();

        Node cur = dummy.next;

        while(cur != null){
            out.add(cur.val);
            cur = cur.next;
        }

        return out;
    }
}

class Node {
    int val;
    Node next;

    public Node(){
        this.val = 0;
        this.next = null;
    }

    public Node(int val){
        this.val = val;
        this.next = null;
    }

}
