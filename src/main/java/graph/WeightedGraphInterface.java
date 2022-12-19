package graph;

import java.util.ArrayList;
import java.util.Map;

public interface WeightedGraphInterface {
    public boolean addVertex(int Count);
    public ArrayList<ArrayList<WeightGraph>> getGraphObj();
    public boolean addEdge(Integer source ,Integer destination, Integer weight );
}
