package com.stLab2;

import javax.swing.*;

public class CDrawer implements IDrawer {

    @Override
    public void DrawBorder(AMatrix matrix, JPanel panel, boolean flag) {
        //
    }

    @Override
    public void DrawItem(AMatrix matrix, JPanel panel1, boolean flag) {
        String Format;
        if (flag)  Format = "| %3s |";
        else Format = " %3s ";
        if (flag) System.out.format("%n-----------------------------------%n");
        for (int i=0;i<matrix.getSCols();i++){
            for (int j=0;j<matrix.getSRows();j++){
                if (matrix instanceof MatrixS){
                    if(matrix.get(j,i)!=0) System.out.format(Format, matrix.get(j,i));
                    else System.out.format(Format, "");
                }
                else System.out.format(Format, matrix.get(j,i));
                //System.out.print(matrix.get(j,i) + " ");
            }
            if (flag) System.out.format("%n-----------------------------------%n");
            else System.out.format("%n");
        }
    }
}
