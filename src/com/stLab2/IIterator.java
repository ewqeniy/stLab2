package com.stLab2;

public interface IIterator {
    void reset();
    void MoveNext();
    String getCurrent();
    boolean isDone();
}
