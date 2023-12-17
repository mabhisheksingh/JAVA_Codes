package leetcode.dp.medium;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import utils.arrays.MyArrayUtils;

import java.util.*;

/*Dijkstra algorithm */
public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
//        int n = 7;
//        int[][] roads = {{0,6,7},{0,1,2},{0,4,5},{1,2,3},{1,3,3},{2,5,1},{3,5,1},{6,3,3},{6,5,1},{4,6,2}};int n = 7;
        int n = 12;
        int[][] roads = {{1,0,2348},{2,1,2852},{2,0,5200},{3,1,12480},{2,3,9628},{4,3,7367},{4,0,22195},{5,4,5668},{1,5,25515},{0,5,27863},{6,5,836},{6,0,28699},{2,6,23499},{6,3,13871},{1,6,26351},{5,7,6229},{2,7,28892},{1,7,31744},{3,7,19264},{6,7,5393},{2,8,31998},{8,7,3106},{3,8,22370},{8,4,15003},{8,6,8499},{8,5,9335},{8,9,5258},{9,2,37256},{3,9,27628},{7,9,8364},{1,9,40108},{9,5,14593},{2,10,45922},{5,10,23259},{9,10,8666},{10,0,51122},{10,3,36294},{10,4,28927},{11,4,25190},{11,9,4929},{11,8,10187},{11,6,18686},{2,11,42185},{11,3,32557},{1,11,45037}};
        System.out.println( countPaths(n, roads));

    }
    private static int countPaths(int n, int[][] roads) {
        int MOD = (int )1e9 + 7;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int arr[] : roads) graph.get( arr[0] ).add( new Edge(arr[1],arr[2]));
        for (int arr[] : roads) graph.get( arr[1] ).add(new Edge(arr[0],arr[2]) );
        for (int i = 0; i < n; i++) {
            System.out.println("Key "+i+"val : "+graph.get(i));

        }
        System.out.println("0000000000000000000000000");

        PriorityQueue<Edge> pq = new PriorityQueue<>(  (edge1, edge2) -> Long.compare( edge1.getDistance() , edge2.getDistance()) );
//        for (int i = 0; i < n; i++) {
//            if(i == 0)
//                pq.add( Edge.builder().node(0).distance(0).build());
//            pq.add(Edge.builder().node(0).distance(Integer.MAX_VALUE/2).build() );
//        }
//        Queue<Integer> q= new LinkedList<>();
//        q.add( 0  );
        pq.add( new Edge(0,0 ));
        long [] distance = new long[n];
        long [] ways = new long[n];
        Arrays.fill( distance, Long.MAX_VALUE );
        distance[0] = 0;
        ways[0] = 1;
        // System.out.println("GRAPH "+ graph);
        // System.out.println("pq "+ pq);
//        System.out.println("q "+ q);
        // new MyArrayUtils().print1DArray( distance, "distance ");
        // new MyArrayUtils().print1DArray( ways, "ways ");
        System.out.println("***************************");
        while ( !pq.isEmpty() ){
            Edge edge  = pq.poll();
            long edgeDist = edge.getDistance();
            int node = edge.getNode();
            System.out.println("node "+node);
            System.out.println("graph val  "+graph.get(node));
            for (Edge edges : graph.get(node) ) {
//                q.add(edges.getNode());
                if( distance [ (int)edges.getNode() ] > edgeDist + edges.getDistance() ){
//                    if( pq.contains( Edge.builder().node(edges.getNode()).distance( edges.getDistance()).build()))
//                        pq.remove( Edge.builder().node(edges.getNode()).distance( edges.getDistance() ).build() );

                    distance[(int)edges.getNode() ] = edgeDist + edges.getDistance();
                    pq.add( new Edge( edges.getNode() , distance[(int)edges.getNode()   ] ) );
                    ways[ edges.getNode() ]= ways[ node ];
                }else if( distance [ edges.getNode() ] == edgeDist + edges.getDistance() ){
                    ways[ (int)edges.getNode() ]= (int )(ways[ node] % MOD + ways[ edges.getNode() ] ) % MOD ;
                }

            }
            // MyArrayUtils.printing1DArray( distance, "distance after relax "+node+ " dp peek "+pq.peek() + " PD size  "+pq.size()+ " pQ "+pq);
            // MyArrayUtils.printing1DArray( ways, "distance after relax "+node);
        }

        System.out.println("---------------------");
        System.out.println("GRAPH "+ graph);
        System.out.println("pq "+ pq);
//        System.out.println("q "+ q);
        // MyArrayUtils.printing1DArray( distance, "distance ");
        // MyArrayUtils.printing1DArray( ways, "ways ");
        return (int) (ways[n-1] % MOD);
    }
}


//@Builder
class Edge{
    private int node;
    private long distance;

    public Edge() {
    }

    public Edge(int node, long distance) {
        this.node = node;
        this.distance = distance;
    }

    public int getNode() {
        return node;
    }

    public long getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node=" + node +
                ", distance=" + distance +
                '}';
    }
}
