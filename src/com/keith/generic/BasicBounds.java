package com.keith.generic;

import java.awt.*;

/**
 * Created by keith on 9/1/2015.
 */
public class BasicBounds {
    public static void main (String args[]) {

    }
}

interface HasColor {
    Color getColor ();
}

class Colored <T extends HasColor> {
    T item;
    public Colored(T item) {
        this.item = item;
    }

    Color color () {
        return item.getColor();
    }
}

class Dimension {
    public int x, y, z;
}

class ColoredDimension <T extends Dimension & HasColor> {
    T item;
    ColoredDimension (T item) {
        this.item = item;
    }
    T getItem () {
        return this.item;
    }

    Color color () {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY () {
        return item.y;
    }

    int getZ () {
        return item.z;
    }
}

interface Weight {
    int weight ();
}

class Solid<T extends Dimension & HasColor & Weight> {
    T item;
    Solid(T item) {
        this.item = item;
    }
    Color color () {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY () {
        return item.y;
    }

    int getZ () {
        return item.z;
    }

    int getWeight () {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor, Weight {

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}
