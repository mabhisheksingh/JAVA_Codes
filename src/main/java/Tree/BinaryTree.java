package Tree;
import java.util.*;

//Input:
//        Therefore, the BST will be:
//              40
//          /      \
//         30       80
//        / \      /  \
//       25  35   50   100
//      / \      / \
//     15 28    45 60
//                / \
//               55 70
//                 / \
//                62  72
//


class TopBottomView{
    public Node node;
    public int HD;
}
public class BinaryTree extends Node {
    public BinaryTree(int value) { super(value); }
    public static BinaryTree implBinaryTree = null;
    public static void loadTree(){
        implBinaryTree = new BinaryTree(40);
        insert(30);insert(35);insert(80);insert(100);
        insert(50);insert(25);insert(15);insert(28);
        insert(45);insert(60);insert(55);insert(70);
        insert(62);insert(72);
    }

    private static HashMap<Integer,Integer> HEIGHT_OF_NODE = new HashMap<>();
    private static TreeMap<Integer,Integer> HorizontalView = new TreeMap<>();
    private static TreeMap<Integer,ArrayList<Integer>> HorizontalData = new TreeMap<>();

    public static void main(String [] args) {
        
        loadTree();
        {
            System.out.println("---------------------------Printing PreOrder Tree-------------------------");
            printPreOrder(implBinaryTree);
            System.out.println("\n---------------------------Printing InOrder Tree--------------------------");
            printInOrder(implBinaryTree);
            System.out.println("\n---------------------------Printing PostOrder Tree------------------------");
            printPostOrder(implBinaryTree);
            System.out.println("\n---------------------------Printing Height of Tree------------------------");
            //HEIGHT_OF_NODE.put( binaryTree, heightOfBinaryTree(binaryTree));
            System.out.println("Height : " + heightOfBinaryTree(implBinaryTree));
            System.out.println("\n---------------------------Printing Node at Kth Distance of Tree------------------------");
            printNodesAtKDistance(implBinaryTree, 2);
            System.out.println("\n---------------------------Printing Level Order traversal of tree------------------------");
            printLevelOrderTraversal(implBinaryTree);
            System.out.println("\n---------------------------Printing each Level in new Line------------------------");
            printLevelOrderTraversalLineByLine(implBinaryTree);
            System.out.println("\n---------------------------Printing Size of tree------------------------");
            System.out.println("Size of Binary tree : " + getSizeOfBinaryTree(implBinaryTree));


            System.out.println("\n---------------------------Printing Left view of tree------------------------");
            printLeftViewOfTree(implBinaryTree);
            System.out.println("\n---------------------------Printing Right view of tree------------------------");
            printRightViewOfTree(implBinaryTree);

            System.out.println("\n---------------------------Printing Horizontal view of tree------------------------");
            printHorizontalViewOfTree(implBinaryTree,0);
            System.out.println("HashDATA : "+HorizontalData);
            System.out.println("\n---------------------------Printing Top view of tree------------------------");
            printTopViewOfTree(implBinaryTree,0);
            System.out.println("Top View : "+HorizontalView);
            System.out.println("\n---------------------------Printing Bottom view of tree------------------------");
            printBottomViewOfTree(implBinaryTree,0);
            System.out.println("Bottom View : "+HorizontalView);
            System.out.println("\n---------------------------Printing max of tree------------------------");
            System.out.println("max element of Binary tree : " + getMaxElementInTree(implBinaryTree));

            System.out.println("\n---------------------------Tree follow children sum property or not ------------------------");
            //Children Sum Property is a property in which the sum of values of the left child and right child should be
            // equal to the value of their node if both children are present. Else if only one child is present then the value
            // of the child should be equal to its node value.
            Node temp = new Node(5);
            temp.left = new Node(3);
            temp.right = new Node(2);
            System.out.println("Tree follow children sum property for temp : " + childrenSumProperty(temp));
            System.out.println("Tree follow children sum property for binaryTree : " + childrenSumProperty(implBinaryTree));
        }
        System.out.println("\n---------------------------Checking for Balanced Binary Tree ------------------------");
        //Check for Balanced Binary Tree
//        In a Balanced Binary Tree for every node, the difference between heights of left subtree and right subtree should not be more than one.
//        In this video we discuss two solutions (one with time complexity of O(n^2) and another with time complexity of O(n) )
//        to check whether a Tree is Balanced or not.
        Node temp = new Node(5);
        temp.left = new Node(3);
        temp.right = new Node(2);
        System.out.println("height of binaryTree is Balanced Binary Tree : "+isBalancedBinaryTree(temp));
        System.out.println("\n---------------------------Printing Maximum Width of Binary Tree------------------------");
        System.out.println("Max Width : "+maximumWidthOfBinaryTree(implBinaryTree));
        System.out.println("\n---------------------------Printing Tree Traversal in Spiral Form of Binary Tree------------------------");
        treeTraversalInSpiralForm(implBinaryTree);

// Comment for safety purpose
//        System.out.println("\n---------------------------Converting Tree Into double Linked list------------------------");
//        inorderConversionOfBinaryTreeToDoublyLinkedList(binaryTree);
//        System.out.println("Head "+HEAD.value);
//        PrintingDoublyLinkedList(HEAD);

        System.out.println("\n---------------------------Printing Diameter of Binary Tree------------------------");
        System.out.println("Diameter of Binary tree : "+diameterOfBinaryTree(implBinaryTree));
        System.out.println("Size = : "+ HEIGHT_OF_NODE.entrySet());

        System.out.println("\n---------------------------Printing LCS array of Binary Tree------------------------");
        List list1  =LCSofBinaryTree(implBinaryTree, 45, new ArrayList<>());
        System.out.println("Size of lcs array1 = : "+ list1.size());
        list1.forEach( System.out::println);
        List list2  =LCSofBinaryTree(implBinaryTree,72, new ArrayList<>());
        System.out.println("Size of lcs array2 = : "+ list2.size());
        list2.forEach( System.out::println);
        System.out.println("\n---------------------------Printing Inorder Iterative of Binary Tree------------------------");
        List<Integer> list= inOrderIterative(implBinaryTree);
        System.out.println(list);




    }

    public static boolean insert(int value){
        Node temp = implBinaryTree;
        if(implBinaryTree == null){
            implBinaryTree = new BinaryTree(value);
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
    public static void printPreOrder(Node root){  // Root Left Right
        if(root==null) return;
        System.out.print(root.value+" ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    public static void printInOrder(Node root){  //Left Root Right
        if(root ==null) return;
        printInOrder(root.left);
        System.out.print(root.value+" ");
        printInOrder(root.right);
    }
    public static void printPostOrder(Node root){  //  Left Right Root
        if(root == null ) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.value+" ");

    }
    //Height of Binary tree
    public static int heightOfBinaryTree(Node root) {
        if (root == null) return 0;
        int heightOfLeft = heightOfBinaryTree(root.left);
        int heightOfRight = heightOfBinaryTree(root.right);
//        HEIGHT_OF_NODE.put(root.value,heightOfLeft);
//        HEIGHT_OF_NODE.put(root.value,heightOfRight);
        int maxRootHeight = Math.max( heightOfRight , heightOfLeft ) + 1;
        HEIGHT_OF_NODE.put(root.value , maxRootHeight);
        return maxRootHeight;
    }
    //Printing Node at Kth Distance of Tree
    public static void printNodesAtKDistance(Node root,int k) {
        if (root == null) return;
        if(k == 0) {
            System.out.print(root.value +" ");
            return;
        }
        printNodesAtKDistance(root.left,k-1);
        printNodesAtKDistance(root.right,k-1);
    }

    //print level order of a tree or BFS
    public static void printLevelOrderTraversal(Node root) {
        Queue<Node> queue =new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node element = queue.poll();
            System.out.print(element.value+" ");
            if (element.left!=null){
                queue.add(element.left);
            }
            if (element.right != null) {
                queue.add(element.right);
            }
        }
    }
    //print each Level in new Line
    public static void printLevelOrderTraversalLineByLine(Node root) {
        Queue<Node> queue =new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            System.out.println();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node element = queue.poll();
                System.out.print(element.value+" ");
                if (element.left != null){
                    queue.add(element.left);
                }
                if (element.right != null) {
                    queue.add(element.right);
                }
            }
            System.out.println();
        }
    }
    //get size of Binary tree
    public static int getSizeOfBinaryTree(Node root) {
        if(root == null) return 0;
        return getSizeOfBinaryTree(root.left)+ getSizeOfBinaryTree(root.right)+1;
    }

    //print left view fo tree
    public static void printLeftViewOfTree(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int queueSize=  queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node temp = queue.poll();
                if (i == 0) System.out.print(temp.value+" ");
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }

        }
    }


    //Print Right view of tree
    public static void printRightViewOfTree(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int queueSize=  queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node temp = queue.poll();
                if (i == 0) System.out.print(temp.value+" ");
                if(temp.right!=null) queue.add(temp.right);
                if(temp.left!=null) queue.add(temp.left);

            }

        }
    }

    //print horizontal view of BT
    public static void printHorizontalViewOfTree(Node root,int HD) {
        if (root == null) return;
        printHorizontalViewOfTree(root.left,HD-1);
        if(HorizontalData.containsKey(HD)){
            List temp  = HorizontalData.get(HD);
            temp.add(root.value);
        }else {
            ArrayList temp = new ArrayList();
            temp.add(root.value);
            HorizontalData.put(HD , temp);
        }
        printHorizontalViewOfTree(root.right,HD+1);
    }

    //print Top view fo tree
    public static void printTopViewOfTree(Node root,int HD) {
        if (root == null) return;
        Queue<TopBottomView> queue = new LinkedList<>();
        TopBottomView topBottomView = new TopBottomView();
        topBottomView.node = root;
        topBottomView.HD= HD;
        queue.add(topBottomView);
        while (!queue.isEmpty()){
            int queueSize=  queue.size();
            for (int i = 0; i < queueSize; i++) {
                topBottomView = queue.poll();
                Node temp =  topBottomView.node;
                int tempHD = topBottomView.HD;
                if(!HorizontalView.containsKey(tempHD)) HorizontalView.put(tempHD,temp.value);
                if(temp.left!=null){
                    TopBottomView leftTopBottomView = new TopBottomView();
                    leftTopBottomView.node = temp.left;
                    leftTopBottomView.HD= tempHD-1;
                    queue.add(leftTopBottomView);
                }

                if(temp.right!=null) {
                    TopBottomView rightTopBottomView = new TopBottomView();
                    rightTopBottomView.node = temp.right;
                    rightTopBottomView.HD= tempHD+1;
                    queue.add(rightTopBottomView);
                }
            }
        }
    }

    //Print Bottom view of tree
    public static void printBottomViewOfTree(Node root,int HD) {
        if (root == null) return;
        TopBottomView topBottomView = new TopBottomView();
        topBottomView.node = root;
        topBottomView.HD= HD;
        Queue<TopBottomView> queue = new LinkedList<>();
        queue.add(topBottomView);
        while (!queue.isEmpty()){
            int queueSize=  queue.size();
            for (int i = 0; i < queueSize; i++) {
                topBottomView= queue.poll();
                Node temp =topBottomView.node;
                int tempHd= topBottomView.HD;
                HorizontalView.put(tempHd,temp.value);
                if(temp.right!=null){
                    TopBottomView topBottomView1 = new TopBottomView();
                    topBottomView1.node = temp.left;
                    topBottomView1.HD = tempHd-1;
                    queue.add(topBottomView1);
                }
                if(temp.left!=null){
                    TopBottomView topBottomView1 = new TopBottomView();
                    topBottomView1.node = temp.right;
                    topBottomView1.HD = tempHd+1;
                    queue.add(topBottomView1);
                }
            }

        }
    }

    //Find max element in tree
    public static int getMaxElementInTree(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.value, Math.max(getMaxElementInTree(root.left), getMaxElementInTree(root.right)) );
    }

    //Children sum property
    public static boolean childrenSumProperty(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int sum = root.left.value+ root.right.value;
        return (root.value == sum && childrenSumProperty(root.left) && childrenSumProperty(root.right));
    }
    //checking tree is balanced or not
    public static int isBalancedBinaryTree(Node root) {
        if (root == null )  return 0;
        int lh = isBalancedBinaryTree(root.left);
        if(lh == -1 ) return -1;
        int rh = isBalancedBinaryTree(root.right);
        if(rh == -1 ) return -1;
        if( Math.abs(lh-rh )>1) return -1;
        else return Math.max(lh,rh)+1;
    }

    public static int maximumWidthOfBinaryTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        queue.add(root);
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            max = Math.max( queueSize,max);
            for (int i = 0; i < queueSize; i++) {
                Node element = queue.poll();
                if (element.left != null) {
                    queue.add(element.left);
                } if (element.right != null) {
                    queue.add(element.right);
                }
            }
        }

    return  max;
    }

    public static void treeTraversalInSpiralForm(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        Stack<Node> nodeStack = new Stack<>();
        boolean spiral = false;
        nodeQueue.add( root);
        while (!nodeQueue.isEmpty()){
            System.out.println();
            int queueSize = nodeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                Node element = nodeQueue.poll();
                if(spiral) nodeStack.push(element);
                else System.out.print( element.value +" ");
                if (element.left != null) nodeQueue.add(element.left);
                if (element.right != null) nodeQueue.add(element.right);
            }
            while (spiral && !nodeStack.isEmpty()) {
                System.out.print(nodeStack.pop().value + " ");
            }
            if(spiral){
                spiral =false;
                continue;
            }
            System.out.println();
            spiral = true;
        }
    }

    private static Node HEAD =null;
    private static Node PREV =null;
    public static Node inorderConversionOfBinaryTreeToDoublyLinkedList(Node root ) {
        if (root == null) return root;
        inorderConversionOfBinaryTreeToDoublyLinkedList(root.left);
        if(PREV == null) HEAD = root;
        else{
            root.left = PREV;
            PREV.right= root;
        }
        PREV = root;
        inorderConversionOfBinaryTreeToDoublyLinkedList(root.right);
        return HEAD;
    }

    public static void PrintingDoublyLinkedList(Node root){
        System.out.println("Printing start Doubly Linked list...\n");
        while (root.right!=null){
            System.out.println("\tPrev Address : "+root.left + " Current Address : "+root +" value : "+root.value+" Next Address : "+root.right);
            root = root.right;
        }
        System.out.println("Printing Stop Doubly Linked list...\n\n");
    }

    public static int diameterOfBinaryTree(Node root){
        if(root == null) return 0;
        int d1 = (1+ heightOfBinaryTree(root.left) + heightOfBinaryTree(root.right));
        int d2 = diameterOfBinaryTree(root.left);
        int d3 = diameterOfBinaryTree(root.right);
        return Math.max( d1 , Math.max(d2,d3));
    }

    public static boolean pathFinderForLCS(Node root, int number, ArrayList<Integer> lcsArray) {
        if(root == null) return false;
        lcsArray.add(root.value);
        if(root.value == number) return true;
        if(pathFinderForLCS(root.left,number,lcsArray) || pathFinderForLCS(root.right,number,lcsArray) ) return true;
        lcsArray.remove(lcsArray.size()-1);
        return false;
    }
    public static List<Integer> LCSofBinaryTree(Node root, int numberOne, ArrayList<Integer> path1) {
        if(!pathFinderForLCS(root,numberOne ,path1)) return null;
        return path1;
    }

    public static List<Integer> inOrderIterative(Node root){
        List<Integer> output = new ArrayList<>();
        Stack<Node>  nodeStack = new Stack<>();
        if( root == null) return new ArrayList<>();
        while ( root!=null || !nodeStack.isEmpty()){

            while ( root!=null){
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            output.add( root.value );
            root = root.right;
        }

        return output;
    }

    public List<Integer> postorderTraversal(Node root) {
        List<Integer> output = new ArrayList<>();
        Stack<Node>  nodeStack = new Stack<>();
        if( root == null) return output;
        while ( true){

            while ( root!=null){
                nodeStack.push(root);
                nodeStack.push(root);
                root = root.left;
            }
            if(nodeStack.isEmpty()) return output;
            root = nodeStack.pop();
            if(!nodeStack.isEmpty() && nodeStack.peek() == root ) root = root.right;
            else {
                output.add( root.value );
                root=null;
            }
            // root = root.right;

        }

        //return output;
    }
}

