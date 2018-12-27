package com.stLab2;
public abstract class AMatrix implements IMatrix  {
    private IVector[] data;
    protected IDrawer drawer;

    AMatrix(int rows, int cows, IDrawer d) {
        data = new IVector[rows];
        for (int i=0;i<rows;i++){
            data[i] = createVector(cows);
        }
        drawer = d;
    }

    @Override
    public int getSRows() {
        return this.data.length;
    }

    @Override
    public int getSCols() {
        return data[0].getSize();
    }

    @Override
    public int get(int row, int col) {
        return data[row].getElement(col);
    }

    @Override
    public void set(int row, int col, int value) {
        data[row].set(col,value);
    }
    protected abstract IVector createVector(int size);
    @Override
    public IMatrix getComponent() {
        return this;
    }
}

