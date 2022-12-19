package graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class WeightGraph {
    private int vertex;
    private int weight;
}

public class WeightedGraph implements WeightedGraphInterface{
    private static ArrayList<ArrayList<WeightGraph>> graph ;
    WeightedGraph(int size){
        graph = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            graph.add(i,new ArrayList<>());
        }
    }

    public static ArrayList<ArrayList<WeightedGraph>> get;

    @Override
    public boolean addVertex(int Count) {
        graph = new ArrayList<>(Count);
        return true;
    }

    @Override
    public ArrayList<ArrayList<WeightGraph>> getGraphObj() {
        return graph;
    }

    @Override
    public boolean addEdge(Integer source, Integer destination, Integer weight) {
        graph.get(source).add( new WeightGraph(destination,weight));
        return true;
    }
}
