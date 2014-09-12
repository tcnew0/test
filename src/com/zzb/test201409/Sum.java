package com.zzb.test201409;

@FunctionalInterface
public interface Sum<T> {
    
    /**
     * x + y
     * @param x
     * @param y
     * @return
     */
    int add(T t);
    
    /**
     * add and print
     * @param x
     * @param y
     */
    default int print(T t){
        int sum = add(t);
        System.out.println(sum);
        
        return sum;
    }
}
