package com.stLab2;

import javax.swing.*;
import java.awt.*;

public class WDrawer implements IDrawer{

    @Override
    public void DrawBorder(AMatrix matrix, JPanel panel, boolean flag) {
        Graphics g = panel.getGraphics();
        int Y=350;
        for (int i =0;i<matrix.getSCols();i++){
            int X=10;
            for (int j=0;j<matrix.getSRows();j++){
                if (flag) {
                    g.drawRect(X, Y, 30, 30);
                }
                X+=30;
            }
            Y+=30;
        }
    }

    @Override
    public void DrawItem(AMatrix matrix, JPanel panel1, boolean flag) {
        Graphics g = panel1.getGraphics();
        int Y=350;
        for (int i =0;i<matrix.getSCols();i++){
            int X=10;
            for (int j=0;j<matrix.getSRows();j++){
                if (matrix instanceof MatrixS){
                    if(matrix.get(j,i)!=0) g.drawString(String.valueOf(matrix.get(j,i)),X+5,Y+20);
                }
                else g.drawString(String.valueOf(matrix.get(j,i)),X+5,Y+20);
                X+=30;
            }
            Y+=30;
        }
    }
}
