package com.stLab2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.sql.Types.NULL;

public class RenumDecorator implements IMatrix {
    private IMatrix matrix;
    private int swapedCol1=0;
    private int swapedCol2=0;
    private int swapedRow1=0;
    private int swapedRow2=0;

    RenumDecorator(IMatrix matrix) {
        this.matrix = matrix;
        SwapCol(matrix);
        SwapRow(matrix);
    }

    public void SwapCol(IMatrix matrix) {
        /*Генерируем рандомный порядок для перестановки.*/
        Random rnd = new Random();

        while (swapedCol1 == swapedCol2){
            swapedCol1 = rnd.nextInt(matrix.getSRows());
            swapedCol2 = rnd.nextInt(matrix.getSRows());
        }
    }

    public void SwapRow(IMatrix matrix){
        Random rnd = new Random();
        while (swapedRow1 == swapedRow2){
            swapedRow1 = rnd.nextInt(matrix.getSCols());
            swapedRow2 = rnd.nextInt(matrix.getSCols());
        }
    }

    @Override
    public int getSRows() {
        return matrix.getSRows();
    }

    @Override
    public int getSCols() {
        return matrix.getSCols();
    }

    @Override
    public int get(int row, int col) {
        if (row == swapedRow1) return matrix.get(swapedRow2,col);
        if (row == swapedRow2) return matrix.get(swapedRow1,col);
        if (col == swapedCol1) return matrix.get(row,swapedCol2);
        if (col == swapedCol2) return matrix.get(row,swapedCol1);
        return matrix.get(row, col);
    }

    @Override
    public void set(int row, int col, int value) {
        matrix.set(row, col, value);
    }

    @Override
    public IMatrix getComponent() {
        swapedCol1= -1;
        swapedCol2= -1;
        swapedRow1= -1;
        swapedRow2= -1;
        return matrix.getComponent();
    }

    @Override
    public void Draw() {
        DrawBorder(matrix.getSRows(),matrix.getSRows(),App.app.getPanel1(),App.app.isFlag());
        IIterator iterator = createIterator();

        for (int i = 0; !iterator.isDone(); i++){
            for (int j =0; j<matrix.getSRows(); j++){
                if (i == swapedRow1){
                    DrawItem(swapedRow2,j,iterator.getCurrent(),App.app.getPanel1());
                    iterator.MoveNext();
                    continue;
                }
                if (i == swapedRow2){
                    DrawItem(swapedRow1,j,iterator.getCurrent(),App.app.getPanel1());
                    iterator.MoveNext();
                    continue;
                }
                if (j == swapedCol1){
                    DrawItem(i,swapedCol2,iterator.getCurrent(),App.app.getPanel1());
                    iterator.MoveNext();
                    continue;
                }
                if (j == swapedCol2){
                    DrawItem(i,swapedCol1,iterator.getCurrent(),App.app.getPanel1());
                    iterator.MoveNext();
                    continue;
                }
                DrawItem(i,j,iterator.getCurrent(),App.app.getPanel1());
                iterator.MoveNext();
            }
            System.out.println("");
        }


        /*while (!iterator.isDone()){
            for (int i = 0; i < matrix.getSRows(); i++) {
                for (int j = 0; j < matrix.getSCols(); j++) {
                    s++;
                    DrawItem(i,j,iterator.getCurrent(),App.app.getPanel1());
                    iterator.MoveNext();
                }
                System.out.println("");
            }
        }*/
        /*for (int i = 0; i < getSRows(); i++) {
            for (int j = 0; j < getSCols(); j++) {
                DrawItem(i,j, String.valueOf(get(i,j)), App.app.getPanel1());
            }
            System.out.println("");
        }
        System.out.println("");*/
    }

    @Override
    public void DrawBorder(int Cols, int Rows, JPanel panel, boolean flag) {
        matrix.DrawBorder(Cols,Rows,panel,flag);
    }

    @Override
    public void DrawItem(int Row, int Col, String value, JPanel panel1) {
        matrix.DrawItem(Row,Col,value,panel1);
    }

    @Override
    public IIterator createIterator() {
        return matrix.createIterator();
    }
}
