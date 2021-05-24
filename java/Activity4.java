package activities;

import java.util.Arrays;

class Activity4 {
      
    public static void main(String args[]) {
        int[] data = { 4, 3, 2, 10, 12, 1, 5, 6 }; 
        ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
    
    static void ascendingSort(int array[]) {
        int size = array.length, i;
        
        for (i = 1; i < size; i++) { 				// i=1  ; i=2
            int key = array[i]; 					//key = 5 ; key = 1
            int j = i - 1; 							//j = 0 ; j= 1
            
            while (j >= 0 && key < array[j]) {   	// 5<9  // 1 < 9, 1 < 5
                array[j + 1] = array[j];          	// array[1]= 9 // array [2] = 9 ; array [1] = 5
                --j;                              	// -1 ; j=0 , j=-1
            }
            array[j + 1] = key;  					//  array[0]=5 ; array [0] = 1
        }
    }
}
