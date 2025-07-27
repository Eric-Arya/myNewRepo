package deque;

public class LinkedListDeque<T> {
    public class Node{
        public Node prev;
        public T item;
        public Node next;
        public Node(Node p, T i, Node n){
            prev = p; item = i; next = n;
        }
        public T get(int index){
            if (index == 0){
                return item;
            }
            else{
                return this.next.get(index-1);
            }
        }
    }
    private int size;
    private Node sentinel;
    public LinkedListDeque(){
        size = 0;
        Node A = new Node(null,null,null);
        A.next = A;
        A.prev = A;
        sentinel = A;
    }
    public void printDeque(){
        int t = size;
        Node p = sentinel.next;
        while(t > 0){
            System.out.println(p.item);
            t--;
        }
        System.out.println();
    }

    public void addFirst(T item){
        size += 1;

        sentinel.prev.prev =  sentinel.next = new Node(sentinel,item,sentinel.next);

    }
    public void addLast(T item){
        size += 1;
        //Node temp = sentinel.prev;

        sentinel.prev.next = sentinel.prev = new Node(sentinel.prev,item,sentinel);

    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public T removeFirst(){
        if (size == 0){return null;}
        else{
            size-=1;
            T temp = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            return temp;
        }
    }
    public T removeLast(){
        if (size == 0){return null;}
        else{
            size-=1;
            T temp = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            return temp;
        }
    }
    public T get(int index){
        if (index < 0){
            return null;
        }
        else if (index >= size){
            return null;
        }
        else{
            Node temp = sentinel;
            for (int i = 0; i <= index;i++){
                temp = temp.next;
            }
            return temp.item;
        }
    }

    public T getRecursive(int index) {
        return sentinel.next.get(index);
    }

//    public static void main(String[] args){
//        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
//        lst.addLast(1);
//        lst.addFirst(2);
//        System.out.println(lst.getRecursive(1));
//    }
}
