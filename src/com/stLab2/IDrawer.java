package com.stLab2;

import javax.swing.*;

public interface IDrawer{
    public void DrawBorder(int Cols, int Rows, JPanel panel, boolean flag);
    public void DrawItem(int Row, int Col, String value, JPanel panel1);
}
