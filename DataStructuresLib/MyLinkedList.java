package DataStructuresLib;
public class MyLinkedList<T> extends DataStructuresLib.MyList<T> {

    private class Node{
        /*
         * A private class representing a node in the linked list
         */
        Node next, prev;
        T value;
        Node(T value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }
        void setNext(Node next){
            this.next = next;
            // add double link
            if(this.next != null)
                this.next.prev = this;
        }
        Node getNext(){
            return this.next;
        }

        void setPrev(Node prev){
            this.prev = prev;
            // add double link
            if(this.prev != null)
                this.prev.next = this;
        }

        Node getPrev(){
            return this.prev;
        }

        T getValue(){
            return this.value;
        }
        void setValue(T newValue){
            this.value = newValue;
        }
    }

    Node head;
    Node tail;
    int length;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    void add(T value) {
        if (this.tail == null){
            this.head = this.tail = new Node(value);
        }
        else{
            Node newNode = new Node(value);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.length++;
    }

    private Node getNode(int nodeNumber){
        Node n = this.head;
        for(int i = 0; i < nodeNumber; i++){
            n = n.getNext();
        }
        return n;
    }

    void add(T value, int position) {
        Node newNode = new Node(value);
        Node nPlusOne = null;
        if(position > 0 && position < this.length){
            Node n = getNode(position-1);
            nPlusOne = n.getNext();
            n.setNext(newNode);
        } else if(position==0){
            nPlusOne = this.head;
            this.head = newNode; 
        } else{
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        if(nPlusOne == null){
            this.tail = newNode;
        }else{
            newNode.setNext(nPlusOne);
        }
        this.length++;
        
    }

    T remove(int position) {
        if(position < 0 || position >=this.length) throw new ArrayIndexOutOfBoundsException();
        Node removing = null;
        if(position > 0 && position < this.length){
            Node before = getNode(position-1);
            removing = before.getNext();
            Node after = removing.getNext();
            before.setNext(after);
        } else if(position == 0){
            removing = this.head;
            this.head = this.head.getNext();
        } else{
            Node before = this.getNode(position - 1);
            removing = this.tail;
            this.tail = before;
            before.setNext(null);
        }
        this.length--;
        return removing.getValue();
    }

    T remove() {
        Node removing = null;
        removing = this.tail;
        this.tail = this.tail.prev;
        this.tail.setNext(null);
        this.length--;

        return removing.getValue();
    }

    T get(int position) {
        if(position < 0 || position >=this.length) throw new ArrayIndexOutOfBoundsException();
        T retval = null;
        if(position == 0){
            retval = this.head.value;
        } else if(position == this.length - 1){
            retval = this.tail.value;
        } else{
            retval = getNode(position).getValue();
        }
        return retval;
    }

    T set(int position, T newValue) {
        if(position < 0 || position >=this.length) throw new ArrayIndexOutOfBoundsException();
        T retval = null;
        if(position == 0){
            retval = this.head.value;
            this.head.value = newValue;
        } else if(position == this.length - 1){
            retval = this.tail.value;
            this.tail.value = newValue;
        } else{
            Node n = getNode(position);
            retval = n.getValue();
            n.setValue(newValue);
        }
        return retval;
    }

    int size() {
        return this.length;
    }

    boolean contains(T value) {
        Node current = this.head;
        while(current != null){
            if(current.getValue() == value) return true;
            current = current.getNext();
        }
        return false;
    }

    boolean isEmpty() {
        return this.length == 0;
    }

    void clear() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public MyArrayList<T> toArrayList(){
/*
this takes O(n) time as it iterates through the linked list and copies into the array.
 */
        MyArrayList result = new MyArrayList(this.length);

        Node track = this.head;

        for (int i = 0; i < this.length; i++) {
            result.add(track.value);
            track = track.next;
        }

        return result;
    }

}
