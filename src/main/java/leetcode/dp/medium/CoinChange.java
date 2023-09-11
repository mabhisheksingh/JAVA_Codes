package leetcode.dp.medium;

public class CoinChange {

    int [][] memo= new int [4][12];

    public static void main(String[] args) {

        int [] coins = {1,2,5};int amount = 11;
//        int [] coins = {2};int amount = 3;
//        int [] coins = {1};int amount = 0;
//        int [] coins = {411,412,413,414,415,416,417,418,419,420,421,422};int amount = 9864;
        int output = new CoinChange().coinChange(coins, amount);
        System.out.println("Output "+ output);
    }

    public int coinChange(int[] coins, int amount) {
        long start = System.currentTimeMillis();

        if( amount == 0) return 0;
        int count = coinChangeDP(coins, amount, 0, 0);
        int count1 = coinChange(coins, amount, 0, 0);

        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("COUNT "+count+ " TIME "+ elapsedTime+ " count 1: "+ count1);
        printMatrix(memo);
        if( count == Integer.MAX_VALUE) return -1;
        return count;
    }

    public int coinChange(int[] coins, int amount,int minCoinChange, int position) {
        if(amount == 0){
            return minCoinChange;
        }
        if(position == coins.length || amount < 0 ){
           return Integer.MAX_VALUE;
        }

        return  Math.min( coinChange(coins, amount-coins[position], minCoinChange+1, position), coinChange(coins, amount, minCoinChange, position+1) );

    }

    public int coinChangeDP(int[] coins, int amount,int minCoinChange, int position) {


        if (amount == 0) {
            return minCoinChange;
        }
        if (position == coins.length || amount < 0) {
            return Integer.MAX_VALUE;
        }
        int a ;
        int b ;
        if ( (amount - coins[position]) >= 0 && memo[position][amount - coins[position]] == 0){
            a = coinChangeDP(coins, amount - coins[position], minCoinChange + 1, position);
            memo[position][amount - coins[position]] = a;
        }else if ( amount - coins[position] < 0){
            a = Integer.MAX_VALUE;
        }else{
            a = memo[position][amount - coins[position]];
        }
        if ( position + 1 < coins.length && memo[position + 1][amount] == 0){
            b = coinChangeDP(coins, amount , minCoinChange, position + 1);
            memo[position + 1][amount ] = b;
        }else {
            b = memo[position + 1 ][amount ];
        }

        return  Math.min(a,b );

    }

    public void printMatrix(int [][]matrix){
        System.out.println("\n****** printing start********");
        for (int [] row : matrix){
            for( int item : row){
                System.out.print(item+" ");
            }
            System.out.println("");
        }
        System.out.println("\n****** printing End********");
    }
}
