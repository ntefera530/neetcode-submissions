class DynamicArray {
    int[] arr;
    int capacity;
    int length;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.arr = new int[this.capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if(length == capacity){
            resize();
        }
        arr[length] = n;
        length++;
    }

    public int popback() {
        if(length > 0){
            length--;
        }
        return arr[length];
    }

    private void resize() {
        int[] newArr = new int[capacity * 2];
        this.capacity *= 2;
        
        for(int i = 0; i < length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
