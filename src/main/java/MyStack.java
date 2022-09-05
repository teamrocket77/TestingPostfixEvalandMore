import java.util.NoSuchElementException;

//Class:             Data Structures Section 03
//Term:              Spring: 2022
//Name:
//Program Number:    assignment3
//IDE:               Eclipse
//DATE:              02 25,2022
//JRE:               15.0.1%

class MyStack<E>{

    /*
     * exit
     * push, pop, peek
     * size
     * is empty
     * printstack*/

    public Node head = null;
    public Node tail = null;
    public int size;
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    /*
     * if "this" empty:
     * 	head = new Node
     * 	tail = head
     */
    public void push(E data){
        if(isEmpty()){
            head = new Node(data);
            tail = head;
            size++;
            return;
        }
        tail.link = new Node(data);
        tail = tail.link;
        size++;
        return;
    }
    public E pop() throws NoSuchElementException{
        if (size == 0) {
            throw new NoSuchElementException("There are no nodes in the list");
        }
        else if(size == 1){
            E e = head.data;
            head = null;
            size--;
            tail = null;
            return e;}
        Node currentNode, previousNode;
        boolean firstIterSentinel = false;
        currentNode = null;
        previousNode = null;
        Iterator it = iterator();
        while(it.hasNext()){
            if(firstIterSentinel){
                previousNode = currentNode;
            }
            currentNode = it.next;
            it.next();
            firstIterSentinel = true;
        }
        previousNode.link = null;
        tail = previousNode;
        size--;
        return currentNode.data;
    }
    public E peek() throws NoSuchElementException{
        if(isEmpty()){throw new NoSuchElementException("There no elements to peek at inside of the stack. Empty");}
        return tail.data;
    }

    public int size() {
        return this.size;
    }

    class Node{
        public E data;
        public Node link;
        public Node(E d){
            data = d;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
    public Iterator iterator(){
        return new Iterator();
    }
    class Iterator{
        Node next = head;
        public E next(){
            E e = next.data;
            next = next.link;
            return e;
        }
        public boolean hasNext(){
            if (next == null){
                return false;
            }
            return true;
        }

    }
    @Override
    public String toString(){
        String string ="";
        Iterator it = iterator();
        while(it.hasNext()){
            string += it.next.toString() + "\n";
            it.next();
        }
        return string;
    }
}
