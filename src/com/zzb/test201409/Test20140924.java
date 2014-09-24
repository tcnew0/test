package com.zzb.test201409;

import java.util.ArrayList;
import java.util.List;

/**
 * ≤‚ ‘list addAll
 * @author guanzhenxing
 *
 */
public class Test20140924 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List l_one = generalList(1,5);
		List l_two = generalList(6,10);
		List l_three = generalList(11,20);
		
		//add
		l_one.addAll(l_two);
		l_one.addAll(l_three);
		
		System.out.println(l_one);// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
	}
	
	@SuppressWarnings({ "serial", "rawtypes" })
	public static List generalList(final int s,final int e){
		if(e < s){
			return null;
		}
		return new ArrayList<Integer>(){
			{
				for(int i=s;i<=e;i++){
					this.add(i);
				}
			}
		};
	}

}
