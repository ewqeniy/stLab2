package com.stLab2;

import javax.swing.*;

public class MatrixS extends AMatrix{
    private boolean it = false;
    private IIterator iterator = createIterator("default");

    MatrixS(int cows, int rows, IDrawer d) {
        super(cows, rows, d);
    }

    @Override
    public IVector createVector(int size) {
        return new VectorS(size);
    }

    @Override
    public void Draw() {
        DrawBorder(getSRows(), getSCols(), App.app.getPanel1(), App.app.isFlag());
        iterator.reset();

        for (int i = 0; !iterator.isDone(); i++){
            for (int j =0; j<getSRows(); j++){
                DrawItem(i,j,iterator.getCurrent(),App.app.getPanel1());
                iterator.MoveNext();
            }
            System.out.println("");
        }
        System.out.println("");

        /*for (int i = 0; i < getSRows(); i++) {
            for (int j = 0; j < getSCols(); j++) {
                if (this.get(i, j) != 0) DrawItem(i, j, String.valueOf(this.get(i, j)), App.app.getPanel1());
                else DrawItem(i, j, "", App.app.getPanel1());
            }
            System.out.println("");
        }
        System.out.println("");*/
    }

    @Override
    public void DrawBorder(int Cols, int Rows, JPanel panel, boolean flag) {
        drawer.DrawBorder(Cols, Rows, panel, flag);
    }

    @Override
    public void DrawItem(int Row, int Col, String value, JPanel panel1) {
        drawer.DrawItem(Row, Col, value, panel1);
    }

    @Override
    public IIterator createIterator(String flag) {
        if (flag.equals("default")) return new IteratorS();
        if (flag.equals("decorator")) return new IteratorDecor(iterator,this);
        return null;
    }

    public class IteratorS implements IIterator {
        private int currentRow = 0;
        private int currentCol = 0;

        @Override
        public void reset() {
            currentRow = 0;
            currentCol = 0;
        }

        @Override
        public void MoveNext() {
            if (currentCol == getSCols() - 1) {
                currentCol = 0;
                currentRow++;
            } else currentCol++;
        }

        @Override
        public String getCurrent() {
            if (get(currentRow, currentCol) != 0)
                return String.valueOf(get(currentRow, currentCol));
            else return "";
        }

        @Override
        public boolean isDone() {
            if (currentRow == getSRows()) return true;
            else return false;
        }
    }
}
