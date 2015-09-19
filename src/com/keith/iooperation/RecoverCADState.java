package com.keith.iooperation;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by Keith on 9/20/15.
 */
public class RecoverCADState {
    public static void main (String args[]) throws Exception{
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("CADState.out")
        );

        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }
}
