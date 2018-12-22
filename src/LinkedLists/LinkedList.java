package LinkedLists;

/**
 * LinkedList
 * Purpose:
 *
 * @author Denielle Kirk Abaquita
 * @version 2018-12-21 @ 21:19
 */

public class LinkedList
{
    // Instance variables
    Node head;
    int length = 0;

    /** Constructor w/ head input */
    public LinkedList(Node head)
    {
        this.head = head;
        length++;
    }

    /** Constructor: creates LL w/ certain length (id's from 0 to length) */
    public LinkedList(int length) throws Exception
    {
        int i = 0;
        Node current;

        if (length == 0)
        {
            throw new Exception("Error: Linked List cannot be 0 length.");
        }

        this.length = length;

        // Assign the head
        this.head = new Node(i);
        current = this.head;

        // Initializes an entire Linked List with id and index the same
        for (i = 1; i < length; i++)
        {
            current.next = new Node(i);
            current = current.next;
        }
    }

    /**
     * Appends a new node to the end of a linked list
     * @param id - parameter for new node
     */
    public void append(int id)
    {
        Node current;

        if (head == null)
        {
            head = new Node(id);
            return;
        }

        // Places pointer for first node
        current = head;

        // Iterates over list
        while (current.next != null)
        {
            current = current.next;
        }

        // Appends a new node to end and increments length
        current.next = new Node(id);
        length++;
    }

    /**
     * Appends a new node at head of list
     * @param id - parameter for new node
     */
    public void prepend(int id)
    {
        Node newHead;

        if (head == null)
        {
            head = new Node(id);
            return;
        }

        // prepend by setting new node to head
        newHead = new Node(id);
        newHead.next = head;
        head = newHead;

        length++;
    }

    /**
     * Deletes the node with the given id
     * @param id - data to be used to identify node
     *           to be deleted
     */
    public void deleteWithValue(int id)
    {
        Node current;

        if (head == null)
            return;

        if (head.id == id)
        {
            head = head.next;
            return;
        }

        current = head;

        // Iterates over linked list
        while (current.next != null)
        {
            // if the id is identified, skip over in linked list
            if (current.next.id == id)
            {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }

        length--;
    }

    @Override
    public String toString()
    {
        int i;
        Node current = head;

        for (i = 0; current.next != null; i++)
        {
            System.out.printf("Current ID: %d   Next ID: %d\n", current.id, current.next.id);

            current = current.next;
        }

        return "wow!";
    }

    /**
     * Test function
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        LinkedList linkedList = new LinkedList(5);

        linkedList.toString();
        System.out.println();

        linkedList.append(24);
        linkedList.toString();
        System.out.println();

        linkedList.deleteWithValue(2);
        linkedList.toString();
        System.out.println();

        linkedList.prepend(9);
        linkedList.toString();
    }

}
