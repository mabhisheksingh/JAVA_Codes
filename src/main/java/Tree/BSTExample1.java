package Tree;

//---------------------------Printing PreOrder Tree-------------------------
//        40 30 25 15 28 35 80 50 45 60 55 70 62 72 100
//        ---------------------------Printing InOrder Tree--------------------------
//        15 25 28 30 35 40 45 50 55 60 62 70 72 80 100
//        ---------------------------Printing PostOrder Tree------------------------
//        15 28 25 35 30 45 55 62 72 70 60 50 100 80 40
//        ---------------------------Printing Height of Tree------------------------
public class BSTExample1 extends Node{
    public BSTExample1(int value) { super(value); }
    public static BSTExample1 implBinaryTree = null;
    public static void loadTree(){
        implBinaryTree = new BSTExample1(40);
        insert(30);insert(35);insert(80);insert(100);
        insert(50);insert(25);insert(15);insert(28);
        insert(45);insert(60);insert(55);insert(70);
        insert(62);insert(72);
    }
    public static boolean insert(int value){
        Node temp = implBinaryTree;
        if(implBinaryTree == null){
            implBinaryTree = new BSTExample1(value);
            System.out.println("New Object created Successfully ");
            return true;
        }
//      if(binaryTree.value == value )
        while (temp!=null){
            if(value >= temp.value){
                if(temp.right !=null)
                    temp = temp.right;
                else{
                    temp.right = new Node(value);
                    return true;
                }
            }else{
                if(temp.left !=null)
                    temp = temp.left;
                else{
                    temp.left = new Node(value);
                    return true;
                }
            }
        }
        return false;
    }

    public static void inorderSuccessorInBinarySearchTree(Node root, int n) {
        printInOrder(root);
        System.out.println("\n--------------------Above Print-----------\n");
        inorderSuccessorInBinarySearchTreePrint(root,n,false);
    }
    public static void printInOrder(Node root){  //Left Root Right
        if(root ==null) return;
        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    public static void inorderSuccessorInBinarySearchTreePrint(Node root, int n,boolean flag) {
        if( root== null) return;
        inorderSuccessorInBinarySearchTreePrint( root.left , n ,flag);

        if(root.value == n){
            flag = true;
            System.out.print( "Value matched : "+root.value +" ");
        }
        if (root.value  > n && flag){
            System.out.println("InOrder Successor: "+ root.value);
            flag=false;
            return;
        }
        //inorderSuccessorInBinarySearchTree( root.left , n );
        inorderSuccessorInBinarySearchTreePrint( root.right , n , flag );
    }

    public static void main(String[] args) {
        loadTree();
        System.out.println("---------------------------Printing InOrder Successor Tree-------------------------");
        inorderSuccessorInBinarySearchTree(implBinaryTree,60);
    }
}
