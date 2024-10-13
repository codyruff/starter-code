public class LinkedQueue {

    private class Node<T>{
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


}
