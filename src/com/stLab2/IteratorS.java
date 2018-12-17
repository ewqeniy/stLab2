package com.stLab2;

public class IteratorS implements IIterator {
    private int currentRow = 0;
    private int currentCol = 0;
    private IMatrix matrix;

    public IteratorS(IMatrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void reset() {
        currentRow=0;
        currentCol=0;
    }

    @Override
    public void MoveNext() {
        if (currentCol == matrix.getSCols()-1){
            currentCol=0;
            currentRow++;
        }
        else currentCol++;
    }

    @Override
    public String getCurrent() {
        if (this.matrix.get(currentRow,currentCol)!= 0) return String.valueOf(this.matrix.get(currentRow,currentCol));
        else return "";
    }

    @Override
    public boolean isDone() {
        if (currentRow == matrix.getSRows()) return true;
        else return false;
    }
}
