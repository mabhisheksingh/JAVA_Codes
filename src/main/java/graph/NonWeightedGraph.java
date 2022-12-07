package graph;

import java.util.*;

/*
* Undirected non-weighted graph
* */


public class NonWeightedGraph implements Graph {
    private static Map<Character, ArrayList<Character>> graphObject ; //char graph object
    private static ArrayList<ArrayList<Integer>> graphObj ;

    public NonWeightedGraph(int vertex){
        graphObject = new HashMap<>();
        for (int i = 0; i < vertex; i++) {
            graphObject.put( (char)(i+65), new ArrayList<>());
        }

        graphObj = new ArrayList<>(vertex);
    }

    @Override
    public boolean addEdge(Character source ,Character destination ){
        //A --- B
        if(graphObject.containsKey(source) && graphObject.containsKey(destination)) {
            graphObject.get(source).add(destination);
//            graphObject.get(destination).add(source);
            return true;
        }
        return false;

    }
    @Override
    public boolean addVertex(int Count) {
       int currentSize = graphObject.size();
        for (int i = 1; i <= Count; i++) {
            graphObject.put( (char)(i+65+currentSize), new ArrayList<>());
        }
        return true;
    }

    @Override
    public Map<Character, ArrayList<Character>> getGraphObject() {
        return graphObject;
    }

    @Override
    public ArrayList<ArrayList<Integer>> getGraphObj() {
        return graphObj;
    }

    @Override
    public boolean addEdge(Integer source ,Integer destination ){
        //A --- B
        //System.out.println("Size : "+graphObj.size() + "Source " + source+ " "+ destination);
        if( source >= graphObj.size()){
            //not connecting to any node
            ArrayList<Integer> list = new ArrayList<>(1);
            if( destination != -1) {
                list.add(destination);
            }
            graphObj.add(list);
            return true;
        }
        graphObj.get(source).add(destination);
        return true;

    }

}
