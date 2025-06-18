class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map; // {key, node}
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);   // remove from where it is in the list
        add(node);      // add it to the back of the list as it is the most recently used
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node oldNode = map.get(key);
            remove(oldNode);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        add(node);

        if(map.size() > capacity) {
            Node nodeToDelete = head.next;
            remove(nodeToDelete);
            map.remove(nodeToDelete.key);
        }
    }

    public void add(Node node) {
        Node end = tail.prev;
        end.next = node;
        node.prev = end;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */