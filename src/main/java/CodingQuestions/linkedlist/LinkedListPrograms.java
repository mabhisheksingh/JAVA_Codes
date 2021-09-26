package CodingQuestions.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedListPrograms {
    private static SinglyLinkedList head =new SinglyLinkedList(1);
    public static void main(String[] args) {
        /*-------------pushing end---------*/
        System.out.println("**** push in back of linked list ******");
        pushElementInBackOfLinkedList();
        System.out.println("Linked list len : "+head.length(head));
        System.out.println("******linked List printing Start******");
        head.printLinkedList(head);
        System.out.println("******linked List printing End******");

        System.out.println("**** push in front of linked list ******");
        pushElementInFrontOfLinkedList();
        System.out.println("Linked list len : "+head.length(head));
        System.out.println("******linked List printing Start******");
        head.printLinkedList(head);
        System.out.println("******linked List printing End******");
        /*-------------pushing end---------*/
        /*-------------Deletion start---------*/
        System.out.println("**** pop in back of linked list ******");
        popElementInBackOfLinkedList();
        System.out.println("Linked list len : "+head.length(head));
        System.out.println("******linked List printing Start******");
        head.printLinkedList(head);
        System.out.println("******linked List printing End******");

        System.out.println("**** pop in front of linked list ******");
        popElementInFrontOfLinkedList();
        System.out.println("Linked list len : "+head.length(head));
        System.out.println("******linked List printing Start******");
        head.printLinkedList(head);
        System.out.println("******linked List printing End******");

        deleteElementAtIndexInLinkedList();

        /*-------------Deletion End---------*/

        /*Write a Program to Move the last element to Front in a Linked List*/
        MoveLastElementTofrontOfLinkedList();
        /*Remove Duplicates in a Unsorted Linked List*/
        removeDuplicatesFromUnsortedLinkedList();
    }

    private static void pushElementInBackOfLinkedList() {
        head = head.pushInback(100,head);
        head = head.pushInback(102,head);
        head = head.pushInback(105,head);
        head = head.pushInback(199,head);
        head = head.pushInback(170,head);
        head = head.pushInback(145,head);
        head = head.pushInback(125,head);
        head.pushInback(178, head);
    }

    private static void pushElementInFrontOfLinkedList(){
        head = head.pushInFront(200,head);
        head = head.pushInFront(201,head);
        head = head.pushInFront(206,head);
        head = head.pushInFront(205,head);
        head = head.pushInFront(299,head);
        head = head.pushInFront(246,head);
        head = head.pushInFront(245,head);
        head = head.pushInFront(258,head);

    }

    private static void popElementInBackOfLinkedList(){
        head = head.popBack(head);
        head = head.popBack(head);
    }

    private static void popElementInFrontOfLinkedList(){
        head = head.popFront(head);
        head = head.popFront(head);
    }

    private static void deleteElementAtIndexInLinkedList(){
        System.out.println("**** Delete at index in from linked list ******");
        System.out.println("Original Linked list len : "+head.length(head)+"\nDeletion start \n");
        head.printLinkedList(head);


        head = head.deleteindexAtIndex(head,0); // first index
        head.printLinkedList(head);
        head = head.deleteindexAtIndex(head,12); //out of bound index
        head.printLinkedList(head);
        head = head.deleteindexAtIndex(head, head.length(head)-1);//last index deleted
        head.printLinkedList(head);
        head = head.deleteindexAtIndex(head,5);//random index
        head.printLinkedList(head);
        head = head.deleteindexAtIndex(head, head.length(head)-2);//last index deleted
        head.printLinkedList(head);
        head = head.deleteindexAtIndex(head, head.length(head)-3);//last index deleted
        head.printLinkedList(head);
    }

    /*Write a Program to Move the last element to Front in a Linked List*/
    private static void MoveLastElementTofrontOfLinkedList(){
        System.out.println("\n******Original linked List printing Start ******");
        head.printLinkedList(head);
        if(head==null){
            System.out.println("Linked list is empty");
        }else{
            SinglyLinkedList temp = head;
            SinglyLinkedList prev = null;
            while (temp.next!=null){
                prev= temp;
                temp = temp.next;
            }
            prev.next =null;
            temp.next = head;
            head = temp;
        }


        System.out.println("\n******After moving last element in front of linked List ******");
        head.printLinkedList(head);
    }

    /*Remove Duplicates in a Unsorted Linked List*/
    private static void removeDuplicatesFromUnsortedLinkedList() {
        //insert duplicates
        {
            head = head.pushInFront(246,head);
            head = head.pushInFront(245,head);
            head = head.pushInFront(258,head);
            head = head.pushInback(246,head);
            head = head.pushInback(245,head);
            head = head.pushInback(258,head);
            head = head.pushInback(205,head);
            head = head.pushInback(206,head);
        }
        System.out.println("\n******Original linked List printing Start ******");
        head.printLinkedList(head);
        //removing duplicates
        SinglyLinkedList temp = head;
        Map<Integer,Integer> hashmap = new HashMap<>();
        SinglyLinkedList prev = null;
        while (temp.next!=null){
            if(hashmap.containsKey(temp.data)){
                prev.next = temp.next;
                temp = temp.next;
            }else{
                hashmap.put(temp.data,temp.data);
                prev =temp;
                temp = temp.next;
            }
        }
        //checking last node
        if(hashmap.containsKey(temp.data)){
            prev.next = null;
        }else{
            hashmap.put(temp.data,temp.data);
        }
        System.out.println("\n******After removing Duplicates from linked List ******");
        head.printLinkedList(head);
    }

}
