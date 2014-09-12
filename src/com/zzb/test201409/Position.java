package com.zzb.test201409;

public class Position  implements Cloneable{
    
    private int x;
    private int y;
    
    public Position() {
        super();
    }

    public Position(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the sum
     */
//    public int getSum(Sum sum) {
//        return  sum.print(x,y);
//    }

    @Override
    protected Position clone()  {
        Position p = null;
        try {
            p = (Position) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        return p;
    }

    @Override
    public String toString() {
        
        return "x : "+this.getX()+",y : "+this.getY();
    }
    
}
