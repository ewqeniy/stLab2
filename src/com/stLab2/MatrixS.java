package com.stLab2;

import javax.swing.*;

public class MatrixS extends AMatrix {
    MatrixS(int cows, int rows, IDrawer d) {
        super(cows, rows, d);
    }

    @Override
    public IVector createVector(int size) {
        return new VectorS(size);
    }

    @Override
    public void Draw() {
        DrawBorder(this, App.app.getPanel1(), App.app.isFlag());
        DrawItem(this, App.app.getPanel1(), App.app.isFlag());
    }

    @Override
    public void DrawBorder(AMatrix matrix, JPanel panel, boolean flag) {
        drawer.DrawBorder(this,panel,flag);
    }

    @Override
    public void DrawItem(AMatrix matrix, JPanel panel, boolean flag) {
        drawer.DrawItem(this,panel,flag);
    }
}
