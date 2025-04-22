import java.util.*;
import java.io.*;

class Solution {
    
    static class Product {
        int A;
        int B;
        
        public Product(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
    
    static int min;
    static Product[] products;
    
    public int solution(int[][] info, int n, int m) {
        products = new Product[info.length];
        
        int sumA = 0;
        int sumB = 0;
        
        for(int i = 0; i < info.length; i++) {
            products[i] = new Product(info[i][0], info[i][1]);
            sumA += info[i][0];
            sumB += info[i][1];
        }
        
        // if(sumB < m) return 0;
        // if(m <= 1) {
        //     if(sumA >= n) return -1;
        //     else return sumA;
        // }
        
        Arrays.sort(products, (a, b) -> a.A == b.A ? b.B - a.B : b.A - a.A);
        
        min = Integer.MAX_VALUE;
        int canA = 0;
        int canB = 0;
        
        comb(0, canA, canB, n, m);
        
        if(min == Integer.MAX_VALUE) return -1;
        
        return min;
    }
    
    public static void comb(int idx, int canA, int canB, int n, int m) {            
        if(canA >= n || canB >= m || min < canA) return; //못하는 조합경우
        
        if(idx >= products.length) {            
            min = Math.min(min, canA);
            return;
        }
        
        comb(idx + 1, canA, canB + products[idx].B, n, m);
        comb(idx + 1, canA + products[idx].A, canB, n, m);
        
    }
}