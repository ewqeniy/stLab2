package com.stLab2;

public class IteratorDecor implements IIterator {
    private int currentRow = 0;
    private int currentCol = 0;
    private IIterator iterator;
    private IMatrix matrix;
    public IteratorDecor(IIterator iterator, IMatrix matrix) {
        this.iterator = iterator;
        this.matrix = matrix;
    }

    @Override
    public void reset() {
        iterator.reset();
    }

    @Override
    public void MoveNext() {

        if (currentRow % 2 != 1) iterator.MoveNext();
        else {
            if (currentCol == matrix.getSRows() - 1) {
                currentCol = 0;
                currentRow++;
            } else currentCol++;
        }
    }

    @Override
    public String getCurrent() {
        return iterator.getCurrent();
    }

    @Override
    public boolean isDone() {
        return iterator.isDone();
    }
}
