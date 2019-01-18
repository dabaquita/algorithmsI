package LinkedLists;

/**
 * Node
 * Purpose: A node component to be
 * used in a linked list.
 *
 * @author Denielle Kirk Abaquita
 * @version 2018-12-21 @ 21:19
 */

public class Node
{
    // Instance variables
    int id;
    Node next;

    public Node(int id)
    {
        this.id = id;
        this.next = null;
    }

    public Node(int id, Node next)
    {
        this.id = id;
        this.next = next;
    }

}
