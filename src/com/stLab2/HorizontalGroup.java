package com.stLab2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HorizontalGroup implements IMatrix {
    private ArrayList<IMatrix> matrixList = new ArrayList<>();
    //private IMatrix matrix;

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
            sum+=matrixList.get(i).getSCols();
        }
        //System.out.println("getSRows()-> " + sum);
        return sum;
    }

    @Override
    public int getSCols() {
        int max=-1;
        for (int i = 0; i < matrixList.size(); i++) {
            if (matrixList.get(i).getSRows() > max) max = matrixList.get(i).getSRows();
        }
        //System.out.println("getSCols()-> " + max);
        return max;
    }

    @Override
    public int get(int row, int col) {
        int nCol = 0;
        for (int i = 0; i < matrixList.size(); i++) {
            for (int j = 0; j < matrixList.get(i).getSCols(); j++) {
                if ((nCol + j) == col) {
                    if (row > matrixList.get(i).getSRows()-1) {
                        return 0;
                    }
                    return matrixList.get(i).get(row,j);
                }
            }
            nCol+=matrixList.get(i).getSCols();
        }
        return 0;
    }

    @Override
    public void set(int row, int col, int value) {
        int nCol = 0;
        for (int i = 0; i < matrixList.size(); i++) {
            for (int j = 0; j < matrixList.get(i).getSCols(); j++) {
                if ((nCol + j) == col) matrixList.get(i).set(row,j,value);
            }
            nCol=+matrixList.get(i).getSCols();
        }
    }

    @Override
    public IMatrix getComponent() {
        return null;
    }

    @Override
    public void Draw() {
        DrawBorder(getSRows(),getSCols(),App.app.getPanel1(),App.app.isFlag());
        for (int i = 0; i < getSCols() ; i++) {
            for (int j = 0; j < getSRows(); j++) {
                DrawItem(i,j,String.valueOf(get(i,j)),App.app.getPanel1());
            }
            System.out.println("");
        }
    }

    @Override
    public void DrawBorder(int Cols, int Rows, JPanel panel, boolean flag) {
        matrixList.get(0).DrawBorder(Cols, Rows, panel, flag);
    }

    @Override
    public void DrawItem(int Row, int Col, String value, JPanel panel1) {
        matrixList.get(0).DrawItem(Row, Col, value, panel1);
    }

    @Override
    public IIterator createIterator() {
        return null;
    }
}
