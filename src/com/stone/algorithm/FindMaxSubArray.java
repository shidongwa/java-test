package com.stone.algorithm;

/**
 * find the max summary of the sub array, including the position
 */
public class FindMaxSubArray {
	
	private static int[] intArray = new int[]{1,-2,3,10,-4,7,2,-5};
	
	private int maxSubSum;  // the maximum summary of sub array
	
	private int upper; // the upper array position of result
	
	private int lower; //the lower array position of result

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMaxSubArray finder = new FindMaxSubArray();
		
		finder.maxSumOfSubArrary();
		
		System.out.println("max sub summary is:" + finder.maxSubSum + " lower = " + finder.lower + " upper = " + finder.upper);
	}
	
	
	/**
	 * function to do the finding. mylower and myupper are possible sub array during iterating the array
	 */
	public void maxSumOfSubArrary(){

	    maxSubSum = intArray[0];

	    int curMax = 0;
	    
	    int mylower = 0;
	    int myupper = 0;
	  
	    int length = intArray.length;
	    for(int i=0; i<length; i++){

	       if(curMax>=0){
	    	   curMax += intArray[i];
	    	   myupper = i;
	       }else{
	    	   curMax = intArray[i];
		       mylower = i;	    		   
	       }

	       if(maxSubSum < curMax){
	    	   maxSubSum = curMax;
	    	   lower = mylower;
	    	   upper = myupper;
	       }
	  }
	
	}

}
