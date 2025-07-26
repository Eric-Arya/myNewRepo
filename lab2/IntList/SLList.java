package IntList;

public class SLList {

        public class IntNode {
            public int item;
            public IntNode next;
            public IntNode(int i, IntNode n) {
                item = i;
                next = n;
            }
        }

        private IntNode first;

        public SLList(int x) {
            first = new IntNode(x, null);
        }

        /** Adds an item to the front of the list. */
        public void addFirst(int x) {
            first = new IntNode(x, first);
        }

        /** Retrieves the front item from the list. */
        public int getFirst() {
            return first.item;
        }

        /** Adds an item to the end of the list. */
        public void addLast(int x) {
            IntNode head = first;
            while(head.next != null){
                head = head.next;
            }
            head.next = new IntNode(x,null);
        }

        /** Returns the number of items in the list using recursion. */
        public int size() {
            if (first.next != null) {
                SLList head = new SLList(first.next.item);
                head.first.next = first.next.next;
                return 1+head.size();
            }
            else{
                return 1;
            }
        }


}
