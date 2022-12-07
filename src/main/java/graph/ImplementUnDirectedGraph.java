package graph;

import java.util.*;

public class ImplementUnDirectedGraph {

    /*  0  1  2  3  4  5
        a ,b ,c, d, e  f
    *     b------d   f
    *   / |   /  |
    *  a  |  /   |
    *   \ | /    |
    *    c ------e

    *     1------3   5
    *   / |   /  |
    *  0  |  /   |
    *   \ | /    |
    *    2 ------4
    * */

    private final static int SIZE_OF_GRAPH = 6;
    static NonWeightedGraph unDirectedGraph = new NonWeightedGraph(SIZE_OF_GRAPH);
    static{
        unDirectedGraph.addEdge('A','B');
        unDirectedGraph.addEdge('A','C');

        unDirectedGraph.addEdge('B','A');
        unDirectedGraph.addEdge('B','C');
        unDirectedGraph.addEdge('B','D');

        unDirectedGraph.addEdge('C','A');
        unDirectedGraph.addEdge('C','B');
        unDirectedGraph.addEdge('C','D');
        unDirectedGraph.addEdge('C','E');

        unDirectedGraph.addEdge('D','B');
        unDirectedGraph.addEdge('D','C');
        unDirectedGraph.addEdge('D','E');

        unDirectedGraph.addEdge('E','C');
        unDirectedGraph.addEdge('E','D');


        unDirectedGraph.addEdge(0,1);
        unDirectedGraph.addEdge(0,2);

        unDirectedGraph.addEdge(1,0);
        unDirectedGraph.addEdge(1,2);
        unDirectedGraph.addEdge(1,3);

        unDirectedGraph.addEdge(2,0);
        unDirectedGraph.addEdge(2,1);
        unDirectedGraph.addEdge(2,3);
        unDirectedGraph.addEdge(2,4);

        unDirectedGraph.addEdge(3,1);
        unDirectedGraph.addEdge(3,2);
        unDirectedGraph.addEdge(3,4);

        unDirectedGraph.addEdge(4,2);
        unDirectedGraph.addEdge(4,3);
        unDirectedGraph.addEdge(5,-1); // source did connect to any node
    }

    public static void BFSPrinting(Map<Character,ArrayList<Character> > graph,Map<Character,Boolean> visted ,Character source){
        Queue< Character> queue= new LinkedList<>();
        queue.add(source);
        System.out.println(source);
        visted.put(source,true);
        while ( !queue.isEmpty()){
            Character key = queue.poll();
            List<Character> edges = graph.get(key );
            for (Character node : edges) {
                if (visted.get(node)) continue;
                System.out.print(node + " ");
                queue.add(node);
                visted.put(node, true);
            }
            System.out.println();
        }
    }
    public static void DFSPrinting(Map<Character,ArrayList<Character> > graph,Map<Character,Boolean> visted ,Character source){
        System.out.println(source);
        visted.put(source,true);
        for (Character ch :   graph.get(source)) {
            if(visted.get(ch )) continue;
            DFSPrinting( graph,visted, ch);
        }

    }

    public static boolean findCycleInGraph(Map<Character,ArrayList<Character> > graph,Map<Character,Boolean> visted ,Character source,Character parent){

        visted.put(source,true);
        for (Character ch : graph.get(source)) {
            if(visted.get(ch )) continue;
            System.out.println("Source "+source +" Parent "+parent+ " ch "+ch);
            parent = source;
            if(findCycleInGraph( graph,visted, ch,parent)) return true;
            else if(ch != parent) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("-----------------Printing BFS of graph------------------");
        Map<Character,Boolean> visted = new HashMap<>();
        int noOfUnconnectedGraph= 0;
        { //BFS Program
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                visted.put((char) (i + 65), false);
            }
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                Character node = (char) (i + 65);
                if (visted.get(node)) continue;
                noOfUnconnectedGraph++;
                BFSPrinting(unDirectedGraph.getGraphObject(), visted, node);
            }
            System.out.println("\n-----------------Printing Number of cycle in BFS of graph------------------\n");
            System.out.println("No Of Unconnected Graph " + noOfUnconnectedGraph);
        }

        System.out.println("-----------------Printing DFS of graph------------------");
        {
            noOfUnconnectedGraph = 0;
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                visted.put((char) (i + 65), false);
            }
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                Character node = (char) (i + 65);
                if (visted.get(node)) continue;
                noOfUnconnectedGraph++;
                DFSPrinting(unDirectedGraph.getGraphObject(), visted, node);
            }
            System.out.println("\n-----------------Printing Number of cycle in DFS of graph------------------\n");
            System.out.println("No Of Unconnected Graph " + noOfUnconnectedGraph);
        }

        System.out.println("-----------------Printing the graph is contain cycle or not------------------");
        {
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                visted.put((char) (i + 65), false);
            }
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                Character node = (char) (i + 65);
                if (visted.get(node)) continue;
                noOfUnconnectedGraph++;
                boolean isCyclic = findCycleInGraph(unDirectedGraph.getGraphObject(), visted, node,node);
                System.out.println("is graph contain cycle : "+isCyclic);
            }

        }

        System.out.println("-----------------Printing BFS of graph List View------------------");
        ArrayList<ArrayList<Integer >> graphObj = unDirectedGraph.getGraphObj();
        System.out.println("graphObj "+graphObj);
        boolean vistedArray [] = new boolean[SIZE_OF_GRAPH];
        Arrays.fill(vistedArray,false);
        int noOfUnConnectedGraph = 0;
        { //BFS Program
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                if (vistedArray[i]) continue;
                noOfUnConnectedGraph++;
                printBFS(graphObj, vistedArray, i);
            }
            System.out.println("\n-----------------Printing Number of cycle in BFS List View of graph------------------\n");
            System.out.println("No Of noOfUnConnectedGraph Graph " + noOfUnConnectedGraph);
        }

        System.out.println("-----------------Printing DFS of graph in list------------------");
        {
            noOfUnConnectedGraph = 0;
            Arrays.fill(vistedArray,false);
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                if (vistedArray[i]) continue;
                noOfUnConnectedGraph++;
                printDFS(unDirectedGraph.getGraphObj(), vistedArray, i);
            }
            System.out.println("\n-----------------Printing Number of cycle in DFS of graph------------------\n");
            System.out.println("No Of noOfUnConnectedGraph Graph " + noOfUnConnectedGraph);
        }

        System.out.println("-----------------Printing degree of node in graph in list------------------");
        int degreeOfNode [] = new int[SIZE_OF_GRAPH];
        {
            Arrays.fill(vistedArray,false);
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                degreeOfNode[i]=findDegreeOfEachNode(unDirectedGraph.getGraphObj(), i) * 2;
            }
            System.out.println("\n-----------------Printing Number of cycle in DFS of graph------------------\n");
            Arrays.stream(degreeOfNode).forEach((i )->System.out.print(i+" "));
        }

    }

    private static void printDFS(ArrayList<ArrayList<Integer>> graphObj, boolean[] vistedArray, int i) {
        System.out.println();
        vistedArray[i] = true;
        System.out.print(i+" ");

        for ( int node : graphObj.get(i) ){
            if(vistedArray[node]) continue;
            printDFS(graphObj,vistedArray,node);
        }
    }
    private static void printBFS(ArrayList<ArrayList<Integer>> graphObj, boolean[] vistedArray, int i) {
        vistedArray[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        System.out.print(i+" ");
        while ( !queue.isEmpty() ){
            ArrayList<Integer> list = graphObj.get( queue.poll());
            for (int j = 0; j < list.size(); j++) {
                if( vistedArray[ list.get(j) ]) continue;
                queue.add( list.get(j) );
                System.out.print( list.get(j) +" ");
                vistedArray[list.get(j)] = true;
            }
        }
    }

    private static int findDegreeOfEachNode(ArrayList<ArrayList<Integer>> graphObj, int i) {
        int count =0;
        for ( int node : graphObj.get(i) ){
            count++;
        }
        return count;
    }
}
