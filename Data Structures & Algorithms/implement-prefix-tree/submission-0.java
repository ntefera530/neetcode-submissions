class PrefixTree {
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(cur.letters[i] == null){
                cur.letters[i] = new Node();
            }
            cur = cur.letters[i];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(cur.letters[i] == null){
                return false;
            }

            cur = cur.letters[i];
        }

        return cur.end;

    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char c : prefix.toCharArray()){
            int i = c - 'a';
            if(cur.letters[i] == null){
                return false;
            }

            cur = cur.letters[i];
        }

        return true;
    }
}

class Node {
    boolean end = false;
    Node[] letters = new Node[26];
}
