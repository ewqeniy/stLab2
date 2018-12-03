package com.stLab2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HorizontalGroup implements IMatrix {
    private ArrayList<IMatrix> matrixList = new ArrayList<>();

    public HorizontalGroup(IMatrix ... matrix) {
        this.matrixList.addAll(Arrays.asList(matrix));
    }

    void AddMatrix(IMatrix matrix){
        matrixList.add(matrix);
    }
    @Override
    public int getSRows() {
        int sum=0;
        for (int i = 0; i < matrixList.size(); i++) {
            sum+=matrixList.get(i).getSRows();
        }
        return sum;
    }

    @Override
    public int getSCols() {
        int max=-1;
        for (int i = 0; i < matrixList.size(); i++) {
            if (matrixList.get(i).getSCols() > max) max = matrixList.get(i).getSCols();
        }
        return max;
    }

    @Override
    public int get(int row, int col) {
        return 0;
    }

    @Override
    public void set(int row, int col, int value) {

    }

    @Override
    public IMatrix getComponent() {
        return null;
    }

    @Override
    public void Draw() {
        for (int i = 0; i < getSRows(); i++) {
            for (IMatrix aMatrixList : matrixList) {
                for (int k = 0; k < aMatrixList.getSRows(); k++) {
                    aMatrixList.Draw();
                }
            }
        }
    }

    @Override
    public void DrawBorder(int Cols, int Rows, JPanel panel, boolean flag) {

    }

    @Override
    public void DrawItem(int Row, int Col, String value, JPanel panel1) {

    }
}
