package leetcode.medium;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
The classical Sieve of Eratosthenes algorithm takes O(N log (log N)) time to find all prime numbers less than N.
In this article, a modified Sieve is discussed that works in O(N) time.
Example :
Given a number N, print all prime
numbers smaller than N

Input :  int N = 15
Output : 2 3 5 7 11 13

Input : int N = 20
Output : 2 3 5 7 11 13 17 19
* */
public class SieveOfEratosthenes {

    static final int MAX_SIZE = 1000001;
    // isPrime[] : isPrime[i] is true if number is prime
    // prime[] : stores all prime number less than N
    // SPF[] that store smallest prime factor of number
    // [for Exp : smallest prime factor of '8' and '16'
    // is '2' so we put SPF[8] = 2 , SPF[16] = 2 ]
    static Vector<Boolean>isprime = new Vector<>(MAX_SIZE);
    static Vector<Integer>prime = new Vector<>();
    static List<Integer> SPF = new ArrayList<>(MAX_SIZE);
    public static void main(String[] args) {
        int N = 499979 ; // Must be less than MAX_SIZE

        // initializing isprime and spf
        for (int i = 0; i < MAX_SIZE; i++){
            isprime.add(true);
            SPF.add(2);
        }

        Instant cur = Instant.now();
        manipulated_seive(N);
        Instant newcur = Instant.now();
        System.out.println("Time "+ (newcur.getNano() - cur.getNano())/1000000 );

        // pint all prime number less then N
        //for (int i=0; i<prime.size() && prime.get(i) <= N ; i++)
            //System.out.print(prime.get(i) + " ");
    }



    // method generate all prime number less then N in O(n)
    static void manipulated_seive(int N){
        System.out.println("Size : "+SPF.size());
        // 0 and 1 are not prime
        isprime.set(0, false);
        isprime.set(1, false);

        // Fill rest of the entries
        for (int i=2; i<N && i<5 ; i++)
        {
            // If isPrime[i] == True then i is
            // prime number
            if (isprime.get(i)){
                //System.out.println(i+" Size "+ prime.size());
                // put i into prime[] vector
                prime.add(i);

                // A prime number is its own smallest
                // prime factor
                SPF.set(i,i);
            }

            // Remove all multiples of  i*prime[j] which are
            // not prime by making isPrime[i*prime[j]] = false
            // and put smallest prime factor of i*Prime[j] as prime[j]
            // [for exp :let  i = 5, j = 0, prime[j] = 2 [ i*prime[j] = 10]
            // so smallest prime factor of '10' is '2' that is prime[j] ]
            // this loop run only one time for number which are not prime
            //System.out.println(i+" Siz#e "+ prime.size());
            for (int j=0;j < prime.size() &&i*prime.get(j) < N && prime.get(j) <= SPF.get(i);j++){
                isprime.set(i*prime.get(j),false);

                // put smallest prime factor of i*prime[j]
                SPF.set(i*prime.get(j),prime.get(j)) ;
            }
        }
    }

}
