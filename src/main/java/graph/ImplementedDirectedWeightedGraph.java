package graph;
import java.util.*;

import static javax.swing.text.StyleConstants.Size;
/*
*   0--[2]---->1--[3]-->2----[6]-->3
    \         ^                   ^
*  [1]       /                  /
*    \   [2]                  [1]
*     V /                    /
*      4-----------[4]----->5
*
 *
 * */

public class ImplementedDirectedWeightedGraph {

    private static ArrayList<ArrayList<WeightGraph>> graph ;
    private static final int SIZE_OF_GRAPH = 6 ;
    private static void loadGraph(WeightedGraph temp) {
        temp.addEdge(0,1,2);
        temp.addEdge(0,4,1);
        temp.addEdge(1,2,3);
        temp.addEdge(2,3,6);
        temp.addEdge(4,2,2);
        temp.addEdge(4,5,4);
        temp.addEdge(5,3,1);
    }
    private static void findInDegreeOfEachNode(ArrayList<ArrayList<WeightGraph>> graphObj, int source, Map<Integer,Integer> degree) {
        List<WeightGraph> list = graphObj.get( source );
        for ( WeightGraph weight : list){
            degree.put(weight.getVertex() , degree.get( weight.getVertex())+1 );
        }
    }

    private static void shortestPathInDAG(Map<Integer, Integer> topologicalSortingOfGraph, int source,
                                          Map<Integer,Integer> inDegreeOfNode , Map<Integer,Integer> pathFromSource){
        pathFromSource.put(source,0);

        for( Map.Entry<Integer,Integer> entry :  topologicalSortingOfGraph
                .entrySet()){
            List<WeightGraph> list = graph.get(entry.getKey());

            for (int i = 0; i < list.size(); i++) {
                WeightGraph weightGraph =  list.get(i);

                if( pathFromSource.get(weightGraph.getVertex()) > pathFromSource.get( entry.getKey() ) + weightGraph.getWeight() ){
                    pathFromSource.put( weightGraph.getVertex() , pathFromSource.get( entry.getKey() ) + weightGraph.getWeight());
                }
            }
        }
    }

    public static void main(String[] args) {
        WeightedGraph temp = new WeightedGraph(6);
        graph = temp.getGraphObj();
        loadGraph(temp);
        System.out.println("\n-----------------Printing Weighted graph------------------\n");
        for (int i = 0; i < SIZE_OF_GRAPH; i++)System.out.println("Index "+i+" "+graph.get(i));
        Map<Integer, Integer> inDegreeOfNode = new LinkedHashMap<>();
        Map<Integer, Boolean> vistedArray = new LinkedHashMap<>();
        Map<Integer, Integer> pathFromSource = new LinkedHashMap<>();
        for (int i = 0; i < SIZE_OF_GRAPH; i++) vistedArray.put(i,false);
        for (int i = 0; i < SIZE_OF_GRAPH; i++) inDegreeOfNode.put(i,0);
        for (int i = 0; i < SIZE_OF_GRAPH; i++) pathFromSource.put(i,Integer.MAX_VALUE);
        System.out.println("\n-----------------Printing In degree of graph------------------\n");
        {
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                if ( vistedArray.get(i) ) continue;
                findInDegreeOfEachNode(graph, i,inDegreeOfNode );
            }
            System.out.println("In degree : "+ inDegreeOfNode);
        }
        Map<Integer, Integer> topologicalSortingOfGraph = new LinkedHashMap<Integer, Integer>();
        System.out.println("\n-----------------Printing shortestPathInDAG graph------------------\n");
        {
            for (int i = 0; i < SIZE_OF_GRAPH; i++) vistedArray.put(i,false);
            for (int i = 0; i < SIZE_OF_GRAPH; i++) pathFromSource.put(i,Integer.MAX_VALUE- 10);
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                if(vistedArray.get(i)) continue;
                getTopologicalSorting( graph, inDegreeOfNode,vistedArray,topologicalSortingOfGraph );
            }
            for (int i = 0; i < SIZE_OF_GRAPH; i++) vistedArray.put(i,false);
            for (int i = 0; i < SIZE_OF_GRAPH; i++) inDegreeOfNode.put(i,0);
            for (int i = 0; i < SIZE_OF_GRAPH; i++) {
                if ( vistedArray.get(i) ) continue;
                findInDegreeOfEachNode( graph , i , inDegreeOfNode );
            }
            for (int i = 0; i < SIZE_OF_GRAPH; i++) vistedArray.put(i,false);
//            System.out.println(topologicalSortingOfGraph);
            int source = 0;
            shortestPathInDAG(topologicalSortingOfGraph,source,inDegreeOfNode,pathFromSource );
            System.out.println("TOP Sortng "+ pathFromSource);

        }
    }

    private static void getTopologicalSorting(ArrayList<ArrayList<WeightGraph>> graph, Map<Integer, Integer> inDegreeOfNode,
                                               Map<Integer, Boolean> vistedArray,Map<Integer, Integer> topologicalSorting) {

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < SIZE_OF_GRAPH; i++) {
            if(  !vistedArray.get(i) && inDegreeOfNode.get(i) == 0) {
                queue.add(i);
                vistedArray.put(i,true);
            }
        }
        while (!queue.isEmpty()){
            int number  = queue.poll();
            topologicalSorting.put(number,number);
            for (Map.Entry<Integer,Integer> entry : inDegreeOfNode.entrySet()) {
                inDegreeOfNode.put( entry.getKey(),entry.getValue()-1);
                if( inDegreeOfNode.get(entry.getKey()) ==0 ) queue.add( entry.getKey());
            }
        }
    }

}
