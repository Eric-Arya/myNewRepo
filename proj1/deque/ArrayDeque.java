package deque;

public class ArrayDeque<T> {
    int size, first, last, used;
    T[] items;
    public ArrayDeque(){
        items = (T[]) new Object[0];
        size = 0;
        first = last = -1;
    }
    public boolean isEmpty(){return size == 0;}
    public int size(){return size;}
    public void resize(boolean up){
        if (up)
        {size *= 2;}
        else
        {size /= 2;}
        T[] items2 = (T[]) new Object[size];
        int first0 = first;
        first = size/2-used/2;
        last = first+used-1;
        System.arraycopy(items,first0,items2,first,used);
        items = items2;
    }


    public void addFirst(T item){

        if (size == 0){
            size = 8;
            first = last = 4;
            used += 1;
            items = (T[]) new Object[8];
            items[4] = item;
            return;
        }



        if (first - 1 < 0){
            resize(true);
            addFirst(item);
        }

        else{
            first -= 1;
            used += 1;
            items[first] = item;
        }
    }
    public void addLast(T item){
        if (size == 0){
            size = 8;
            first = last = 4;
            used += 1;
            items = (T[]) new Object[8];
            items[4] = item;
            return;
        }



        if (last + 1 >= size){
            resize(true);
            addLast(item);
        }

        else{
            last += 1;
            items[last] = item;
            used += 1;
        }
    }
    public T get(int index){
        return items[first+index];
    }
    public T removeFirst(){
        if (size >= 16){
            if ((double)(used-1)/(double)size < 0.25){
                resize(false);
            }
            removeFirst();
        }
        T removed = items[first];
        first += 1;
        used -= 1;
        return removed;
    }
    public T removeLast(){
        if (size >= 16){
            if ((double)(used-1)/(double)size < 0.25){
                resize(false);
            }
            removeLast();
        }
        T removed = items[last];
        last -= 1;
        used -= 1;
        return removed;
    }
    public void printDeque(){
        for (T i: items){
            System.out.println(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        a.addLast(2);
        for (int i = 3; i <= 10;i++){
            a.addLast(3*i);
            a.addLast(3*i+1);
            a.addLast(3*i+2);
        }
        for (int i = 3;i <= 10;i++){
            a.removeLast();a.removeLast();a.removeLast();
        }
    }
}

