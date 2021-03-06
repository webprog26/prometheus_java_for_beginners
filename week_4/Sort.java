/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_4;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author webprog26
 */
public class Sort {
    	private static void sort(int[] array, Comparator comp) {
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < array.length; i++) {
				int val = array[i];
				int j;
				for (j = i; j >= gap && comp.compare(array[j - gap], val) > 0; j -= gap) {
					array[j] = array[j - gap];
				}
				array[j] = val;
			}
		}
	}
        
        public static void main(String[] args) {
        	int[] array = {1,5,2,4,10,6,0,3,10};
		Comparator comp = new Comparator();
		          
		//Change your code here
		sort(array, new Comparator(){
                    @Override
                    public int compare(int a, int b) {
                        return super.compare(-a, -b);
                    }
                    
                });
                //Change your code here
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
    }
}
