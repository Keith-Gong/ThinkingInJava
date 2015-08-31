package com.keith.interfacetest;

/**
 * Created by Keith on 8/23/15.
 */
public class Waveform {
    private static long counter;
    private final long id = counter ++ ;
    public String toString () {
        return "Waveform" + id;
    }
}

class Filter {
    public String name () {
        return getClass().getSimpleName();
    }
    public Waveform process (Waveform input) {
        return input;
    }
}

class LowPass extends Filter {
    double cutOff;
    public LowPass (double cutOff) {
        this.cutOff = cutOff;
    }
    public Waveform process (Waveform input) {
        return input;
    }
}

class HighPass extends Filter {
    double cutOff;
    public HighPass (double cutOff) {
        this.cutOff = cutOff;
    }
    public Waveform process (Waveform input) {
        return input;
    }
}
