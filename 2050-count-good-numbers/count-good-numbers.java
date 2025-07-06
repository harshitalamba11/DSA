class Solution {
    final int MOD = 1_000_000_007;
    // public long power(long base, long exp) {
        
    // long result = 1;
    // base %= MOD;
    // while (exp > 0) {
    //     if ((exp & 1) == 1) result = (result * base) % MOD;   // & means %
    //     base = (base * base) % MOD;
    //     exp >>= 1;
    // }
    // return result;
    // }

    public int countGoodNumbers(long n) {
        
        long evenPos = (n + 1) / 2;  // positions 0, 2, 4, ...
        long oddPos = n / 2;         // positions 1, 3, 5, ...
        long a=power(5,evenPos);
        long b=power(4,oddPos);
        return (int)(a*b%MOD);
    }
    public long power(long base,long exp){
        long result=1;
        base %= MOD;
        while(exp>0){
            if((exp&1)==1){
                result = (result * base) % MOD;
            }
            base=base*base%MOD;
             exp >>= 1;
        }
        return result;
    }
}