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

        if((currentRow+1)%2!=1){
            if (currentCol == matrix.getSRows() - 1) {
                currentCol = 0;
                currentRow++;
                iterator.MoveNext();
            } else {
                iterator.MoveNext();
                currentCol++;
            }
        }
        else {
            for (int i = 0; i < matrix.getSRows(); i++) {
                iterator.MoveNext();
            }
            currentRow++;
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
