package com.company.blind75.arrays;

public class BuyAndSellStock {


    public static void main(String[] args){

        int[] prices = {7, 1, 5, 3, 6, 10};


        System.out.println("Max"+maxProfit(prices));
        System.out.println("Max"+maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println("Max"+maxProfit(new int[]{7,6,4,3,1}));   // 0
        System.out.println("Max"+maxProfit(new int[]{1,2}));         // 1
        System.out.println("Max"+maxProfit(new int[]{2,4,1}));       // 2

    }

    /**
     * Time Complexity o(n)
     * Space Compelxity 0(1)
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){


        if(prices.length==0){
            return 0;
        }
        int minPrice = prices[0];

        int maxProfit=0;


        for( int i =1 ;i < prices.length;i++){
            minPrice = Math.min(minPrice,prices[i] );
            maxProfit = Math.max(maxProfit, (prices[i]- minPrice));

        }

        return maxProfit;


    }
}
