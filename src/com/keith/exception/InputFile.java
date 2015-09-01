package com.keith.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by keith on 8/25/2015.
 */
public class InputFile {
    private BufferedReader bufferedReader;
    public InputFile (String name) throws Exception {
        try {
            bufferedReader = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException e) {
            System.out.println("Can not Open " + name);
            throw e;
        } catch (Exception e) {
            try {
                bufferedReader.close();
            } catch (IOException e1) {
                System.out.println("in.close () unsuccessful");
            }
            throw e;
        } finally {

        }
    }

    public String getLine () {
        String s;
        try {
            s = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }
}
