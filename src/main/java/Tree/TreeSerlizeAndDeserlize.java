package Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeSerlizeAndDeserlize {
    private static BinaryTree implBinaryTree = null;
    public static void main(String[] args) {
        BinaryTree.loadTree();
        implBinaryTree = BinaryTree.implBinaryTree;
        System.out.println("---------------------------Printing PreOrder Tree-------------------------");
        BinaryTree.printPreOrder(implBinaryTree);
        System.out.println("\n-------------------------Printing serialize of Binary Tree---------------");
        List<Integer> serializeBinaryTree =new ArrayList<>();
        serialize(implBinaryTree , serializeBinaryTree);
        System.out.print(serializeBinaryTree);
        System.out.println("\n---------------------------Printing DeSerialize Tree-------------------------");
        implBinaryTree =null;
        implBinaryTree = deSerialize( serializeBinaryTree);
        BinaryTree.printPreOrder(implBinaryTree);


    }

    private static void serialize(Node root ,List<Integer> list){
        if( root == null) {
            list.add(-1); return;
        }
        list.add(root.value );
        serialize(root.left,list);
        serialize(root.right,list);
    }
    static int i=0;

    private static BinaryTree deSerialize(List<Integer> list){
        if( list.isEmpty() ) return null;
        int val = list.get(i);
        i++;
        if(val == -1) return null;
        BinaryTree root = new BinaryTree(val);
        root.left = deSerialize(list);
        root.right  = deSerialize(list);

        return root;
    }
}
