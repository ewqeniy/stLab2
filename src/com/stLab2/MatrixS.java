package com.stLab2;

import javax.swing.*;

public class MatrixS extends AMatrix{
    boolean it = false;
    IIterator s;

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

        IIterator iterator = createIterator();

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
    public IIterator createIterator() {
        return new IteratorS(this);
    }

    class sIterator{

    }
}
