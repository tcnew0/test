package com.zzb.test201409;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
        
        // forEach
        list.stream().forEach(new Consumer<Position>(){
            
            @Override
            public void accept(Position t) {
                System.out.println(t.toString());
            }
        });
    }
}
