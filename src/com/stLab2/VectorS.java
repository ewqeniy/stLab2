package com.stLab2;

import java.util.HashMap;
import java.util.Map;

public class VectorS implements IVector {
    private int size;
    private Map<Integer, Integer> value;
    VectorS(int size){
        value = new HashMap<>();
        this.size = size;

    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getElement(int numb) {
        return this.value.getOrDefault(numb, 0);
    }

    @Override
    public void set(int numb, int value) {
        if (value != 0) this.value.put(numb,value);
        //System.out.print(value + " ");
//        System.out.println(this.value.containsKey(numb));
    }
}
