package com.keith.extend;

import org.omg.CORBA.NO_IMPLEMENT;

/**
 * Created by keith on 8/20/2015.
 */


enum Note {
    MIDDLE_C,
    C_SHARP,
    B_FLAT;
}

class Instrument {
    public void play (Note note) {
        System.out.println("Instrument : " + note);
    }
}

class Wind extends Instrument {
    public void play (Note note) {
        System.out.println("Wind : " + note);
    }
    public void playWithWind () {
        System.out.println("Play with wind");
    }
}

public class Music {
    static {
        System.out.println("Ss");
    }
    public static void tune (Instrument instrument) {
        instrument.play(Note.MIDDLE_C);
    }
    public static void main (String args[]) {
        //Wind wind = new Wind();
        //tune(wind);
        Instrument instrument = new Wind();
        instrument.play(Note.C_SHARP);
    }
}






