package com.example.snakesladders;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SubGrid extends Rectangle {
    SubGrid (int x, int y){
        setWidth(MainGrid.subGridsize);
        setHeight(MainGrid.subGridsize);
        setFill(Color.YELLOWGREEN);
        setStroke(Color.BLACK);


    }
}
