package com.stLab2;

public interface IMatrix extends IDrawable{
    int getSRows();
    int getSCols();
    int get(int row, int col);
    void set(int row, int col, int value);
    IMatrix getComponent();
}
