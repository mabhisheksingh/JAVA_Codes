package CodingQuestions.linkedlist;

//SingleLinkedList in java
public final class SinglyLinkedList {
    public int data;
    public SinglyLinkedList next;
    SinglyLinkedList(int data){
        this.data =data;
        this.next = null;
    }

    /* Inserts a new Node at the front of the list. */
    public SinglyLinkedList pushInFront(int new_data, SinglyLinkedList head){
        System.out.println("new node pushed successfully :"+new_data);
        SinglyLinkedList new_singlyLinkedList = new SinglyLinkedList(new_data);
        SinglyLinkedList temp = head;
        new_singlyLinkedList.next = head;

        //System.out.println(temp.data+" teamp next "+temp.next+" head "+head.data+" head "+head + " nexxt "+head.next);
        return new_singlyLinkedList;
    }


    /* Inserts a new Node at the back of the list. */
    public SinglyLinkedList pushInback(int new_data, SinglyLinkedList head){
        System.out.println("new node pushed in back successfully :"+new_data);
        SinglyLinkedList new_singlyLinkedList = new SinglyLinkedList(new_data);
        SinglyLinkedList temp = head;
        new_singlyLinkedList.next = null;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = new_singlyLinkedList;
        return head;
    }

    /*find length of linked list*/
    public int length(SinglyLinkedList head){
        int len=0;
        SinglyLinkedList singlyLinkedList = head;
        while (singlyLinkedList.next!=null){
            len++;
            singlyLinkedList = singlyLinkedList.next;
        }
        return ++len;
    }

    /*printing linked list*/
    public void printLinkedList(SinglyLinkedList head){
        int len=head.length(head);
        SinglyLinkedList singlyLinkedList = head;
        while(singlyLinkedList.next!=null){
            System.out.print(singlyLinkedList.data+" ");
            singlyLinkedList = singlyLinkedList.next;
        }
       System.out.println(singlyLinkedList.data);
    }

    /*pop Element from back linked list*/
    public SinglyLinkedList popBack(SinglyLinkedList singlyLinkedList){
        if(singlyLinkedList ==null || singlyLinkedList.next==null){
            return null;
        }
        System.out.println("Node "+ singlyLinkedList.data+" pop Successfully from back");
         singlyLinkedList = singlyLinkedList.next;
         return singlyLinkedList;
    }

    /*pop Element from front linked list*/
    public SinglyLinkedList popFront(SinglyLinkedList head) {
        if(head==null || head.next==null){
            return null;
        }
        SinglyLinkedList temp = head;
        while (temp.next.next!=null){
            temp = temp.next;
        }
        //temp = temp.next;
        System.out.println("Node "+temp.next.data+" pop Successfully from front");
        temp.next=null;
        return head;
    }

    public SinglyLinkedList deleteindexAtIndex(SinglyLinkedList head, int index) {
        if(head==null){
            return head;
        }else if(index==0){
            System.out.println("Element "+head.data+ " At index "+ index+" has been deleted from Linked list");
            return head = head.next;
        }
        int tempIndex =0;
        SinglyLinkedList temp = head;
        SinglyLinkedList pre = null;
        while (tempIndex!=index && temp.next!=null){
            tempIndex++;
            pre = temp;
            temp= temp.next;
        }
        if(temp.next==null && index==tempIndex){
            System.out.println("Element "+temp.data+ " At index "+ index+" has been deleted from Linked list");
            pre.next=null;
        }else if(temp.next==null && index!=tempIndex){
            System.out.println("Index "+index+" out bound ..........");

        }else if (index==tempIndex){
            System.out.println("Element "+temp.data+ " At index "+ index+" has been deleted from Linked list");
            pre.next = temp.next;

        }else{
            System.out.println("Element "+temp.data+ " At index "+ index+" has been deleted from Linked list");
            pre.next =null;

        }
        return head;
    }

}
