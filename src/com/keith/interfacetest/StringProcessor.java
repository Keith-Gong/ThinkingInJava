package com.keith.interfacetest;

/**
 * Created by Keith on 8/24/15.
 */
public abstract class StringProcessor implements Processor{
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    public abstract String process (Object input);
    public static String s = "ABcdEFg";
    public static void main (String args[]) {
        Apply.process(new Upcase(), s);
        Apply.process(new Downcase(), s);
    }
}

interface Processor {
    String name ();
    Object process (Object input);
}

class FilterAdapter implements Processor {
    Filter filter;

    public FilterAdapter (Filter filter) {
        this.filter = filter;
    }
    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform)input);
    }
}

class FilterProcessor {
    static Waveform waveform = new Waveform();
    /*public static void print () {
        Apply.process(new FilterProcessor(new LowPass(1.0), waveform));
    }*/
}
