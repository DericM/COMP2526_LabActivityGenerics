package ca.bcit.comp2526.labs.generics;

/**
 * DIterator.
 *
 * @author BCIT
 * @version 2016
 */
interface DIterator<T> {
    boolean isEmpty();

    boolean hasNext();

    boolean hasPrevious();

    T next();

    T previous();
}

/**
 * DLinkedList.
 *
 * @author BCIT
 * @version 2016
 */
class DLinkedList<T extends Comparable<T>> {
    private DNode<T> head;

    /*
     * DNode.
     *
     * @author BCIT
     * 
     * @version 2016
     */
    private class DNode<R> {
        R data;
        DNode<R> previous, next;

        DNode(R d) {
            data = d;
        }
    }

    public void clear() {
        head = null;
    }

    public boolean insert(T d) {
        DNode<T> temp = new DNode<T>(d);
        DNode<T> cur = head;
        DNode<T> prev = head;
        // 1. empty list case
        if (head == null) {
            head = temp;
            return true;
        }
        // 2. non-empty list, find position
        while ((cur.next != null) && (cur.data.compareTo(d) < 0)) {
            prev = cur;
            cur = cur.next;
        }
        // 3. value exists in list already - fail
        if (cur.data == d)
            return false;
        // 4. single node in list
        if (cur == prev) {
            // 5. single node < new node
            if (cur.data.compareTo(d) < 0) {
                cur.next = temp;
                temp.previous = cur;
                return true;
            }
            // 6. single node > new node
            temp.next = cur;
            cur.previous = temp;
            head = temp;
            return true;
        }
        // 7. multiple nodes in list
        prev.next = temp;
        temp.next = cur;
        // 8. check if being added at the start of the list
        // if it is there is no previous node and the head of list
        // needs to change
        if (cur.previous != null)
            cur.previous = temp;
        else
            head = temp;
        temp.previous = prev;
        return true;
    }


    public DIterator<T> iterator() {
        return new DIterator<T>() {
            DNode<T> cur = head;

            public boolean isEmpty() {
                if (cur != null)
                    return false;
                return true;
            }

            public boolean hasNext() {
                return cur.next != null;
            }

            public boolean hasPrevious() {
                return cur.previous != null;
            }

            public T next() {
                T d = cur.data;
                cur = cur.next;
                return d;
            }

            public T previous() {
                T d = cur.data;
                cur = cur.previous;
                return d;
            }
        };
    }
}

/**
 * DTest drives the program.
 *
 * @author BCIT
 * @version 2016
 */
public class DTest {
    

    public static <T extends Comparable<T>> void print(DLinkedList<T> list) {
        DIterator<T> i = list.iterator();
        while (!i.isEmpty())
            System.out.print("" + i.next() + " ");
        System.out.println("");
    }

    public static <T extends Comparable<T>> void printR(DLinkedList<T> list) {
        DIterator<T> i = list.iterator();
        while (i.hasNext())
            i.next();
        while (!i.isEmpty())
            System.out.print("" + i.previous() + " ");
        System.out.println("");
    }
    
    /**********************************************************************************/
    /********************* DO NOT MODIFY ANYTHING BELOW THIS LINE *********************/
    
    static DLinkedList<Integer> list = new DLinkedList<Integer>();
    static DLinkedList<String> slist = new DLinkedList<String>();

    /**
     * Drives the program.
     * @param args
     */
    public static void main(String[] args) {
        
        System.out.println("single entry");
        list.insert(12);// single entry
        print(list);
        
        System.out.println("2 values displayed in-order");
        list.insert(4);// second entry
        print(list);// should display in-order 2 values
        
        list.clear();
        
        int[] prime = { 47, 13, 23, 17, 5, 19, 37 };// should insert IN-ORDER
        for (int d : prime)
            list.insert(d);
        System.out.println("7 prime numbers displayed in-order");
        print(list);
        
        System.out.println("can I re-add 13?" + list.insert(13));// should fail
                                                                 // to insert,
                                                                 // returns
                                                                 // false
        
        System.out.println("7 prime numbers ONLY, no repeats");
        print(list);
        
        System.out.println("new list using strings");
        slist.insert("Edward");
        slist.insert("Santo");
        slist.insert("George");
        slist.insert("Farga");
        slist.insert("Lester");
        slist.insert("Dan");
        slist.insert("Rene");
        slist.insert("Sean");
        print(slist);
        
        System.out.println("attempting to add George again");
        slist.insert("George");
        print(slist);
        
        System.out.println("list in reverse");
        printR(slist);
    } // END OF MAIN METHOD

}
