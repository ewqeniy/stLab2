package com.stLab2;
import java.util.Random;

class initMatrix {
    static void fill(IMatrix matrix, int notNULL, int maxValue){
        Random random = new Random();
        int index = 0;
        for(int i=0;i<matrix.getSRows();i++){
            for(int j=0;j<matrix.getSCols();j++){
                if (index == notNULL){
                    matrix.set(i,j,0);

                }else{
                    matrix.set(i,j,random.nextInt(maxValue));
                    if (matrix.get(i,j) !=0) index++;
                }
            }
        }
    }
}
