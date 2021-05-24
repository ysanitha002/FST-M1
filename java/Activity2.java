package activities;

import java.util.*;

public class Activity2 {
    public static void main(String[] args) {
        //Initialize the array
    	
    	int[] numArray = {10,77,10,54,-11,10};
    	
    	System.out.println("Given array :"+ Arrays.toString(numArray));
    	
    	int searchNum=10;
    	int fixedSum=30;
    	
    	System.out.println("Result :"+ result(numArray,searchNum,fixedSum));
    }
    
    public static boolean result(int[] numArray, int searchSum, int fixedSum )
    {
    	int totalSum=0;
    	
    	for (int num:numArray) {
    	
    		if(num==searchSum)
    			totalSum+=num;
    		
    		if(totalSum>fixedSum)
    			break;
    	     
    	}
    	
    	return totalSum == fixedSum;
    		
    }
}