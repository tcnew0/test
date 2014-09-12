package com.zzb.test201409;

import java.util.ArrayList;
import java.util.List;

/**
 * java 8 新特性
 * 1. 函数式接口
 * 2.lambda表达式引入
 * 3.集合操作
 * @author guanzhenxing
 *
 */
public class Test20140911 {
    
    @SuppressWarnings({ "rawtypes", "serial", "unchecked" })
    public static void main(String[] args) {
        // list
        List list = new ArrayList<Position>(){
            {
                Position p = new Position();
                for(int i = 0 ; i<10 ; i++){
                    p =  p.clone();
                    p.setX(i);
                    p.setY(i);
                    this.add(p);
                }
            }
        };
        
        //  (t)->{System.out.println(t.toString())};
        list.stream().forEach( (t)->{System.out.println(t.toString());});
        
        // filter
        long i = list.stream().filter( (t) -> {
            if(((Position)t).getX() == 0){
                System.out.println(((Position)t).getX()); 
                return true;
            }
            
            return false;
        }).count();
        
        System.out.println(i);
    }
}
