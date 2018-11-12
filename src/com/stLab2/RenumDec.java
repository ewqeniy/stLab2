package com.stLab2;

import javax.swing.*;
import java.util.Random;

public class RenumDec implements IMatrix {
    private IMatrix matrix;

    public RenumDec(IMatrix matrix) {
        this.matrix = matrix;
    }

    public void RenumRow(IMatrix matrix) {
        Random rnd = new Random();
        int out = rnd.nextInt(matrix.getSRows());
        int to = rnd.nextInt(matrix.getSRows());
        for (int j = 0; j < matrix.getSCols(); j++) {
            int temp = matrix.get(out, j);
            matrix.set(out, j, matrix.get(to, j));
            matrix.set(to, j, temp);
        }
    }

    public void RenumCol

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
        return 0;
    }

    @Override
    public void set(int row, int col, int value) {

    }

    @Override
    public void Draw() {

    }

    @Override
    public void DrawBorder(AMatrix matrix, JPanel panel, boolean flag) {

    }

    @Override
    public void DrawItem(AMatrix matrix, JPanel panel1, boolean flag) {

    }
}
