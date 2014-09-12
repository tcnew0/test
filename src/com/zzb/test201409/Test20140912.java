package com.zzb.test201409;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test20140912 {

    public static void main(String[] args) {

        String rexp = "\\w*!\\s*pass((\\s+\\w*)|(\\s*[&|]\\w*))";
        String s = "goto@#!!  pass test2334@#%&${}";

        Pattern p = Pattern.compile(rexp);
        Matcher m = p.matcher(s);
        
        // find
        if(m.find()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
