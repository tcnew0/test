package com.zzb.test201409;

import java.util.Arrays;

/**
 * 1. test ArrayList 是否contain null
 * @author guanzhenxing
 *
 */
public class Test20140923 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. test ArrayList 是否contain null
		System.out.println(Arrays.asList(null,null,null,null,null));
		System.out.println(Arrays.asList(null,null,null,null,null).contains(null));
		System.out.println("----------------------------------------------");
		
		// 2. String对象的创建
		String temp = "aa";
		String var_a = "a";
		String var_b = "a";
		String var_c = "a";
		String var_d = "a"+"a";
		String var_e = "a".concat("a");
		String var_aa = new String("a");
		System.out.println(var_a == var_b);//true
		System.out.println(var_a == var_c);//true
		System.out.println(var_a == var_aa);//false
		System.out.println(var_d == temp);//true
		System.out.println(var_e == temp);//false
		
		var_a += var_b;
		System.out.println(var_a == temp);//false
		
		// = 和equals 的区别
		var_c = var_c + var_b;
		System.out.println(var_c.equals(temp));//true
		System.out.println(var_c == temp);//false
	}

}
