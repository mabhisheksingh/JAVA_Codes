package graph;

import java.util.*;

/*
 * Directed non-weighted graph
 *  A-->B<--C---->D
 *          ^   ^ |
 *          |  /  |
 *          | /   v
 *          F<----E
 *
 * */
public class ImplementDirectedGraph {
    private final static int SIZE_OF_GRAPH = 6;
    static NonWeightedGraph unDirectedGraph = new NonWeightedGraph(SIZE_OF_GRAPH);
    static{
        unDirectedGraph.addEdge('A','B');
        unDirectedGraph.addEdge('C','B');

        unDirectedGraph.addEdge('C','D');
        unDirectedGraph.addEdge('D','E');
        unDirectedGraph.addEdge('E','F');

        unDirectedGraph.addEdge('F','C');
        unDirectedGraph.addEdge('F','D');

        unDirectedGraph.addEdge(0,1);
        unDirectedGraph.addEdge(1,-1);
        unDirectedGraph.addEdge(2,1);

        unDirectedGraph.addEdge(2,3);
        unDirectedGraph.addEdge(3,4);
        unDirectedGraph.addEdge(4,5);

        unDirectedGraph.addEdge(5,2);
        unDirectedGraph.addEdge(5,3);
    }
    public static boolean findCycleInGraph(Map<Character, ArrayList<Character>> graph, Map<Character,Boolean> visted , Character source,
                                           Map<Character,Boolean> stack){
        visted.put(source,true);
        stack.put(source,true);
        for (Character ch : graph.get(source)) {
            //System.out.println("Source "+source +" ch "+ch +" stack "+stack);
            if( visted.get(ch)==false && findCycleInGraph(graph,visted,ch,stack)) return true;
            else if( stack.get(ch)) return true;
        }
        stack.put(source,false);
        return false;
    }
    public static boolean findCycleInGraph( ArrayList< ArrayList < Integer > > graph ,  Map< Integer , Boolean > visted , int source,
                                            Map< Integer ,Boolean > stack){
        visted.put(source,true);
        stack.put(source,true);
        ArrayList<Integer> list = graph.get(source);
        for (int i = 0; i < list.size() ; i++) {
            if(visted.get( list.get(i) ) == false &&  findCycleInGraph(graph , visted , list.get(i) , stack) ) return true;
            else if( stack.get(list.get(i))) return true;
        }
        stack.put(source,false);
    return false;
    }
    public static void printGraph(Map< Character, ArrayList< Character >> graphData){
        System.out.println("\n----------------------Printing graph-----------------------------\n");
        for (Map.Entry<Character,ArrayList<Character>> graph : graphData.entrySet()){
            System.out.println("Key "+graph.getKey()+" Values "+graph.getValue());
        }
        System.out.println();
    }
    public static void printGraph(ArrayList<ArrayList< Integer >> graphData){
        System.out.println("\n----------------------Printing graph-----------------------------\n");
        for (List<Integer> list : graphData){
            System.out.println("data "+list);
        }
        System.out.println();
    }
    private static int findOutDegreeOfEachNode(ArrayList<ArrayList<Integer>> graphObj, int i) {
        int count =0;
        for ( int node : graphObj.get(i) ){
            count++;
        }
        return count;
    }
    private static void findInDegreeOfEachNode(ArrayList<ArrayList<Integer>> graphObj, int i,HashMap<Integer,Integer> degree) {
        for ( int node : graphObj.get(i) ){
           if( degree.containsKey(node)){
               degree.put( node , degree.get(node)+1 );
           }else
               degree.put(node ,1);
        }
    }

    public static void topologicalSorting(ArrayList< ArrayList< Integer >> graph , HashMap<Integer , Integer> degreeOfNode,Map<Integer,Boolean> vistedArray) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println();
        //System.out.println("degree "+degreeOfNode);
        //System.out.println();
        for (int i = 0; i < degreeOfNode.size(); i++){
            if( !vistedArray.get(i) && degreeOfNode.get(i) == 0) {
                queue.add(i);
                vistedArray.put(i,true);
            }
        }
        while ( !queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex+" ");
            for (Map.Entry<Integer,Integer> entry : degreeOfNode.entrySet()) {
                degreeOfNode.put( entry.getKey() , entry.getValue()-1);
                if(  degreeOfNode.get(entry.getKey()) == 0) queue.add(entry.getKey());
            }
        }

    }

    public static void main(String[] args) {
        printGraph(unDirectedGraph.getGraphObject());
        Map<Character,Boolean> visted = new HashMap<>();
        Map<Character,Boolean> stack = new HashMap<>();
        int noOfUnconnectedGraph= 0;
        System.out.println("-----------------Printing the graph is contain cycle or not------------------");
        {
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                visted.put((char) (i + 65), false);
            }
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                Character node = (char) (i + 65);
                if (visted.get(node)) continue;
                noOfUnconnectedGraph++;
                boolean isCyclic = findCycleInGraph( unDirectedGraph.getGraphObject(), visted , node , stack);
                System.out.println("Is graph contain cycle : "+isCyclic);
            }

        }

        System.out.println("-----------------Printing the graph is contain cycle or not in list------------------");
        printGraph(unDirectedGraph.getGraphObj());
        Map<Integer,Boolean> vistedArray = new HashMap<>();
        Map<Integer,Boolean> stackInteger = new HashMap<>();
        for (int i = 0; i < SIZE_OF_GRAPH; i++) {
            vistedArray.put(i, false);
        }
        int noOfUncConnectedGraph= 0;
        {
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                if (vistedArray.get(i)) continue;
                noOfUncConnectedGraph++;
                boolean isCyclic = findCycleInGraph(unDirectedGraph.getGraphObj(), vistedArray , i , stackInteger);
                System.out.println("Is graph contain cycle List : "+isCyclic);
            }

        }


        HashMap<Integer,Integer> outDegreeOfNode = new HashMap<>();
        HashMap<Integer,Integer> inDegreeOfNode = new HashMap<>();
        for (int i = 0; i < SIZE_OF_GRAPH; i++) inDegreeOfNode.put(i,0);
        System.out.println("\n-----------------Printing degree of the graph------------------\n");
        {
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                vistedArray.put(i, false);
            }
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                if (vistedArray.get( i )) continue;
                noOfUnconnectedGraph++;
                int degree = findOutDegreeOfEachNode( unDirectedGraph.getGraphObj() , i );
                findInDegreeOfEachNode( unDirectedGraph.getGraphObj() , i , inDegreeOfNode );
               // System.out.println("degree of graph : "+degree);

                outDegreeOfNode.put(i, degree);
            }
        }
        System.out.println("Degree of out coming each node"+ outDegreeOfNode);
        System.out.println("Degree of in coming each node"+ inDegreeOfNode);

        System.out.println("\n-----------------Printing Topological Sorting of the graph------------------\n");
        for (int i = 0; i < SIZE_OF_GRAPH; i++) vistedArray.put(i,false);
        for (int i = 0; i < SIZE_OF_GRAPH; i++) {
            if( vistedArray.get(i)) continue;
            topologicalSorting(unDirectedGraph.getGraphObj() , inDegreeOfNode ,  vistedArray );
        }

    }
}
