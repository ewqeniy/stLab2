package com.stLab2;

import javax.swing.*;

public class IteratorN implements IIterator {
    private int currentRow = 0;
    private int currentCol = 0;
    private IMatrix matrix;

    IteratorN(IMatrix matrix) {
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
        return String.valueOf(this.matrix.get(currentRow,currentCol));
    }

    @Override
    public boolean isDone() {
        return currentRow == matrix.getSRows();
    }
}
