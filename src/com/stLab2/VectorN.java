package com.stLab2;

public class VectorN implements IVector {
    private int size;
    private int[] value;
    VectorN(int size){
        value = new int[size];
        this.size = size;
    }
    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getElement(int numb) {
        return this.value[numb];
    }

    @Override
    public void set(int numb, int value) {
        this.value[numb] = value;
        //System.out.print(value + " ");
    }
}
