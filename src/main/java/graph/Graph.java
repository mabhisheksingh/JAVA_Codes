package graph;

import java.util.ArrayList;
import java.util.Map;

public interface Graph{
    public boolean addEdge(Character source ,Character destination );
    public boolean addVertex(int Count);
    public Map<Character, ArrayList<Character>> getGraphObject();
    public ArrayList<ArrayList<Integer>> getGraphObj();
    public boolean addEdge(Integer source ,Integer destination );
}