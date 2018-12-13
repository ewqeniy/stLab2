package com.stLab2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class VerticalGroup implements IMatrix{
    private ArrayList<IMatrix> matrixList = new ArrayList<>();
    //private IMatrix matrix;

    public VerticalGroup(IMatrix ... matrix) {
        this.matrixList.addAll(Arrays.asList(matrix));
    }

    void AddMatrix(IMatrix matrix){
        matrixList.add(matrix);
    }
    @Override
    public int getSCols() {
        int sum=0;
        for (int i = 0; i < matrixList.size(); i++) {
            sum+=matrixList.get(i).getSRows();
        }
        //System.out.println("getSRows()-> " + sum);
        return sum;
    }

    @Override
    public int getSRows() {
        int max=-1;
        for (int i = 0; i < matrixList.size(); i++) {
            if (matrixList.get(i).getSCols() > max) max = matrixList.get(i).getSCols();
        }
        //System.out.println("getSCols()-> " + max);
        return max;
    }

    @Override
    public int get(int row, int col) {
        int nRow = 0;
        for (int i = 0; i < matrixList.size(); i++) {
            for (int j = 0; j < matrixList.get(i).getSRows(); j++) {
                if ((nRow + j) == row) {
                    if (col > matrixList.get(i).getSCols()-1) {
                        return 0;
                    }
                    return matrixList.get(i).get(j,col);
                }
            }
            nRow+=matrixList.get(i).getSRows();
        }
        return 0;
    }

    @Override
    public void set(int row, int col, int value) {
        int nRow = 0;
        for (int i = 0; i < matrixList.size(); i++) {
            for (int j = 0; j < matrixList.get(i).getSRows(); j++) {
                if ((nRow + j) == row) matrixList.get(i).set(j,col,value);
            }
            nRow=+matrixList.get(i).getSRows();
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