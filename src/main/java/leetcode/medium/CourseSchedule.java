package leetcode.medium;

import java.util.*;
import java.util.function.Function;

public class CourseSchedule {

    public static void main(String[] args) {
//        int numCourses = 7;
//        int numCourses = 2;
//        int [][] prerequisites = {{1,0},{0,1}};
//        int [][] prerequisites = {{1,0},{1,2},{1,4},{2,3},{3,0},{4,3},{5,6} , { 0,2}};
        int numCourses = 20;
        int [][] prerequisites = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1} ,{15,1},{17,4}};
        boolean output = new CourseSchedule().canFinish( numCourses , prerequisites );
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Boolean>  isVisited = new HashMap<>();
        boolean [] stackVisited = new boolean[numCourses];

        Map< Integer, List<Integer>> graph = new HashMap<>();
        for(int i =0;i<= numCourses ;i++){
            isVisited.put( i ,false);
        }
        for(int [] row :  prerequisites) {
            graph.computeIfAbsent(row[0], k -> new ArrayList<>()).add(row[1]);
        }
        System.out.println("GRAPH "+ graph);
        System.out.println("IsVisited "+ isVisited);
        Map<Integer, Integer > inDegree = getInOderDegree(graph);
        System.out.println("Indegree "+inDegree);
        for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet() ){
            if( !isVisited.get( entry.getKey() ) ){ //if it is false
                System.out.println("OUTPUT "+ canFinishBFS( graph, entry.getKey(), isVisited,inDegree ,numCourses) );
            }
        }
        return true;
    }



    public boolean canFinishBFS(Map< Integer, List<Integer>> graph ,  int source ,Map<Integer,Boolean> isVisited, Map<Integer, Integer > inDegree , int numCourses){
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int topologicalSortCount = 0;

        for(int i =0 ; i < numCourses ; i++){
            if( !isVisited.get(i) && inDegree.getOrDefault(i,0) == 0){
                isVisited.put(i,true);
                queue.add(i);
                topologicalSortCount++;
                linkedList.add(i);
            }
        }

        while (!queue.isEmpty()){
            int visiting = queue.poll();
            isVisited.put(visiting,true);
            if( graph.containsKey(visiting) ) {
                for( int node : graph.get(visiting) ){
                    inDegree.put( node , inDegree.get( node ) - 1 );
                    if( !isVisited.get(node) && inDegree.getOrDefault(node, 0) == 0){
                        queue.add(node);
                        topologicalSortCount++;
                        linkedList.add(node);
                    }
                }
            }
        }
        System.out.println("TPS : "+topologicalSortCount);
        System.out.println("Sorting : "+linkedList);
        if(topologicalSortCount == numCourses) return true;
        return false;
    }

    public Map<Integer,Integer> getInOderDegree(Map< Integer, List<Integer>> graph ){
        Map< Integer, Integer> degree = new HashMap<>();
        for( Map.Entry<Integer, List<Integer>> node : graph.entrySet()){
            for(int i : node.getValue()){
                degree.put( i , 1 + degree.getOrDefault(i,0 ) );
            }
        }
        return degree;
    }
}
