package com.zzb.test201410;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test20141014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String reg = "<(S*?)[^>]*>.*?|<.*?/>";
		String reg = "<(.*?)[^>]*>.*?|<.*?/>";
		String des = "hello world <a>test</a>test for it";
		String des2 = "<aaaa/>";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(des2);
		if(m.matches()){
			System.out.println("∆•≈‰≥…π¶");
		}else{
			System.out.println("∆•≈‰ ß∞‹");
		}
	}

}
