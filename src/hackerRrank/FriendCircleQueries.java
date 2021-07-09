package hackerRrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
Sample Input 2

6
1 2
3 4
1 3
5 7
5 6
7 4
Sample Output 2

2
2
4
4
4
7
Explanation 2

Friend circles after each iteration:

1   [1,2]
2   [1,2],[3,4]
3   [1,2,3,4]
4   [1,2,3,4],[5,7]
5   [1,2,3,4],[5,7,6]
6   [1,2,3,4,5,6,7]
 */
public class FriendCircleQueries {

    static  HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String args[])throws IOException {
       /* int maxCircle[][]=new int[6][6];
        maxCircle[0][0]=1;
        maxCircle[0][1]=2;
        maxCircle[1][0]=3;
        maxCircle[1][1]=4;
        maxCircle[2][0]=1;
        maxCircle[2][1]=3;
        maxCircle[3][0]=5;
        maxCircle[3][1]=7;
        maxCircle[4][0]=5;
        maxCircle[4][1]=6;
        maxCircle[5][0]=7;
        maxCircle[5][1]=4;*/
        /*maxCircle[0][0]=1000000000 ;
        maxCircle[0][1]=23;
        maxCircle[1][0]=11 ;
        maxCircle[1][1]=3778;
        maxCircle[2][0]=7;
        maxCircle[2][1]=47;
        maxCircle[3][0]=11;
        maxCircle[3][1]=1000000000;*/
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] queries = new int[q][2];

            for (int i = 0; i < q; i++) {
                String[] queriesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int queriesItem = Integer.parseInt(queriesRowItems[j]);
                    queries[i][j] = queriesItem;
                }
            }

            int[] ans = maxCircle(queries);

            for (int i = 0; i < ans.length; i++) {
                bufferedWriter.write(String.valueOf(ans[i]));

                if (i != ans.length - 1) {
                    bufferedWriter.write("\n");
                }
            }

            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
        //maxCircle(maxCircle);

    static int[] maxCircle(int[][] queries) {
        int max=0;
        int output[]=new int[queries.length];
        int k=0;
        for(int i=0;i<queries.length;i++){
            String a = String.valueOf(queries[i][0]);
            String b = String.valueOf(queries[i][1]);
            System.out.println("a : "+a +" ,b : "+b);
            int temp1 = exist(a);
            int temp2 = exist(b);
            if(temp1 == -1 & temp2  == -1){
                String temp=a+","+b;
                map.put(k++,temp); //k=0
                if(temp.split(",").length>max){
                    max=temp.split(",").length;
                }
            }else if(temp1 !=-1 & temp2 == -1){
                String temp=map.get(temp1);
                temp=temp+","+b;
                map.put(temp1,temp);
                if(temp.split(",").length>max){
                    max=temp.split(",").length;
                }
            }else if(temp1 == -1 & temp2 != -1){
                String temp=map.get(temp2);
                temp = temp+","+a;
                map.put(temp2,temp);
                if(temp.split(",").length>max){
                    max=temp.split(",").length;
                }

            }else if(temp1 !=-1 & temp2 != -1){
                String x=map.get(temp1);
                String y=map.get(temp2);
                map.put(temp1,null);
                map.put(temp2,null);
                String temp=x+","+y;
                map.put(k++,temp);
                if(temp.split(",").length>max){
                    max=temp.split(",").length;;
                }
            }
            output[i]=max;
            System.out.println("a : "+a +" ,b : "+b+" ,max ; "+max+ " its temp value : "+temp1+""+temp2);

        }
        return output;
    }

    static int exist(String i){
        int mapLength=map.size();
        System.out.println(mapLength );
        for(int j=0;j<mapLength;j++){
            System.out.println("Map : "+ map.get(j));
            if(map.get(j)!=null){
                String temps[] = map.get(j).split(",");
                for(int l=0;l< temps.length;l++){
                    if(temps[l] !=null ){
                        if(temps[l].equalsIgnoreCase(i))
                            return j;
                    }
                }
            }


        }
    return -1;
    }
}
