package practice;

import java.util.HashMap;

public class DuplicateStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "i am am man man";
		
		
		String[] t = s.split(" ");
		
		HashMap<Integer,String> hm = new HashMap<>();
		
		for(int i = 0;i<t.length;i++){
			
			
			if(hm.get(i)!=t[i]){
				
				hm.put(i, t[i]);
				
			}else{
				
			}
			
			
		}
		
		int[] arr = {6,1,1,2,3,4,5,5,6};
		
		
		for(int i = 0;i<arr.length;i++){
			
			for(int j = i+1; j<arr.length;j++){
				
				if(arr[i]==arr[j]){
					
					System.out.println("element " + arr[i] + " found duplicate");
					
				}
				
			}
			
		}
		
		int k;
		/*
		for(int i =0;i<arr.length;i++){
			
			for(int j = i+1; j<arr.length;j++){
				
				if(arr[i]>arr[j]){
					
					k = arr[j];
					arr[j] = arr[i];
					arr[i] = k;  
					
				}
				
			}
			
		}
		
		for(int i = 0;i<arr.length;i++){
			
			System.out.println(arr[i]);
			
		}*/
		
		int x = 2;
		int y = 10;
		
		x = x+y;
		y = x-y;
		x = x-y;
		
		  int[] arr1 = {10,34,2,56,7,67,88,42};
	        int[] arr2 = doSelectionSort(arr1);
	        
	        for(int i:arr2){
	            System.out.print(i);
	            System.out.print(", ");
	        }
		
	}
	
	 public static int[] doSelectionSort(int[] arr){
         
	        for (int i = 0; i < arr.length - 1; i++)
	        {
	            int index = i;
	            for (int j = i + 1; j < arr.length; j++)
	                if (arr[j] < arr[index]) {
	                    index = j;
	                }
	            int smallerNumber = arr[index];  
	            arr[index] = arr[i];
	            arr[i] = smallerNumber;
	        }
	        return arr;
	    }

}
