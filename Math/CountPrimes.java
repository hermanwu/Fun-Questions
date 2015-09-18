package Math;

import java.util.Arrays;

/**
 Source: https://leetcode.com/problems/count-primes/

 Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        // corner case
        if(n<=1){
            return 0;
        }
        // initiate array
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        for(int i=2; i*i<n; i++){
            if(primes[i] == false){
                continue;
            }
            for(int j=i+i; j<n; j+=i){
                primes[j] = false;
            }
        }

        int count = 0;
        for(int i=2; i<n; i++){
            if(primes[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        CountPrimes test = new CountPrimes();
        int result = test.countPrimes(6);
    }
}
