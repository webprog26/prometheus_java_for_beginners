/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci_number;

import static fibonacci_number.FibonacciNumber.getFibonacciNumber;

/**
 *
 * @author webpr
 */
public class Fibonacci {
   
	public long getNumber(int position){
            if(position <= 0){
                return -1;
            }
            if(position == 1 || position == 2){
                return 1;
            }
            return getNumber(position - 1) + getNumber(position - 2);
	}

}
