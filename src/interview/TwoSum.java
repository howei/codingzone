package interview;

import java.util.Arrays;
import java.util.HashMap;

/** Given an array of integers, find two numbers such that they add up to a specific target number.
*The function twoSum should return indices of the two numbers such that they add up to the target, 
*where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
*You may assume that each input would have exactly one solution.
*Input: numbers={2, 7, 11, 15}, target=9
*Output: index1=1, index2=2
*
*
*---From Leetcode
*Edited by Allie Yanhong Zhao on April 29, 2014
*
*
*@author discoveryleader
*@since April 29, 2014
*
*Goals: 
*1.Hashtable
*2.logic thinking and detailed thinking
*3.search in an array
*
*/
public class TwoSum {
    
	public static int[] twoSum(int[] numbers, int target) {  // Approach 1: By using HashMap , O(n)
		int[] result= new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  
		
	 
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {     //map.containsKey(key) = True or False
				int index = map.get(numbers[i]);   //value = map.get(key)
				result[0] = index+1 ;
				result[1] = i+1;
				break;
			} else {
				map.put(target - numbers[i], i);   //map.put(key, value)  ==> map(number, index)
			}
		}
	 
		return result;
		/*15 / 15 test cases passed.
		  Status: Accepted
	      Runtime: 468 ms*/
		
        
    }
	
	public static int[] twoSum2(int[] numbers, int target) { // Approach 2: By using sorted array O(nlogn)
		int[] result= new int[2];
		int N = numbers.length;  
	    //int[] sorted = new int[N];  
	       //System.arraycopy(numbers, 0, sorted, 0, N);    //copy array
	    int[] sorted=numbers.clone();   //Copy array
	      
	    Arrays.sort(sorted);    //Sorting array
	       //find the two numbers using the sorted arrays  
	    int first = 0;  
	    int second = sorted.length - 1;  
	    while(first < second){  
	    if(sorted[first] + sorted[second] < target){  
	         first++;  
	         continue;  
	    }  
	    else if(sorted[first] + sorted[second] > target){  
	         second--;  
	         continue;  
	    }  
	    else break;  
	    }  
	    int number1 = sorted[first];  
	    int number2 = sorted[second];  
	       
	       
	    //Find the two indexes in the original array    Search by O(n) , the index cannot guarantee to be the least small
	    int index1 = -1, index2 = -1;  
	    for(int i = 0; i < N; i++){  
	         if((numbers[i] == number1) || (numbers[i] == number2)){  
	             if(index1 == -1)  
	                 index1 = i + 1;  
	             else  
	                 index2 = i + 1;  
	        }  
	              
	    }  
	       
	    result[0]=index1;
	    result[1]=index2;
	    Arrays.sort(result); 
			
		return result;
		
	/*	15 / 15 test cases passed.
		Status:
	    Accepted
	    Runtime: 416 ms
	*/
		
	}
	
	public static void main(String[] args) {
		
		//Testing
		int []numbers ={2,3,4,4,6}; //{2,7,11,15};
		int target = 7;
		int[] result=new int[2];
		
		System.out.print("Input: numbers={");
		for (int x: numbers )
			if(x!=numbers[numbers.length-1])
		    System.out.print(x + ","); else System.out.print(x);
		System.out.print("},target="+target+"\n");
		
		result = twoSum2(numbers,target);  //Approach 2
		System.out.print("Output: index1 ="+result[0]+",index2="+result[1]+"\n");
		
		
		
	}

}
