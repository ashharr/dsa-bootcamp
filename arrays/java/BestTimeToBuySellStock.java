package arrays.java;

import java.lang.Math;

class BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {
        int low = prices[0], maxProfit = 0;
		for(int i = 1; i < prices.length ; i++) {
			if(prices[i] < low) low = prices[i];
			int temp = prices[i] - low;
			maxProfit = Math.max(maxProfit, temp);
		}
		return maxProfit;
    }
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
		
	}
}
